package com.fincatto.documentofiscal.cte300.classes;

public enum CTTipoProprietario {
    TAC_AGREGADO("0", "TAC – Agregado"),
    TAC_INDEPENDENTE("1", "TAC – Independente"),
    OUTROS("2", "Outros");

    private final String codigo;
    private final String descricao;

    CTTipoProprietario(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTTipoProprietario valueOfCodigo(final String codigo) {
        for (final CTTipoProprietario valor : CTTipoProprietario.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
