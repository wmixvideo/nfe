package com.fincatto.documentofiscal.nfe400.classes;

public enum NFIndicadorFormaPagamento {

    A_VISTA("0", "Pagamento \u00c0 vista"),
    A_PRAZO("1", "Pagamento a prazo");

    private final String codigo;
    private final String descricao;

    NFIndicadorFormaPagamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFIndicadorFormaPagamento valueOfCodigo(final String codigo) {
        for (NFIndicadorFormaPagamento formaPagamento : NFIndicadorFormaPagamento.values()) {
            if (formaPagamento.getCodigo().equals(codigo)) {
                return formaPagamento;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}