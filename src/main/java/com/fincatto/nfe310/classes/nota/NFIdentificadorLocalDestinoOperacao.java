package com.fincatto.nfe310.classes.nota;

public enum NFIdentificadorLocalDestinoOperacao {

    OPERACAO_INTERNA("1"),
    OPERACAO_INTERESTADUAL("2"),
    OPERACAO_COM_EXTERIOR("3");

    private String codigo;

    private NFIdentificadorLocalDestinoOperacao(final String codigo) {
        this.codigo = codigo;
    }

    public static NFIdentificadorLocalDestinoOperacao valueOfCodigo(final String codigo) {
        for (final NFIdentificadorLocalDestinoOperacao operacao : NFIdentificadorLocalDestinoOperacao.values()) {
            if (operacao.getCodigo().equals(codigo)) {
                return operacao;
            }
        }
        return null;
    }

    public String getCodigo() {
        return this.codigo;
    }
}