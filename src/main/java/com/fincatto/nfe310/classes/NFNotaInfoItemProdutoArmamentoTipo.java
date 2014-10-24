package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemProdutoArmamentoTipo {
    PERMITIDO("0"),
    RESTRITO("1");

    private final String codigo;

    private NFNotaInfoItemProdutoArmamentoTipo(final String codigo) {
        this.codigo = codigo;
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
}