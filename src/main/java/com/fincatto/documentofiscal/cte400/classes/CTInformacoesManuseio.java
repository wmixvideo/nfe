package com.fincatto.documentofiscal.cte400.classes;

public enum CTInformacoesManuseio {

    CERTIFICADO_DO_EXPEDIDOR_PARA_EMBARQUE_DE_ANIMAL_VIVO("01", "Certificado do expedidor para embarque de animal vivo"),
    ARTIGO_PERIGOSO_CONFORME_DECLARACAO_DO_EXPEDIDOR_ANEXA("02", "Artigo perigoso conforme declaração do expedidor anexa"),
    SOMENTE_EM_AERONAVE_CARGUEIRA("03", "Somente em aeronave cargueira"),
    ARTIGO_PERIGOSO_DECLARACAO_DO_EXPEDIDOR_NAO_REQUERIDA("04", "Artigo perigoso - declaração do expedidor não requerida"),
    ARTIGO_PERIGOSO_EM_QUANTIDADE_ISENTA("05", "Artigo perigoso em quantidade isenta"),
    GELO_SECO_PARA_REFRIGERACAO("06", "Gelo seco para refrigeração (especificar no campo observações a quantidade)"),
    NAO_RESTRITO("07", "Não restrito (especificar a disposição especial no campo observações)"),
    ARTIGO_PERIGOSO_EM_CARGA_CONSOLIDADA("08", "Artigo perigoso em carga consolidada (especificar a quantidade no campo observações)"),
    AUTORIZACAO_DA_AUTORIDADE_GOVERNAMENTAL_ANEXA("09", "Autorização da autoridade governamental anexa (especificar no campo observações)"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI965("10", "Baterias de íons de lítio em conformidade com a seção II da PI965 - CAO"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI966("11", "Baterias de íons de lítio em conformidade com a seção II da PI966"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI967("12", "Baterias de íons de lítio em conformidade com a seção II da PI967"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO("13", "Baterias de íons de lítio em conformidade com a seção ii da PI968 - CAO"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI969("14", "Baterias de íons de lítio em conformidade com a seção II da PI969"),
    BATERIAS_DE_IONS_DE_LITIO_EM_CONFORMIDADE_COM_A_SECAO_II_DA_PI970("15", "Baterias de íons de lítio em conformidade com a seção II da PI970"),
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