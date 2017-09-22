package com.fincatto.documentofiscal.cte200.classes;

public enum CTFormaPagamento {

    PAGO("0", "Pago"),
    A_PAGAR("1", "A pagar"),
    OUTROS("2", "Outros");

    private final String codigo;
    private final String descricao;

    CTFormaPagamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTFormaPagamento valueOfCodigo(final String codigo) {
        for (final CTFormaPagamento formaPagamento : CTFormaPagamento.values()) {
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