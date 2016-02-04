package com.fincatto.nfe310.classes.nota;

public enum NFViaTransporteInternacional {

    MARITIMA("1"),
    FLUVIAL("2"),
    LACUSTRE("3"),
    AEREA("4"),
    POSTAL("5"),
    FERROVIARIA("6"),
    RODOVIARIA("7"),
    CONDUTO_REDE_TRANSMISSAO("8"),
    MEIOS_PROPRIOS("9"),
    ENTRADA_SAIDA("10"),
    COURIER("11"),
    HANDCARRY("12");

    private String codigo;

    private NFViaTransporteInternacional(final String codigo) {
        this.codigo = codigo;
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
}