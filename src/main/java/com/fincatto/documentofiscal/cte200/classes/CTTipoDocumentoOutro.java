package com.fincatto.documentofiscal.cte200.classes;

public enum CTTipoDocumentoOutro {

    DECLARACAO("00", "Declara\u00e7\u00e3o"),
    DUTOVIARIO("10", "Dutovi\u00e1rio"),
    OUTROS("99", "Outros");

    private final String codigo;
    private final String descricao;

    CTTipoDocumentoOutro(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoDocumentoOutro valueOfCodigo(final String codigo) {
        for (final CTTipoDocumentoOutro formaPagamento : CTTipoDocumentoOutro.values()) {
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