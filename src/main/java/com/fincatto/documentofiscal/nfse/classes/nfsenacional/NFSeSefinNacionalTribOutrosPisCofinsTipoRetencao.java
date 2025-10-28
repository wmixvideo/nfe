package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao {

    NENHUM("1", "Retido"),
    BASICA("2", "Não retido");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao tipo : NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}