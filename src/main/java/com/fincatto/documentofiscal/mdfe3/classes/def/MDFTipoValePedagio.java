package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Edivaldo Ramos on 19/11/22.
 */
public enum MDFTipoValePedagio {

    /**
     * 01 - TAG; 02 - Cupom; 03 - Cartão
     */
    TAG("01","TAG"),
    CUPOM("02","Cupom"),
    CARTAO("03","Cart\u00e3o");

    private final String codigo;
    private final String descricao;

    MDFTipoValePedagio(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoValePedagio valueOfCodigo(final String codigo) {
        for (MDFTipoValePedagio tpValePedagio : MDFTipoValePedagio.values()) {
            if (tpValePedagio.getCodigo().equalsIgnoreCase(codigo)) {
                return tpValePedagio;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
