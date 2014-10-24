package com.fincatto.nfe310.classes.nota;

public enum NFOperadoraCartao {

    VISA("01"),
    MASTERCARD("02"),
    AMERICAN_EXPRESS("03"),
    SOROCRED("04"),
    OUTROS("99");

    private String codigo;

    private NFOperadoraCartao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFOperadoraCartao valueOfCodigo(final String codigo) {
        for (final NFOperadoraCartao operadora : NFOperadoraCartao.values()) {
            if (operadora.getCodigo().equals(codigo)) {
                return operadora;
            }
        }
        return null;
    }
}