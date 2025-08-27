package com.fincatto.documentofiscal.cte400.classes;

public enum CTResponsavelSeguro {
    EMITENTE("4", "Emitente do CT-e OS"),
    TOMADOR("5", "Tomador de Serviço");

    private final String codigo;
    private final String descricao;

    CTResponsavelSeguro(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTResponsavelSeguro valueOfCodigo(final String codigo) {
        for (final CTResponsavelSeguro valor : CTResponsavelSeguro.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
