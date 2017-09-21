package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Eldevan Nery Junior on 30/05/17.
 */
public enum MDFTipoProprietario {

    /**
     * 0-TAC – Agregado;
     * 1-TAC Independente; ou
     * 2 – Outros.
     */
    TAC_AGREGADO("0", "TAC – Agregado"),
    TAC_INDEPENDENTE("1", "TAC – Independente"),
    OUTROS("2", "Outros");

    private final String codigo;
    private final String descricao;

    MDFTipoProprietario(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoProprietario valueOfCodigo(final String codigo) {
        for (MDFTipoProprietario tipoUnidadeCarga : MDFTipoProprietario.values()) {
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
