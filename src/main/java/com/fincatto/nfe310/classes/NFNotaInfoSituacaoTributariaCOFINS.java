package com.fincatto.nfe310.classes;

public enum NFNotaInfoSituacaoTributariaCOFINS {
    OPERACAO_TRIBUTAVEL_CUMULATIVO_NAO_CUMULATIVO("01", "Operação tributável cumulativo/não cumulativo"),
    OPERACAO_TRIBUTAVEL_ALIQUOTA_DIFERENCIADA("02", "Operação tributável alíquota diferenciada"),
    OPERACAO_TRIBUTAVEL_QUANTIDADE_VENDIDA_POR_ALIQUOTA_POR_UNIDADE_PRODUTO("03", "Operação tributável quantidade vendida por alíquota por unidade produto"),
    OPERACAO_TRIBUTAVEL_MONOFASICA_ALIQUOTA_ZERO("04", "Operação tributável monofásica alíquota zero"),
    OPERACAO_TRIBUTAVEL_SUBSTITUICAO_TRIBUTARIA("05", "Operação tributável ST"),
    OPERACAO_TRIBUTAVEL_ALIQUOTA_ZERO("06", "Operação tributável alíquota zero"),
    OPERACAO_ISENTA_CONTRIBUICAO("07", "Operação isenta de contribuição"),
    OPERACAO_SEM_INCIDENCIA_CONTRIBUICAO("08", "Operação sem incidência de contribuição"),
    OPERACAO_COM_SUSPENSAO_CONTRIBUICAO("09", "Operação com suspensão de contribuição"),
    OUTRAS_OPERACOES_SAIDA("49", "Outras operações de saída"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO("50", "Operação direito crédito vinculada exclusivamente receita tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("51", "Operação direito crédito vinculada exclusivamente receita não tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO("52", "Operação direito crédito vinculada exclusivamente receita exportação"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADA_E_NAO_TRIBUTADA_MERCADO_INTERNO("53", "Operação direito crédito vinculada receitas tributada e não tributada mercado interno"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_NO_MERCADO_INTERNO_EXPORTACAO("54", "Operação direito crédito vinculada receitas tributadas no mercado interno exportação"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_NAO_TRIBUTADA_NO_MERCADO_INTERNO_EXPORTACAO("55", "Operação direito crédito vinculada receitas não tributada no mercado interno exportação"),
    OPERACAO_DIREITO_CREDITO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("56", "Operação direito crédito vinculada receitas tributadas e não tributadas mercado interno exportação"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_TRIBUTADA_MERCADO_INTERNO("60", "Crédito presumido operação aquisição vinculada exclusivamente receita tributada mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO("61", "Crédito presumido operação aquisição vinculada exclusivamente à receita não tributada mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_RECEITA_EXPORTACAO("62", "Crédito presumido operação aquisição vinculada exclusivamente receita exportação"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO("63", "Crédito presumido operação aquisição vinculada receitas tributadas mercado interno"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADA_MERCADO_INTERNO_EXPORTACAO("64", "Crédito presumido operação aquisição vinculada receitas tributadas mercado interno exportação"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("65", "Crédito presumido operação aquisição vinculada receitas não tributadas mercado interno exportação"),
    CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_TRIBUTADAS_E_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO("66", "Crédito presumido operação aquisição vinculada receitas tributadas e não tributadas mercado interno exportação"),
    CREDITO_PRESUMIDO_OUTRAS_OPERACOES("67", "Crédito presumido outras operações"),
    OPERACAO_AQUISICAO_SEM_DIREITO_CREDITO("70", "Operação aquisição sem direito crédito"),
    OPERACAO_AQUISICAO_COM_ISENCAO("71", "Operação aquisição com isenção"),
    OPERACAO_AQUISICAO_COM_SUSPENSAO("72", "Operação aquisição com suspensão"),
    OPERACAO_AQUISICAO_ALIQUOTA_ZERO("73", "Operação aquisição alíquota zero"),
    OPERACAO_AQUISICAO_SEM_INCIDENCIA_CONTRIBUICAO("74", "Operação aquisição sem incidência de contribuição"),
    OPERACAO_AQUISICAO_POR_SUBSTITUICAO_TRIBUTARIA("75", "Operação aquisição por substituição tributária"),
    OUTRAS_OPERACOES_ENTRADA("98", "Outras operações de entrada"),
    OUTRAS_OPERACOES("99", "Outras operações");

    private final String codigo;
    private final String desc;

    NFNotaInfoSituacaoTributariaCOFINS(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}