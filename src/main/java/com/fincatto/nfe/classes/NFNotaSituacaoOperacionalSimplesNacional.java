package com.fincatto.nfe.classes;

public enum NFNotaSituacaoOperacionalSimplesNacional {
    TRIBUTADA_COM_PERMISSAO_CREDITO("101"),
    TRIBUTADA_SEM_PERMISSAO_CREDITO("102"),
    ISENCAO_ICMS_FAIXA_RECEITA_BRUTA("103"),
    IMUNE("300"),
    NAO_TRIBUTADA("400");

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
