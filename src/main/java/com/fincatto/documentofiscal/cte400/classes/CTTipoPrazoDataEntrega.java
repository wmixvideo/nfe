package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoPrazoDataEntrega {

    SEM_DATA_DEFINIDA("0", "Sem data definida"),
    NA_DATA("1", "Na data"),
    ATE_A_DATA("2", "Até a data"),
    A_PARTIR_DA_DATA("3", "A partir da data"),
    NO_PERIODO("4", "No período");

    private final String codigo;
    private final String descricao;

    CTTipoPrazoDataEntrega(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoPrazoDataEntrega valueOfCodigo(final String codigo) {
        for (final CTTipoPrazoDataEntrega tipo : CTTipoPrazoDataEntrega.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}