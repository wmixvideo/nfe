package com.fincatto.nfe310.classes;

public enum NFTipoCertificado {

    A1("A1"),
    A3("A3");

    private final String codigo;

    private NFTipoCertificado(final String codigo) {
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipoCertificado valueOfCodigo(final String codigo) {
        for (final NFTipoCertificado tipo : NFTipoCertificado.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
