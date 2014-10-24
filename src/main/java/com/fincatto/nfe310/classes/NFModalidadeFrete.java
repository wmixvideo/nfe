package com.fincatto.nfe310.classes;

public enum NFModalidadeFrete {
    POR_CONTA_DO_EMITENTE("0"),
    POR_CONTA_DO_DESTINATARIO_REMETENTE("1"),
    POR_CONTA_DE_TERCEIROS("2"),
    SEM_FRETE("9");

    private String codigo;

    private NFModalidadeFrete(final String codigo) {
        this.codigo = codigo;
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
}