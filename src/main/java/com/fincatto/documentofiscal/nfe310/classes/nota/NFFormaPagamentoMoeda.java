package com.fincatto.documentofiscal.nfe310.classes.nota;

public enum NFFormaPagamentoMoeda {

    DINHEIRO("01", "Dinheiro"),
    CHEQUE("02", "Cheque"),
    CARTAO_CREDITO("03", "Cart\u00e3o de cr\u00e9dito"),
    CARTAO_DEBITO("04", "Cart\u00e3o de d\u00e9bito"),
    CARTAO_LOJA("05", "Cart\u00e3o da loja"),
    VALE_ALIMENTACAO("10", "Vale alimenta\u00e7\u00e3o"),
    VALE_REFEICAO("11", "Vale refei\u00e7\u00e3o"),
    VALE_PRESENTE("12", "Vale presente"),
    VALE_COMBUSTIVEL("13", "Vale combust\u00edvel"),
    OUTRO("99", "Outro");

    private final String codigo;
    private final String descricao;

    NFFormaPagamentoMoeda(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFFormaPagamentoMoeda valueOfCodigo(final String codigo) {
        for (final NFFormaPagamentoMoeda formaPagamentoMoeda : NFFormaPagamentoMoeda.values()) {
            if (formaPagamentoMoeda.getCodigo().equals(codigo)) {
                return formaPagamentoMoeda;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}