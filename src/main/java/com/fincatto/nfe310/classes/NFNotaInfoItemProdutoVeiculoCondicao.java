package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemProdutoVeiculoCondicao {

    ACABADO("1", "Acabado"),
    INACABADO("2", "Inacabado"),
    SEMI_ACABADO("3", "Semi-acabado");

    private final String codigo;
    private final String desc;

    NFNotaInfoItemProdutoVeiculoCondicao(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemProdutoVeiculoCondicao valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemProdutoVeiculoCondicao tipo : NFNotaInfoItemProdutoVeiculoCondicao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}
