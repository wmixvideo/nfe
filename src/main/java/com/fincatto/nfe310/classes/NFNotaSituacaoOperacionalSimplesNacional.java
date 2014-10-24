package com.fincatto.nfe310.classes;

public enum NFNotaSituacaoOperacionalSimplesNacional {
    TRIBUTADA_COM_PERMISSAO_CREDITO("101"),
    TRIBUTADA_SEM_PERMISSAO_CREDITO("102"),
    ISENCAO_ICMS_FAIXA_RECEITA_BRUTA("103"),
    TRIBUTADA_SIMPLES_NACIONAL_COM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("201"),
    TRIBUTADA_SIMPLES_NACIONAL_SEM_PERMISSAO_DE_CREDITO_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("202"),
    TRIBUTADA_SIMPLES_NACIONAL_PARA_FAIXA_RECEITA_BRUTA_E_COBRANCA_ICMS_SUBSTITUICAO_TRIBUTARIA("203"),
    IMUNE("300"),
    NAO_TRIBUTADA("400"),
    ICMS_COBRADO_ANTERIORMENTE_POR_SUBSTITUICAO_TRIBUTARIA_SUBSIDIO_OU_POR_ANTECIPACAO("500"),
    OUTROS("900");

    private final String codigo;

    private NFNotaSituacaoOperacionalSimplesNacional(final String codigo) {
        this.codigo = codigo;
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
}
