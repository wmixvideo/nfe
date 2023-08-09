package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoUnidadeCarga {

	CONTAINER("1", "Container"),
	ULD("2", "ULD"),
	PALLET("3", "Pallet"),
	OUTROS("4", "Outros");

    private final String codigo;
    private final String descricao;

    CTTipoUnidadeCarga(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoUnidadeCarga valueOfCodigo(final String codigo) {
        for (final CTTipoUnidadeCarga tipo : CTTipoUnidadeCarga.values()) {
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