package com.fincatto.nfe310.classes;

public enum NFNotaInfoTipoVeiculo {

    AUTOMOVEL("06", "Automóvel"),
    CAMINHAO("14", "Caminhão"),
    CAMINHONETA("13", "Caminhoneta"),
    CARGA_CAM("24", "Carga"),
    CICLOMOTO("02", "Ciclomotor"),
    ESP_ONIBUS("22", "Especial Ônibus"),
    MICROONIBUS("07", "Microônibus"),
    MISTO_CAM("23", "Misto"),
    MOTOCICLO("04", "Motociclo"),
    MOTONETA("03", "Motoneta"),
    ONIBUS("08", "Ônibus"),
    REBOQUE("10", "Reboque"),
    TRICICLO("05", "Triciclo"),
    TRATOR("17", "Trator");

    private final String codigo;
    private final String desc;

    NFNotaInfoTipoVeiculo(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoTipoVeiculo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoTipoVeiculo tipoVeiculo : NFNotaInfoTipoVeiculo.values()) {
            if (tipoVeiculo.getCodigo().equals(codigo)) {
                return tipoVeiculo;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}