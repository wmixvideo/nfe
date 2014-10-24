package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemProdutoVeiculoTipoOperacao {

    OUTROS("0"),
    VENDA_CONCESSIONARIA("1"),
    FATURAMENTO_DIRETO_CONSUMIDOR_FINAL("2"),
    VENDA_DIRETA_GRANDES_CONSUMIDORES("3");

    private final String codigo;

    private NFNotaInfoItemProdutoVeiculoTipoOperacao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemProdutoVeiculoTipoOperacao valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemProdutoVeiculoTipoOperacao tipo : NFNotaInfoItemProdutoVeiculoTipoOperacao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
