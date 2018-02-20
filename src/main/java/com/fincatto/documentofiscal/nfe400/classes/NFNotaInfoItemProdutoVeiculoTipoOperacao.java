package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoItemProdutoVeiculoTipoOperacao {

    OUTROS("0", "Outros"),
    VENDA_CONCESSIONARIA("1", "Venda concession\u00e1ria"),
    FATURAMENTO_DIRETO_CONSUMIDOR_FINAL("2", "Faturamento direto consumidor final"),
    VENDA_DIRETA_GRANDES_CONSUMIDORES("3", "Venda direta grandes consumidores");

    private final String codigo;
    private final String descricao;

    NFNotaInfoItemProdutoVeiculoTipoOperacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
        return codigo + " - " + descricao;
    }
}
