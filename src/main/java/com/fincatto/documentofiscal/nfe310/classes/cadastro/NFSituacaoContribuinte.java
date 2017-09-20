package com.fincatto.documentofiscal.nfe310.classes.cadastro;

public enum NFSituacaoContribuinte {

    NAO_HABILITADO(0, "N\u00e3o habilitado"),
    HABILITADO(1, "Habilitado");

    private final int codigo;
    private final String descricao;

    NFSituacaoContribuinte(final int codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static NFSituacaoContribuinte valueOfCodigo(final int codigo) {
        for (final NFSituacaoContribuinte situacaoContribuinte : NFSituacaoContribuinte.values()) {
            if (situacaoContribuinte.getCodigo() == codigo) {
                return situacaoContribuinte;
            }
        }
        throw new IllegalStateException(String.format("Situacao do contribuinte n\u00e3o mapeada: %s", codigo));
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}