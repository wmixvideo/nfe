package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFIndicadorIEDestinatario {

    CONTRIBUINTE_ICMS("1", "Contribuinte ICMS"),
    CONTRIBUINTE_ISENTO_INSCRICAO_CONTRIBUINTES_ICMS("2", "Contribuinte isento inscri\u00e7\u00e3o contribuintes ICMS"),
    NAO_CONTRIBUINTE("9", "N\u00e3o contribuinte");

    private final String codigo;
    private final String descricao;

    NFIndicadorIEDestinatario(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}