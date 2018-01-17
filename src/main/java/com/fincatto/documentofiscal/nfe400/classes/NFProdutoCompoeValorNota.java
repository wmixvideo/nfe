package com.fincatto.documentofiscal.nfe400.classes;

public enum NFProdutoCompoeValorNota {

    NAO("0", "N\u00e3o"),
    SIM("1", "Sim");

    private final String codigo;
    private final String descricao;

    NFProdutoCompoeValorNota(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFProdutoCompoeValorNota valueOfCodigo(final String codigo) {
        for (final NFProdutoCompoeValorNota produtoCompoeValorNota : NFProdutoCompoeValorNota.values()) {
            if (produtoCompoeValorNota.getCodigo().equals(codigo)) {
                return produtoCompoeValorNota;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}