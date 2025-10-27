package com.fincatto.documentofiscal.nfse.classes.nfsenacional;


public enum NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional {

    NAO_OPTANTE("1", "Não Optante"),
    MEI("2", "Optante - Microempreendedor Individual (MEI)"),
    ME_EPP("3", "Optante - Microempresa ou Empresa de Pequeno Porte (ME/EPP)");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional tipo : NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}