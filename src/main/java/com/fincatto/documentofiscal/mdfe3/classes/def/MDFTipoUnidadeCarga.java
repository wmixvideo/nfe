package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Eldevan Nery Junior on 30/05/17.
 */
public enum MDFTipoUnidadeCarga {

    /**
     * 1 - Container;
     * 2 - ULD;
     * 3 - Pallet;
     * 4 - Outros;
     */
    CONTAINER("1", "Container"),
    ULD("2", "ULD"),
    PALLET("3", "Pallet"),
    OUTROS("4", "Outros");

    private final String codigo;
    private final String descricao;

    MDFTipoUnidadeCarga(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoUnidadeCarga valueOfCodigo(final String codigo) {
        for (MDFTipoUnidadeCarga tipoUnidadeCarga : MDFTipoUnidadeCarga.values()) {
            if (tipoUnidadeCarga.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoUnidadeCarga;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
