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
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.reactor.ssl.SSLBufferMode;
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
 */
public class DFHttpClient implements Closeable {

    private final CloseableHttpClient httpClient;

    /**
     * @param sslContext SSLContext ja configurado com o certificado A1 e a cadeia da SEFAZ,
     * tipicamente obtido de {@link DFSocketFactory#getSslContext()}.
     * @param config configuracao de timeouts e protocolos TLS a ser usada nas requisicoes.
     */
    public DFHttpClient(final SSLContext sslContext, final DFConfig config) {
        // SSLConnectionSocketFactory (usada em versoes anteriores desta classe) esta deprecated
        // no httpclient5 5.6+ em favor de TlsSocketStrategy/DefaultClientTlsStrategy.
        final DefaultClientTlsStrategy tlsStrategy =
                new DefaultClientTlsStrategy(sslContext, config.getSSLProtocolos(), null, SSLBufferMode.STATIC, new DefaultHostnameVerifier());

        // mesmo mapeamento que o MessageContextFactory ja fazia para o Axis2: getSoTimeoutEmMillis()
        // alimenta o timeout de conexao e getTimeoutRequisicaoEmMillis() o timeout de leitura da resposta.
        final ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(config.getSoTimeoutEmMillis()))
                .build();

        final PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setTlsSocketStrategy(tlsStrategy)
                .setDefaultConnectionConfig(connectionConfig)
                .build();

        final RequestConfig requestConfig = RequestConfig.custom()
                .setResponseTimeout(Timeout.ofMilliseconds(config.getTimeoutRequisicaoEmMillis()))
                .build();

        this.httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    /**
     * Envia um envelope SOAP 1.2 via POST e devolve o corpo da resposta como texto.
     *
     * @param endpoint URL do webservice da SEFAZ.
     * @param soapAction action da operacao, conforme o WSDL (ex.: {@code .../NFeStatusServico4/nfeStatusServicoNF}).
     * @param envelopeXml envelope SOAP 1.2 completo, tipicamente montado por {@link DFSoapEnvelope#envelopar}.
     * @return o corpo da resposta HTTP.
     * @throws IOException em caso de falha de conexao ou resposta HTTP de erro (codigo &gt;= 300).
     */
    public String postSoap(final String endpoint, final String soapAction, final String envelopeXml) throws IOException {
        final HttpPost post = new HttpPost(endpoint);
        post.setEntity(new StringEntity(envelopeXml, ContentType.create("application/soap+xml", StandardCharsets.UTF_8)));
        // SOAP 1.2 carrega a action dentro do Content-Type, nao num header SOAPAction separado (como no SOAP 1.1)
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/soap+xml; charset=UTF-8; action=\"" + soapAction + "\"");

        return this.httpClient.execute(post, response -> {
            final String corpo = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            if (response.getCode() >= 300) {
                throw new ClientProtocolException("SEFAZ respondeu HTTP " + response.getCode() + ": " + corpo);
            }
            return corpo;
        });
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
