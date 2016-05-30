package com.fincatto.nfe310.classes.nota;

public enum NFViaTransporteInternacional {

    MARITIMA("1", "Marítima"),
    FLUVIAL("2", "Fluvial"),
    LACUSTRE("3", "Lacustre"),
    AEREA("4", "Aérea"),
    POSTAL("5", "Postal"),
    FERROVIARIA("6", "Ferroviária"),
    RODOVIARIA("7", "Rodoviária"),
    CONDUTO_REDE_TRANSMISSAO("8", "Conduto rede transmissão"),
    MEIOS_PROPRIOS("9", "Meios próprios"),
    ENTRADA_SAIDA("10", "Entrada/Saída"),
    COURIER("11", "Courier"),
    HANDCARRY("12", "Handcarry");

    private final String codigo;
    private final String desc;

    NFViaTransporteInternacional(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}