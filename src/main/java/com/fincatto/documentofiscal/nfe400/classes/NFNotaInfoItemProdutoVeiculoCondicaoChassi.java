package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoItemProdutoVeiculoCondicaoChassi {

    NORMAL("N", "Normal"),
    REMARCADO("R", "Remarcado");

    private final String codigo;
    private final String descricao;

    NFNotaInfoItemProdutoVeiculoCondicaoChassi(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemProdutoVeiculoCondicaoChassi valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemProdutoVeiculoCondicaoChassi tipo : NFNotaInfoItemProdutoVeiculoCondicaoChassi.values()) {
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
