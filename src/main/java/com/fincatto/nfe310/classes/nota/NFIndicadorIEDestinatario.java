package com.fincatto.nfe310.classes.nota;

public enum NFIndicadorIEDestinatario {
    CONTRIBUINTE_ICMS("1"),
    CONTRIBUINTE_ISENTO_INSCRICAO_CONTRIBUINTES_ICMS("2"),
    NAO_CONTRIBUINTE("9");

    private String codigo;

    private NFIndicadorIEDestinatario(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFIndicadorIEDestinatario valueOfCodigo(final String codigo) {
        for (final NFIndicadorIEDestinatario indicador : NFIndicadorIEDestinatario.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        return null;
    }
}