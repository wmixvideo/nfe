package com.fincatto.documentofiscal.lookup;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * Implementação padrão de {@link HttpTransport} sobre o cliente HTTP da JDK 11
 * ({@link java.net.http.HttpClient}). Não adiciona nenhuma dependência ao projeto.
 */
final class JdkHttpTransport implements HttpTransport {

    private final HttpClient cliente;
    private final Duration timeoutRequisicao;

    JdkHttpTransport() {
        this(Duration.ofSeconds(20), Duration.ofSeconds(30));
    }

    JdkHttpTransport(final Duration timeoutConexao, final Duration timeoutRequisicao) {
        this.cliente = HttpClient.newBuilder().connectTimeout(timeoutConexao).build();
        this.timeoutRequisicao = timeoutRequisicao;
    }

    @Override
    public String get(final String url) throws IOException {
        final URI uri;
        try {
            uri = URI.create(url);
        } catch (final IllegalArgumentException e) {
            throw new IOException("URL de consulta inválida");
        }
        final HttpRequest requisicao = HttpRequest.newBuilder(uri)
                .timeout(this.timeoutRequisicao)
                .header("Accept", "application/json")
                .GET()
                .build();
        try {
            final HttpResponse<String> resposta = this.cliente.send(requisicao, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            final String corpo = resposta.body();
            if ((corpo == null || corpo.isEmpty()) && resposta.statusCode() >= 400) {
                throw new IOException("Resposta HTTP " + resposta.statusCode() + " sem corpo");
            }
            return corpo;
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Consulta interrompida", e);
        }
    }
}
