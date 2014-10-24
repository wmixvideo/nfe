package com.fincatto.nfe200.classes;

public enum NFTipoImpressao {

    RETRATO("1"),
    PAISAGEM("2");

    private final String codigo;

    private NFTipoImpressao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipoImpressao valueOfCodigo(final String codigo) {
        for (final NFTipoImpressao tipo : NFTipoImpressao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}