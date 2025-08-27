package com.fincatto.documentofiscal.cte300.classes;

public enum CTTipoFretamento {
    EVENTUAL("1", "Eventual"),
    CONTINUO("2", "Continuo");

    private final String codigo;
    private final String descricao;

    CTTipoFretamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTTipoFretamento valueOfCodigo(final String codigo) {
        for (final CTTipoFretamento valor : CTTipoFretamento.values()) {
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
