package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author FAGNER ROGER
 */
public enum MDFTipoValePedagio {

    TAG("01", "TAG"),
    CUPOM("02", "Cupom"),
    CARTAO("03", "Cart\u00E3o");

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
        for (MDFTipoValePedagio tipoEmitente : MDFTipoValePedagio.values()) {
            if (tipoEmitente.getCodigo().equalsIgnoreCase(codigo)) {
                return tipoEmitente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
