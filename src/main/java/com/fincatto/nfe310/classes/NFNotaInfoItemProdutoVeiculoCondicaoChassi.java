package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemProdutoVeiculoCondicaoChassi {

    NORMAL("N"),
    REMARCADO("R");

    private final String codigo;

    private NFNotaInfoItemProdutoVeiculoCondicaoChassi(final String codigo) {
        this.codigo = codigo;
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
}
