package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria {

    NENHUM("00", "Nenhum"),
    BASICA("01", "Operação Tributável com Alíquota Básica"),
    DIFERENCIADA("02", "Operação Tributável com Alíquota Diferenciada"),
    UNIDADE_MEDIDA_PRODUTO("03", "Operação Tributável com Alíquota por Unidade de Medida de Produto"),
    MONOFASICA("04", "Operação Tributável monofásica (Revenda a Alíquota Zero)"),
    SUBSTITUICAO("05", "Operação Tributável por Substituição Tributária"),
    ALIQUOTA_ZERO("06", "Operação Tributável a Alíquota Zero"),
    CONTRIBUICAO_TRIBUTAVEL("07", "Operação Tributável da Contribuição"),
    CONTRIBUICAO_SEM_INCIDENCIA("08", "Operação sem Incidência da Contribuição"),
    SUSPENSAO_CONTRIBUICAO("09", "Operação com Suspensão da Contribuição");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria tipo : NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}