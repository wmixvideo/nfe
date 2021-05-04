package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author Edivaldo Merlo Stens on 29/06/20.
 */
public enum MDFTipoInfPagComp {

    VALE_PEDAGIO("01", "Vale Ped\u00e1gio"),
    IMPOSTO_TAXAS_CONTRIBUICOES("02", "Impostos, taxas e contribui\u00e7\u00f5es"),
    DESPESAS_MEIOS_PAGTO("03", "Despesas (banc\u00e1rias, meios de pagamento, outras)"),
    OUTROS("99", "Outros");

    private final String codigo;
    private final String descricao;

    MDFTipoInfPagComp(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static MDFTipoInfPagComp valueOfCodigo(final String codigo) {
        for (MDFTipoInfPagComp tipoEmitente : MDFTipoInfPagComp.values()) {
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
