package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoFerrovia {

    FERROVIA_ORIGEM("1", "Ferrovia de origem"),
    FERROVIS_DESTINO("2", "Ferrovia de destino");

    private final String codigo;
    private final String descricao;

    CTTipoFerrovia(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoFerrovia valueOfCodigo(final String codigo) {
        for (final CTTipoFerrovia tipo : CTTipoFerrovia.values()) {
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