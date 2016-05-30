package com.fincatto.nfe310.classes.nota;

public enum NFNotaInfoItemIndicadorExigibilidadeISS {

    EXIGIVEL("1", "Exigível"),
    NAO_INCIDENCIA("2", "Não incidência"),
    ISENCAO("3", "Isenção"),
    EXPORTACAO("4", "Exportação"),
    IMUNIDADE("5", "Imunidade"),
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6", "Exigibilidade suspensa por decisão judicial"),
    EXIGIBILIDADE_SUSPENSA_POR_PROCESSO_ADMINISTRATIVO("7", "Exigibilidade suspensa por processo administrativo");

    private final String codigo;
    private final String desc;

    NFNotaInfoItemIndicadorExigibilidadeISS(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}