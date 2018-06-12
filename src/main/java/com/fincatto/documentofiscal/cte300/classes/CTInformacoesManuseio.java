package com.fincatto.documentofiscal.cte300.classes;

public enum CTInformacoesManuseio {

    CERTIFICADO_DO_EXPEDIDOR_PARA_EMBARQUE_DE_ANIMAL_VIVO("01", "Certificado do expedidor para embarque de animal vivo"),
    ARTIGO_PERIGOSO_CONFORME_DECLARACAO_DO_EXPEDIDOR_ANEXA("02", "Artigo perigoso conforme declara\u00e7\u00e3o do expedidor anexa"),
    SOMENTE_EM_AERONAVE_CARGUEIRA("03", "Somente em aeronave cargueira"),
    ARTIGO_PERIGOSO_DECLARACAO_DO_EXPEDIDOR_NAO_REQUERIDA("04", "Artigo perigoso - declara\u00e7\u00e3o do expedidor n\u00e3o requerida"),
    ARTIGO_PERIGOSO_EM_QUANTIDADE_ISENTA("05", "Artigo perigoso em quantidade isenta"),
    GELO_SECO_PARA_REFRIGERACAO("06", "Gelo seco para refrigera\u00e7\u00e3o (especificar no campo observa\u00e7\u00f5es a quantidade)"),
    NAO_RESTRITO("07", "N\u00e3o restrito (especificar a disposi\u00e7\u00e3o especial no campo observa\u00e7\u00f5es)"),
    ARTIGO_PERIGOSO_EM_CARGA_CONSOLIDADA("08", "Artigo perigoso em carga consolidada (especificar a quantidade no campo observa\u00e7\u00f5es)"),
    AUTORIZACAO_DA_AUTORIDADE_GOVERNAMENTAL_ANEXA("09", "Autoriza\u00e7\u00e3o da autoridade governamental anexa (especificar no campo observa\u00e7\u00f5es)"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI965("10", "Baterias de \u00edons de l\u00edtio em conformidade com a se\u00e7\u00e3o II da PI965 - CAO"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI966("11", "Baterias de \u00edons de l\u00edtio em conformidade com a se\u00e7\u00e3o II da PI966"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI967("12", "Baterias de \u00edons de l\u00edtio em conformidade com a se\u00e7\u00e3o II da PI967"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO("13", "Baterias de \u00edons de l\u00edtio em conformidade com a se\u00e7\u00e3o ii da PI968 - CAO"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI969("14", "Baterias de \u00edons de l\u00edtio em conformidade com a se\u00e7\u00e3o II da PI969"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI970("15", "Baterias de \u00edons de l\u00edtio em conformidade com a se\u00e7\u00e3o II da PI970"),
    OUTRO("99", "Outro");

    private final String codigo;
    private final String descricao;

    CTInformacoesManuseio(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTInformacoesManuseio valueOfCodigo(final String codigo) {
        for (final CTInformacoesManuseio tipo : CTInformacoesManuseio.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}