package com.fincatto.nfe310.classes;

public enum NFNotaSituacaoOperacionalSimplesNacional {
    TRIBUTADA_COM_PERMISSAO_CREDITO("101", "Tributada com permissão de crédito"),
    TRIBUTADA_SEM_PERMISSAO_CREDITO("102", "Tributada sem permissão de crédito"),
    ISENCAO_ICMS_FAIXA_RECEITA_BRUTA("103", "Isenção ICMS faixa receita bruta"),
    TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("201", "Tributada Simples Nacional com permissão de crédito e cobrança ICMS ST"),
    TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("202", "Tributada Simples Nacional sem permissão de crédito e cobrança ICMS ST"),
    TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("203", "Tributada Simples Nacional para faixa receita bruta e cobrança ICMS ST"),
    IMUNE("300", "Imune"),
    NAO_TRIBUTADA("400", "Não tributada"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO("500", "ICMS cobrado anteriormente por ST subsídio ou por antecipação"),
    OUTROS("900", "Outros");

    private final String codigo;
    private final String desc;

    NFNotaSituacaoOperacionalSimplesNacional(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaSituacaoOperacionalSimplesNacional valueOfCodigo(final String codigo) {
        for (final NFNotaSituacaoOperacionalSimplesNacional situacaoOperacional : NFNotaSituacaoOperacionalSimplesNacional.values()) {
            if (situacaoOperacional.getCodigo().equals(codigo)) {
                return situacaoOperacional;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}
