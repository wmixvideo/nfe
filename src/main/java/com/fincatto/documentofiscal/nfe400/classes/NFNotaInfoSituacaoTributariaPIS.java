package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoSituacaoTributariaPIS {

    CST_01("01", "Opera\u00e7\u00e3o tribut\u00e1vel cumulativo/n\u00e3o cumulativo"),
    CST_02("02", "Opera\u00e7\u00e3o tribut\u00e1vel al\u00edquota diferenciada"),
    CST_03("03", "Opera\u00e7\u00e3o tribut\u00e1vel quantidade vendida por al\u00edquota por unidade produto"),
    CST_04("04", "Opera\u00e7\u00e3o tribut\u00e1vel monof\u00e1sica al\u00edquota zero"),
    CST_05("05", "Opera\u00e7\u00e3o tribut\u00e1vel ST"),
    CST_06("06", "Opera\u00e7\u00e3o tribut\u00e1vel al\u00edquota zero"),
    CST_07("07", "Opera\u00e7\u00e3o isenta de contribui\u00e7\u00e3o"),
    CST_08("08", "Opera\u00e7\u00e3o sem incid\u00eancia de contribui\u00e7\u00e3o"),
    CST_09("09", "Opera\u00e7\u00e3o com suspens\u00e3o de contribui\u00e7\u00e3o"),
    CST_49("49", "Outras opera\u00e7\u00f5es de sa\u00edda"),
    CST_50("50", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita tributada mercado interno"),
    CST_51("51", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita n\u00e3o tributada mercado interno"),
    CST_52("52", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita exporta\u00e7\u00e3o"),
    CST_53("53", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributada e n\u00e3o tributada mercado interno"),
    CST_54("54", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributadas no mercado interno exporta\u00e7\u00e3o"),
    CST_55("55", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas n\u00e3o tributada no mercado interno exporta\u00e7\u00e3o"),
    CST_56("56", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributadas e n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CST_60("60", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente receita tributada mercado interno"),
    CST_61("61", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente \u00e0 receita n\u00e3o tributada mercado interno"),
    CST_62("62", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente receita exporta\u00e7\u00e3o"),
    CST_63("63", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas mercado interno"),
    CST_64("64", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas mercado interno exporta\u00e7\u00e3o"),
    CST_65("65", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CST_66("66", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas e n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CST_67("67", "Cr\u00e9dito presumido outras opera\u00e7\u00f5es"),
    CST_70("70", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o sem direito cr\u00e9dito"),
    CST_71("71", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o com isen\u00e7\u00e3o"),
    CST_72("72", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o com suspens\u00e3o"),
    CST_73("73", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o al\u00edquota zero"),
    CST_74("74", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o sem incid\u00eancia de contribui\u00e7\u00e3o"),
    CST_75("75", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o por substitui\u00e7\u00e3o tribut\u00e1ria"),
    CST_98("98", "Outras opera\u00e7\u00f5es de entrada"),
    CST_99("99", "Outras opera\u00e7\u00f5es");

    private final String codigo;
    private final String descricao;

    NFNotaInfoSituacaoTributariaPIS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoSituacaoTributariaPIS valueOfCodigo(final String codigo) {
        for (final NFNotaInfoSituacaoTributariaPIS situacaoTributariaPIS : NFNotaInfoSituacaoTributariaPIS.values()) {
            if (situacaoTributariaPIS.getCodigo().equals(codigo)) {
                return situacaoTributariaPIS;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }

	public String getDescricao() {
		return descricao;
	}
    
}
