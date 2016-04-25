package com.fincatto.nfe310.classes;

public enum NFModelo {

    NFE("55"),
    NFCE("65");

    private final String codigo;

    private NFModelo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFModelo valueOfCodigo(final String codigo) {
        for (final NFModelo tipo : NFModelo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}