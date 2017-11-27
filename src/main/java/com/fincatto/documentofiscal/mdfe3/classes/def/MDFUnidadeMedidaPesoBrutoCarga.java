package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Eldevan Nery Junior on 30/05/17.
 */
public enum MDFUnidadeMedidaPesoBrutoCarga {

    /**
     * 01 – KG; 02 - TON
     */
    KG("01", "Kilograma"),
    TON("02", "Tonelada");

    private final String codigo;
    private final String descricao;

    MDFUnidadeMedidaPesoBrutoCarga(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFUnidadeMedidaPesoBrutoCarga valueOfCodigo(final String codigo) {
        for (MDFUnidadeMedidaPesoBrutoCarga pesoBrutoCarga : MDFUnidadeMedidaPesoBrutoCarga.values()) {
            if (pesoBrutoCarga.getCodigo().equalsIgnoreCase(codigo)) {
                return pesoBrutoCarga;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
