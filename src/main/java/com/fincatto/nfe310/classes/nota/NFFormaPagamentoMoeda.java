package com.fincatto.nfe310.classes.nota;

public enum NFFormaPagamentoMoeda {

    DINHEIRO("01", "Dinheiro"),
    CHEQUE("02", "Cheque"),
    CARTAO_CREDITO("03", "Cartão de crédito"),
    CARTAO_DEBITO("04", "Cartão de débito"),
    CARTAO_LOJA("05", "Cartão da loja"),
    VALE_ALIMENTACAO("10", "Vale alimentação"),
    VALE_REFEICAO("11", "Vale refeição"),
    VALE_PRESENTE("12", "Vale presente"),
    VALE_COMBUSTIVEL("13", "Vale combustível"),
    OUTRO("99", "Outro");

    private final String codigo;
    private final String desc;

    NFFormaPagamentoMoeda(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}