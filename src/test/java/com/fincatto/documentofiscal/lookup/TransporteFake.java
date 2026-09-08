package com.fincatto.documentofiscal.lookup;

import java.io.IOException;
import java.util.Map;

/**
 * Transporte HTTP simulado para os testes: guarda a última URL requisitada e devolve um
 * corpo fixo, sem tráfego de rede. Opcionalmente simula falha de comunicação ou devolve
 * corpos diferentes por pacote, para exercitar consultas que combinam mais de um pacote
 * (por exemplo, endereço no 5 e Inscrição Estadual no 16).
 */
class TransporteFake implements HttpTransport {

    private final String corpo;
    private final Map<Integer, String> corposPorPacote;
    private final IOException falha;
    private String ultimaUrl;

    TransporteFake(final String corpo) {
        this.corpo = corpo;
        this.corposPorPacote = null;
        this.falha = null;
    }

    TransporteFake(final Map<Integer, String> corposPorPacote) {
        this.corpo = null;
        this.corposPorPacote = corposPorPacote;
        this.falha = null;
    }

    TransporteFake(final IOException falha) {
        this.corpo = null;
        this.corposPorPacote = null;
        this.falha = falha;
    }

    @Override
    public String get(final String url) throws IOException {
        this.ultimaUrl = url;
        if (this.falha != null) {
            throw this.falha;
        }
        if (this.corposPorPacote != null) {
            final String resposta = this.corposPorPacote.get(pacoteDaUrl(url));
            if (resposta == null) {
                throw new IOException("Sem corpo simulado para a URL " + url);
            }
            return resposta;
        }
        return this.corpo;
    }

    String getUltimaUrl() {
        return this.ultimaUrl;
    }

    private static int pacoteDaUrl(final String url) {
        final String[] partes = url.split("/");
        return Integer.parseInt(partes[partes.length - 2]);
    }
}
