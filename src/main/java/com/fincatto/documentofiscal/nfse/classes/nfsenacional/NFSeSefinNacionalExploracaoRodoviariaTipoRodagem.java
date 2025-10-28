package com.fincatto.documentofiscal.nfse.classes.nfsenacional;

public enum NFSeSefinNacionalExploracaoRodoviariaTipoRodagem {

    NAO_INFORMADO("1", "Simples"),
    AUTOMOVEL_LEVE("2", "Dupla");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalExploracaoRodoviariaTipoRodagem(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalExploracaoRodoviariaTipoRodagem valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalExploracaoRodoviariaTipoRodagem tipo : NFSeSefinNacionalExploracaoRodoviariaTipoRodagem.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}