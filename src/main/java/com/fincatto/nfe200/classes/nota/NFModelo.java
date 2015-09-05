package com.fincatto.nfe200.classes.nota;

public enum NFModelo {

    NF_E("55");

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
