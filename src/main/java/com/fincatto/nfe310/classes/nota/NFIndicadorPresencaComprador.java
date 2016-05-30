package com.fincatto.nfe310.classes.nota;

public enum NFIndicadorPresencaComprador {
    NAO_APLICA("0", "Não se aplica"),
    OPERACAO_PRESENCIAL("1", "Operação presencial"),
    OPERACAO_NAO_PRESENCIAL_INTERNET("2", "Operação não presencial - Internet"),
    OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO("3", "Operação não presencial - Teleatendimento"),
    NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO("4", "NFC-e em operação com entrega a domicílio"),
    OPERACAO_NAO_PRESENCIAL_OUTROS("9", "Operação não presencial - Outros");

    private final String codigo;
    private final String desc;

    NFIndicadorPresencaComprador(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFIndicadorPresencaComprador valueOfCodigo(final String codigo) {
        for (final NFIndicadorPresencaComprador indicador : NFIndicadorPresencaComprador.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}