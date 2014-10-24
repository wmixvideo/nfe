package com.fincatto.nfe310.classes;

public enum NFProdutoCompoeValorNota {
    NAO("0"),
    SIM("1");

    private final String codigo;

    private NFProdutoCompoeValorNota(final String codigo) {
        this.codigo = codigo;
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
}