package com.fincatto.documentofiscal.lookup;

import java.io.IOException;

/**
 * Transporte HTTP simulado para os testes: guarda a última URL requisitada e devolve um
 * corpo fixo, sem tráfego de rede. Opcionalmente simula falha de comunicação.
 */
class TransporteFake implements HttpTransport {

    private final String corpo;
    private final IOException falha;
    private String ultimaUrl;

    TransporteFake(final String corpo) {
        this.corpo = corpo;
        this.falha = null;
    }

    TransporteFake(final IOException falha) {
        this.corpo = null;
        this.falha = falha;
    }

    @Override
    public String get(final String url) throws IOException {
        this.ultimaUrl = url;
        if (this.falha != null) {
            throw this.falha;
        }
        return this.corpo;
    }

    String getUltimaUrl() {
        return this.ultimaUrl;
    }
}
