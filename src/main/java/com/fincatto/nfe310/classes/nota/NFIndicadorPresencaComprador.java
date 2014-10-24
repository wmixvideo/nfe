package com.fincatto.nfe310.classes.nota;

public enum NFIndicadorPresencaComprador {
    NAO_APLICA("0"),
    OPERACAO_PRESENCIAL("1"),
    OPERACAO_NAO_PRESENCIAL_INTERNET("2"),
    OPERACAO_NAO_PRESENCIAL_TELEATENDIMENTO("3"),
    NFCE_EM_OPERACAO_COM_ENTREGA_DOMICILIO("4"),
    OPERACAO_NAO_PRESENCIAL_OUTROS("9");

    private String codigo;

    private NFIndicadorPresencaComprador(final String codigo) {
        this.codigo = codigo;
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
}