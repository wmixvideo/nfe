package com.fincatto.nfe310.classes.nota;

public enum NFNotaInfoItemIndicadorExigibilidadeISS {

    EXIGIVEL("1"),
    NAO_INCIDENCIA("2"),
    ISENCAO("3"),
    EXPORTACAO("4"),
    IMUNIDADE("5"),
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6"),
    EXIGIBILIDADE_SUSPENSA_POR_PROCESSO_ADMINISTRATIVO("7");

    private String codigo;

    private NFNotaInfoItemIndicadorExigibilidadeISS(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemIndicadorExigibilidadeISS valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemIndicadorExigibilidadeISS exigibilidadeISS : NFNotaInfoItemIndicadorExigibilidadeISS.values()) {
            if (exigibilidadeISS.getCodigo().equals(codigo)) {
                return exigibilidadeISS;
            }
        }
        return null;
    }
}