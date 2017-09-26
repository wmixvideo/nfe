package com.fincatto.documentofiscal.cte300.classes;

public enum CTClasseTarifa {

	Tarifa_Minima("M", "Tarifa Mínima"),
	Tarifa_Geral("G", "Tarifa Geral"),
	Tarifa_Específica("E", "Tarifa Especifica");

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