package com.fincatto.documentofiscal.nfse.utils;

import com.fincatto.documentofiscal.nfse.NFSeConfig;
import com.fincatto.documentofiscal.utils.DFSocketFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class NFSeHttpClient {
    final HttpClient client;
    final NFSeConfig config;
    private Duration timeout;

    public NFSeHttpClient(final NFSeConfig config) {
        this.config = config;
        this.timeout = Duration.ofSeconds(20);
        try {
            this.client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).followRedirects(HttpClient.Redirect.NORMAL).sslContext(DFSocketFactory.getDefaultSSLContext(config)).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método privado que realiza uma requisição GET para a uri especificada.
     * <code>Content-Type application/json; charset=utf-8</code>.
     *
     * @param uri URI para a qual a requisição será feita.
     * @return Objeto {@link HttpResponse} contendo a resposta da requisição.
     * @throws Exception Se ocorrer um erro durante a requisição.
     */
    public HttpResponse<String> sendGetRequest(final URI uri) throws Exception {
        return sendGetRequest(uri, HttpResponse.BodyHandlers.ofString());
    }

    public <T> HttpResponse<T> sendGetRequest(final URI uri, HttpResponse.BodyHandler<T> responseBodyHandler) throws Exception {
        return this.client.send(HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .headers("Content-Type", "application/json; charset=utf-8")
                .timeout(this.getTimeout())
                .build(), responseBodyHandler);
    }

    public HttpResponse<String> sendPostRequest(final URI uri, final String jsonBody) throws Exception {
        return this.client.send(HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .headers("Content-Type", "application/json; charset=utf-8")
                .timeout(this.timeout)
                .uri(uri)
                .build(), HttpResponse.BodyHandlers.ofString());
    }

    private Duration getTimeout() {
        return timeout;
    }
}
