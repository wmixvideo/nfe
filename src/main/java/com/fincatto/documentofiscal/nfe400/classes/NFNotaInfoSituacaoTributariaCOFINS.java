package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoSituacaoTributariaCOFINS {

    OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO("01", "Opera\u00e7\u00e3o tribut\u00e1vel cumulativo/n\u00e3o cumulativo"),
    OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA("02", "Opera\u00e7\u00e3o tribut\u00e1vel al\u00edquota diferenciada"),
    OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO("03", "Opera\u00e7\u00e3o tribut\u00e1vel quantidade vendida por al\u00edquota por unidade produto"),
    OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO("04", "Opera\u00e7\u00e3o tribut\u00e1vel monof\u00e1sica al\u00edquota zero"),
    OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA("05", "Opera\u00e7\u00e3o tribut\u00e1vel ST"),
    OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO("06", "Opera\u00e7\u00e3o tribut\u00e1vel al\u00edquota zero"),
    OPERACAO_ISENTA_CONTRIBUICAO("07", "Opera\u00e7\u00e3o isenta de contribui\u00e7\u00e3o"),
    OPERACAO_SEM_INCIDENCIA_CONTRIBUICAO("08", "Opera\u00e7\u00e3o sem incid\u00eancia de contribui\u00e7\u00e3o"),
    OPERACAO_COM_SUSPENSAO_CONTRIBUICAO("09", "Opera\u00e7\u00e3o com suspens\u00e3o de contribui\u00e7\u00e3o"),
    OUTRAS_OPERACOES_SAIDA("49", "Outras opera\u00e7\u00f5es de sa\u00edda"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO("50", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("51", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita n\u00e3o tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO("52", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada exclusivamente receita exporta\u00e7\u00e3o"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO("53", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributada e n\u00e3o tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_NO_MERCADO_INTERNO_EXPORTACAO("54", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributadas no mercado interno exporta\u00e7\u00e3o"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_NAO_TRIBUTADA_NO_MERCADO_INTERNO_EXPORTACAO("55", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas n\u00e3o tributada no mercado interno exporta\u00e7\u00e3o"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("56", "Opera\u00e7\u00e3o direito cr\u00e9dito vinculada receitas tributadas e n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO("60", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente receita tributada mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("61", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente \u00e0 receita n\u00e3o tributada mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO("62", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada exclusivamente receita exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO("63", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADA_MERCADO_INTERNO_EXPORTACAO("64", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("65", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("66", "Cr\u00e9dito presumido opera\u00e7\u00e3o aquisi\u00e7\u00e3o vinculada receitas tributadas e n\u00e3o tributadas mercado interno exporta\u00e7\u00e3o"),
    CREDITO_PRESUMIDO_OUTRAS_OPERACOES("67", "Cr\u00e9dito presumido outras opera\u00e7\u00f5es"),
    OPERACAO_AQUISICAO_SEM_DIREITO_CREDITO("70", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o sem direito cr\u00e9dito"),
    OPERACAO_AQUISICAO_COM_ISENCAO("71", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o com isen\u00e7\u00e3o"),
    OPERACAO_AQUISICAO_COM_SUSPENSAO("72", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o com suspens\u00e3o"),
    OPERACAO_AQUISICAO_ALIQUOTA_ZERO("73", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o al\u00edquota zero"),
    OPERACAO_AQUISICAO_SEM_INCIDENCIA_CONTRIBUICAO("74", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o sem incid\u00eancia de contribui\u00e7\u00e3o"),
    OPERACAO_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA("75", "Opera\u00e7\u00e3o aquisi\u00e7\u00e3o por substitui\u00e7\u00e3o tribut\u00e1ria"),
    OUTRAS_OPERACOES_ENTRADA("98", "Outras opera\u00e7\u00f5es de entrada"),
    OUTRAS_OPERACOES("99", "Outras opera\u00e7\u00f5es");

    private final String codigo;
    private final String descricao;

    NFNotaInfoSituacaoTributariaCOFINS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoSituacaoTributariaCOFINS valueOfCodigo(final String codigo) {
        for (final NFNotaInfoSituacaoTributariaCOFINS situacaoTributariaCOFINS : NFNotaInfoSituacaoTributariaCOFINS.values()) {
            if (situacaoTributariaCOFINS.getCodigo().equals(codigo)) {
                return situacaoTributariaCOFINS;
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