package com.fincatto.documentofiscal.nfe310.classes.nota;

public enum NFIdentificadorLocalDestinoOperacao {

    OPERACAO_INTERNA("1", "Opera\u00e7\u00e3o interna"),
    OPERACAO_INTERESTADUAL("2", "Opera\u00e7\u00e3o interestadual"),
    OPERACAO_COM_EXTERIOR("3", "Opera\u00e7\u00e3o com o exterior");

    private final String codigo;
    private final String descricao;

    NFIdentificadorLocalDestinoOperacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}