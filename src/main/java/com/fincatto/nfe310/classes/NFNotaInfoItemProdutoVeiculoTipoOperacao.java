package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemProdutoVeiculoTipoOperacao {

    OUTROS("0", "Outros"),
    VENDA_CONCESSIONARIA("1", "Venda concessionária"),
    FATURAMENTO_DIRETO_CONSUMIDOR_FINAL("2", "Faturamento direto consumidor final"),
    VENDA_DIRETA_GRANDES_CONSUMIDORES("3", "Venda direta grandes consumidores");

    private final String codigo;
    private final String desc;

    NFNotaInfoItemProdutoVeiculoTipoOperacao(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}
