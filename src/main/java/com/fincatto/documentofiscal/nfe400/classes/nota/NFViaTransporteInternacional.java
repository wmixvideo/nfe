package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFViaTransporteInternacional {

    MARITIMA("1", "Mar\u00edtima"),
    FLUVIAL("2", "Fluvial"),
    LACUSTRE("3", "Lacustre"),
    AEREA("4", "A\u00e9rea"),
    POSTAL("5", "Postal"),
    FERROVIARIA("6", "Ferrovi\u00e1ria"),
    RODOVIARIA("7", "Rodovi\u00e1ria"),
    CONDUTO_REDE_TRANSMISSAO("8", "Conduto rede transmiss\u00e3o"),
    MEIOS_PROPRIOS("9", "Meios pr\u00f3prios"),
    ENTRADA_SAIDA("10", "Entrada/Sa\u00edda"),
    COURIER("11", "Courier"),
    HANDCARRY("12", "Handcarry");

    private final String codigo;
    private final String descricao;

    NFViaTransporteInternacional(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFViaTransporteInternacional valueOfCodigo(final String codigo) {
        for (final NFViaTransporteInternacional via : NFViaTransporteInternacional.values()) {
            if (via.getCodigo().equals(codigo)) {
                return via;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}