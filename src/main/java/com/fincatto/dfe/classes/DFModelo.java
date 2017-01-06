package com.fincatto.dfe.classes;

public enum DFModelo {

    NFE("55"),
    NFCE("65"),
    CTE("57");

    private final String codigo;

    private DFModelo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static DFModelo valueOfCodigo(final String codigo) {
        for (final DFModelo tipo : DFModelo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}