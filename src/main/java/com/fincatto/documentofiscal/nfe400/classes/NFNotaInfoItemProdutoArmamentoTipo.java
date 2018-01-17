package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoItemProdutoArmamentoTipo {

    PERMITIDO("0", "Permitido"),
    RESTRITO("1", "Restrito");

    private final String codigo;
    private final String descricao;

    NFNotaInfoItemProdutoArmamentoTipo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemProdutoArmamentoTipo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemProdutoArmamentoTipo tipo : NFNotaInfoItemProdutoArmamentoTipo.values()) {
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