package com.fincatto.nfe310.classes;

public enum NFModalidadeFrete {
    POR_CONTA_DO_EMITENTE("0", "Por conta do emitente"),
    POR_CONTA_DO_DESTINATARIO_REMETENTE("1", "Por conta do destinatário remetente"),
    POR_CONTA_DE_TERCEIROS("2", "Por conta de terceiros"),
    SEM_FRETE("9", "Sem frete");

    private final String codigo;
    private final String desc;

    NFModalidadeFrete(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFModalidadeFrete valueOfCodigo(final String codigo) {
        for (final NFModalidadeFrete modalidadeFrete : NFModalidadeFrete.values()) {
            if (modalidadeFrete.getCodigo().equals(codigo)) {
                return modalidadeFrete;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}