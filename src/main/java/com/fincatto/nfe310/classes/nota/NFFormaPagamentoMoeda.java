package com.fincatto.nfe310.classes.nota;

public enum NFFormaPagamentoMoeda {

    DINHEIRO("01"),
    CHEQUE("02"),
    CARTAO_CREDITO("03"),
    CARTAO_DEBITO("04"),
    CARTAO_LOJA("05"),
    VALE_ALIMENTACAO("10"),
    VALE_REFEICAO("11"),
    VALE_PRESENTE("12"),
    VALE_COMBUSTIVEL("13"),
    OUTRO("99");

    private String codigo;

    private NFFormaPagamentoMoeda(final String codigo) {
        this.codigo = codigo;
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
}