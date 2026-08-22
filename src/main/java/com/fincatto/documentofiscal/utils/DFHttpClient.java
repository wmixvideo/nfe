package com.fincatto.documentofiscal.utils;

import com.fincatto.documentofiscal.DFConfig;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy;
import org.apache.hc.client5.http.ssl.DefaultHostnameVerifier;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.reactor.ssl.SSLBufferMode;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

import javax.net.ssl.SSLContext;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Cliente HTTP compartilhado para os webservices SOAP da SEFAZ, baseado no
 * {@code org.apache.httpcomponents.client5:httpclient5}. Substitui, servico a servico,
 * o transporte que hoje o Axis2 provia, reaproveitando o mesmo {@link SSLContext} do
 * certificado A1 usado no mTLS.
 * <p>
 * Uma unica instancia deve ser compartilhada entre todas as chamadas de um mesmo
 * {@link com.fincatto.documentofiscal.DFConfig} - o pool de conexoes interno cuida do reuso
 * de sockets TLS entre requisicoes.
 * @author Marcos Lombardi de Andrade
 */
public class DFHttpClient implements Closeable {

    // A SEFAZ fecha conexoes keep-alive do lado dela sem que o pool perceba, deixando sockets
    // em CLOSE_WAIT em instancias de vida longa. As tres politicas abaixo mitigam isso:
    // TTL limita a vida total de cada conexao (mesmo em uso constante); a validacao apos
    // inatividade descarta conexoes mortas antes do reuso; e a thread de despejo (evict*)
    // fecha proativamente conexoes ociosas/expiradas sem depender de uma proxima requisicao.
    private static final Timeout TEMPO_VIDA_MAXIMO_CONEXAO = Timeout.ofMinutes(1);
    private static final Timeout VALIDAR_APOS_INATIVIDADE = Timeout.ofSeconds(2);
    private static final TimeValue OCIOSIDADE_MAXIMA_CONEXAO = TimeValue.ofSeconds(30);

    private final CloseableHttpClient httpClient;

    /**
     * @param sslContext SSLContext ja configurado com o certificado A1 e a cadeia da SEFAZ,
     * tipicamente obtido de {@link DFSocketFactory#getSslContext()}.
     * @param config configuracao de timeouts e protocolos TLS a ser usada nas requisicoes -
     * ver o comentario no construtor sobre o mapeamento (historico, de compatibilidade com o
     * Axis2) entre {@link DFConfig#getSoTimeoutEmMillis()}/{@link DFConfig#getTimeoutRequisicaoEmMillis()}
     * e os timeouts de conexao/leitura do httpclient5.
     */
    public DFHttpClient(final SSLContext sslContext, final DFConfig config) {
        // SSLConnectionSocketFactory (usada em versoes anteriores desta classe) esta deprecated
        // no httpclient5 5.6+ em favor de TlsSocketStrategy/DefaultClientTlsStrategy.
        final DefaultClientTlsStrategy tlsStrategy =
                new DefaultClientTlsStrategy(sslContext, config.getSSLProtocolos(), null, SSLBufferMode.STATIC, new DefaultHostnameVerifier());

        // Mapeamento alinhado ao Javadoc de DFConfig (nao ao que o Axis2/MessageContextFactory fazia):
        // getSoTimeoutEmMillis() = "timeout do socket" -> timeout de LEITURA da resposta (RequestConfig,
        // equivalente ao antigo SO_TIMEOUT); getTimeoutRequisicaoEmMillis() = "timeout da requisicao" ->
        // timeout de CONEXAO (ConnectionConfig), o tempo para estabelecer a conexao antes de enviar a
        // requisicao. O MessageContextFactory (Axis2, legado) usa esses dois getters trocados em relacao
        // a este mapeamento; ao migrar um servico do Axis2 para o DFHttpClient, revisar os valores de
        // DFConfig se o comportamento historico de timeout precisar ser preservado.
        final ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(config.getTimeoutRequisicaoEmMillis()))
                .setTimeToLive(TEMPO_VIDA_MAXIMO_CONEXAO)
                .setValidateAfterInactivity(VALIDAR_APOS_INATIVIDADE)
                .build();

