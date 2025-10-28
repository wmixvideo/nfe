package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN {

    NAO_RETIDO("1", "Não Retido"),
    TOMADOR("2", "Retido pelo Tomador"),
    INTERMEDIARIO("3", "Retido pelo Intermediario");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN tipo : NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}