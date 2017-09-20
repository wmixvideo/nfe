package com.fincatto.documentofiscal.cte200.classes;

public enum CTResponsavelSeguro {

    REMETENTE("0", "Remetente"),
    EXPEDIDOR("1", "Expedidor"),
    RECEBEDOR("2", "Recebedor"),
    DESTINATARIO("3", "Destinata\u0301rio"),
    EMITENTE("4", "Emitente do CT-e"),
    TOMADOR("5", "Tomador de servi\u00e7o");

    private final String codigo;
    private final String descricao;

    CTResponsavelSeguro(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTResponsavelSeguro valueOfCodigo(final String codigo) {
        for (final CTResponsavelSeguro formaPagamento : CTResponsavelSeguro.values()) {
            if (formaPagamento.getCodigo().equals(codigo)) {
                return formaPagamento;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}