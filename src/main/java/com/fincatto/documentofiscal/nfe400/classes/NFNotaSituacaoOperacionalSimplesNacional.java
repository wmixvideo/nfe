package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaSituacaoOperacionalSimplesNacional {

    CSOSN_101("101", "Tributada com permiss\u00e3o de cr\u00e9dito"),
    CSOSN_102("102", "Tributada sem permiss\u00e3o de cr\u00e9dito"),
    CSOSN_103("103", "Isen\u00e7\u00e3o ICMS faixa receita bruta"),
    CSOSN_201("201", "Tributada Simples Nacional com permiss\u00e3o de cr\u00e9dito e cobran\u00e7a ICMS ST"),
    CSOSN_202("202", "Tributada Simples Nacional sem permiss\u00e3o de cr\u00e9dito e cobran\u00e7a ICMS ST"),
    CSOSN_203("203", "Tributada Simples Nacional para faixa receita bruta e cobran\u00e7a ICMS ST"),
    CSOSN_300("300", "Imune"),
    CSOSN_400("400", "N\u00e3o tributada"),
    CSOSN_500("500", "ICMS cobrado anteriormente por ST subs\u00eddio ou por antecipa\u00e7\u00e3o"),
    CSOSN_900("900", "Outros");

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
