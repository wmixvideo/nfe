package com.fincatto.nfe310.classes.nota;

public enum NFIdentificadorLocalDestinoOperacao {

    OPERACAO_INTERNA("1", "Operação interna"),
    OPERACAO_INTERESTADUAL("2", "Operação interestadual"),
    OPERACAO_COM_EXTERIOR("3", "Operação com o exterior");

    private final String codigo;
    private final String desc;

    NFIdentificadorLocalDestinoOperacao(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}