package com.fincatto.documentofiscal.cte400.classes;

public enum CTClasseTarifa {

    MINIMA("M", "Tarifa mínima"),
    GERAL("G", "Tarifa geral"),
    ESPECIFICA("E", "Tarifa especifica");

    private final String codigo;
    private final String descricao;

    CTClasseTarifa(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTClasseTarifa valueOfCodigo(final String codigo) {
        for (final CTClasseTarifa tipo : CTClasseTarifa.values()) {
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