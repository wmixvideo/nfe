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
 * {@code org.apache.httpcomponents.client5:httpclient5}.
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
     * @param config configuracao de timeouts e protocolos TLS a ser usada nas requisicoes
     */
    public DFHttpClient(final SSLContext sslContext, final DFConfig config) {
        final DefaultClientTlsStrategy tlsStrategy =
                new DefaultClientTlsStrategy(sslContext, config.getSSLProtocolos(), null, SSLBufferMode.STATIC, new DefaultHostnameVerifier());

        final ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(comFallback(config.getTimeoutRequisicaoEmMillis(), DFSocketFactory.TIMEOUT_PADRAO_EM_MILLIS)))
                .setTimeToLive(TEMPO_VIDA_MAXIMO_CONEXAO)
                .setValidateAfterInactivity(VALIDAR_APOS_INATIVIDADE)
                .build();

        final PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setTlsSocketStrategy(tlsStrategy)
                .setDefaultConnectionConfig(connectionConfig)
                // Defaults do httpclient5 quando nao configurados (5 por rota, 25 no total) sao
                // baixos demais para emissao de documentos fiscais em lote contra o mesmo
                // autorizador - ver DFConfig.getMaxConexoesPorRota()/getMaxConexoesTotal().
                .setMaxConnPerRoute(comFallback(config.getMaxConexoesPorRota(), 20))
                .setMaxConnTotal(comFallback(config.getMaxConexoesTotal(), 40))
                .build();

        final RequestConfig requestConfig = RequestConfig.custom()
                // getSoTimeoutEmMillis() aceita zero como valor valido (convencao classica de
                // java.net.Socket#setSoTimeout: zero = timeout infinito) - so um valor negativo
                // cai no fallback, por isso o uso de comFallbackPermitindoZero aqui.
                .setResponseTimeout(Timeout.ofMilliseconds(comFallbackPermitindoZero(config.getSoTimeoutEmMillis(), DFSocketFactory.SO_TIMEOUT_PADRAO_EM_MILLIS)))
                // Default do httpclient5 quando nao configurado e 3 minutos - tempo demais para
                // reter uma thread da aplicacao esperando uma conexao do pool sob pico de carga.
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(comFallback(config.getTimeoutFilaConexaoEmMillis(), 10_000)))
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
                // Os endpoints da SEFAZ sao fixos e conhecidos - nao ha cenario legitimo de
                // redirect nas chamadas deste cliente. Desabilitar reforca essa premissa como
                // defesa em profundidade (o DefaultRedirectStrategy padrao ja nao seguiria um
                // redirect de POST, exceto 303, mas aqui a intencao fica explicita e auditavel).
                .disableRedirectHandling()
                .build();
    }

    /**
     * Aplica o fallback documentado nos getters de timeout/pool de {@link DFConfig}: um valor
     * configurado nao positivo (zero ou negativo) e substituido pelo padrao.
     */
    private static int comFallback(final int valorConfigurado, final int valorPadrao) {
        return valorConfigurado > 0 ? valorConfigurado : valorPadrao;
    }

    /**
     * Mesmo fallback de {@link #comFallback}, mas aceitando zero como valor valido (usado por
     * {@link DFConfig#getSoTimeoutEmMillis()}, cujo contrato documentado segue a convencao
     * classica de {@code java.net.Socket#setSoTimeout}: zero significa timeout infinito).
     */
    private static int comFallbackPermitindoZero(final int valorConfigurado, final int valorPadrao) {
        return valorConfigurado >= 0 ? valorConfigurado : valorPadrao;
    }

    /**
     * Envia um envelope SOAP 1.2 via POST e devolve o corpo da resposta como texto.
     *
     * @param endpoint URL do webservice da SEFAZ.
     * @param soapAction action da operacao, conforme o WSDL (ex.: {@code .../NFeStatusServico4/nfeStatusServicoNF}).
     * @param envelopeXml envelope SOAP 1.2 completo, tipicamente montado por {@link DFSoapEnvelope#envelopar}.
     * @return o corpo da resposta HTTP.
     * @throws DFSoapFaultException se a SEFAZ devolver um {@code soap:Fault} reconhecivel no corpo,
     * mesmo quando acompanhado de um codigo HTTP de erro (a SEFAZ as vezes devolve Fault sob HTTP 500).
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
        if(this.httpClient != null) {
            this.httpClient.close();
        }
    }
}
