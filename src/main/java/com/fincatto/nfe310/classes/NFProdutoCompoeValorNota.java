package com.fincatto.nfe310.classes;

public enum NFProdutoCompoeValorNota {
    NAO("0", "Não"),
    SIM("1", "Sim");

    private final String codigo;
    private final String desc;

    NFProdutoCompoeValorNota(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}