        final PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setTlsSocketStrategy(tlsStrategy)
                .setDefaultConnectionConfig(connectionConfig)
                .build();

        final RequestConfig requestConfig = RequestConfig.custom()
                .setResponseTimeout(Timeout.ofMilliseconds(config.getSoTimeoutEmMillis()))
                .build();

        this.httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .evictExpiredConnections()
                .evictIdleConnections(OCIOSIDADE_MAXIMA_CONEXAO)
                // O DefaultHttpRequestRetryStrategy do httpclient5, instalado por padrao quando
                // nenhuma estrategia e configurada, reenvia automaticamente em HTTP 429/503 sem
                // verificar se o metodo e idempotente - e toda requisicao feita por este cliente
                // e um POST de operacao fiscal (lote de autorizacao, evento, etc.), nunca
                // seguramente reenviavel sem uma decisao de negocio. Desabilitar o retry
                // automatico transfere essa decisao para quem chama postSoap.
                .disableAutomaticRetries()
                .build();
    }

    /**
     * Envia um envelope SOAP 1.2 via POST e devolve o corpo da resposta como texto.
     *
     * @param endpoint URL do webservice da SEFAZ.
     * @param soapAction action da operacao, conforme o WSDL (ex.: {@code .../NFeStatusServico4/nfeStatusServicoNF}).
     * @param envelopeXml envelope SOAP 1.2 completo, tipicamente montado por {@link DFSoapEnvelope#envelopar}.
     * @return o corpo da resposta HTTP.
     * @throws DFSoapFaultException se a SEFAZ devolver um {@code soap:Fault} reconhecivel no corpo,
     * mesmo quando acompanhado de um codigo HTTP de erro (a SEFAZ as vezes devolve Fault sob HTTP 500,
     * assim como o Axis2/HTTPSender legado tratava esse cenario).
     * @throws IOException em caso de falha de conexao ou resposta HTTP de erro (codigo &gt;= 300) cujo
     * corpo nao seja um {@code soap:Fault} reconhecivel.
     */
    public String postSoap(final String endpoint, final String soapAction, final String envelopeXml) throws IOException, DFSoapFaultException {
        final HttpPost post = new HttpPost(endpoint);
        post.setEntity(new StringEntity(envelopeXml, ContentType.create("application/soap+xml", StandardCharsets.UTF_8)));
        // SOAP 1.2 carrega a action dentro do Content-Type, nao num header SOAPAction separado (como no SOAP 1.1)
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/soap+xml; charset=UTF-8; action=\"" + soapAction + "\"");

        try {
            return this.httpClient.execute(post, response -> {
                final HttpEntity entity = response.getEntity();
                final String corpo = entity == null ? "" : EntityUtils.toString(entity, StandardCharsets.UTF_8);
                if (response.getCode() >= 300) {
                    // HttpClientResponseHandler.handleResponse so pode lancar HttpException/IOException,
                    // entao a DFSoapFaultException (checked, nao-IOException) precisa atravessar como
                    // RuntimeException e ser desembrulhada depois do execute() abaixo.
                    final DFSoapFaultException fault = DFSoapEnvelope.tentarReconhecerFault(corpo);
                    if (fault != null) {
                        throw new FaultCarrier(fault);
                    }
                    throw new ClientProtocolException("SEFAZ respondeu HTTP " + response.getCode() + ": " + corpo);
                }
                return corpo;
            });
        } catch (final FaultCarrier carrier) {
            throw carrier.fault;
        }
    }

    /**
     * Carrega uma {@link DFSoapFaultException} para fora do handler de {@link #postSoap}, cuja
     * assinatura funcional nao permite excecoes checked alem de {@code IOException}.
     */
    private static final class FaultCarrier extends RuntimeException {
        private static final long serialVersionUID = 1L;
        private final transient DFSoapFaultException fault;

        FaultCarrier(final DFSoapFaultException fault) {
            super(fault);
            this.fault = fault;
        }
    }

    /**
     * Libera o pool de conexoes. Deve ser chamado quando nenhuma outra chamada a
     * {@link #postSoap} for mais feita por esta instancia.
     */
    @Override
    public void close() throws IOException {
        this.httpClient.close();
    }
}
