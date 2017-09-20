package com.fincatto.documentofiscal.nfe310.classes;

public enum NFNotaSituacaoOperacionalSimplesNacional {

    TRIBUTADA_COM_PERMISSAO_CREDITO("101", "Tributada com permiss\u00e3o de cr\u00e9dito"),
    TRIBUTADA_SEM_PERMISSAO_CREDITO("102", "Tributada sem permiss\u00e3o de cr\u00e9dito"),
    ISENCAO_ICMS_FAIXA_RECEITA_BRUTA("103", "Isen\u00e7\u00e3o ICMS faixa receita bruta"),
    TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("201", "Tributada Simples Nacional com permiss\u00e3o de cr\u00e9dito e cobran\u00e7a ICMS ST"),
    TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("202", "Tributada Simples Nacional sem permiss\u00e3o de cr\u00e9dito e cobran\u00e7a ICMS ST"),
    TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("203", "Tributada Simples Nacional para faixa receita bruta e cobran\u00e7a ICMS ST"),
    IMUNE("300", "Imune"),
    NAO_TRIBUTADA("400", "N\u00e3o tributada"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO("500", "ICMS cobrado anteriormente por ST subs\u00eddio ou por antecipa\u00e7\u00e3o"),
    OUTROS("900", "Outros");

    private final String codigo;
    private final String descricao;

    NFNotaSituacaoOperacionalSimplesNacional(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }
    
    public String getDescricao() {
        return this.descricao;
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
        return codigo + " - " + descricao;
    }
}
