package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFNotaInfoItemIndicadorExigibilidadeISS {

    EXIGIVEL("1", "Exig\u00edvel"),
    NAO_INCIDENCIA("2", "N\u00e3o incid\u00eancia"),
    ISENCAO("3", "Isen\u00e7\u00e3o"),
    EXPORTACAO("4", "Exporta\u00e7\u00e3o"),
    IMUNIDADE("5", "Imunidade"),
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6", "Exigibilidade suspensa por decis\u00e3o judicial"),
    EXIGIBILIDADE_SUSPENSA_POR_PROCESSO_ADMINISTRATIVO("7", "Exigibilidade suspensa por processo administrativo");

    private final String codigo;
    private final String descricao;

    NFNotaInfoItemIndicadorExigibilidadeISS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
        return codigo + " - " + descricao;
    }
}