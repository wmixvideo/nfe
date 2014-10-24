package com.fincatto.nfe200.classes;

public enum NFNotaInfoTipoVeiculo {

    AUTOMOVEL("06"),
    CAMINHAO("14"),
    CAMINHONETA("13"),
    CARGA_CAM("24"),
    CICLOMOTO("02"),
    ESP_ONIBUS("22"),
    MICROONIBUS("07"),
    MISTO_CAM("23"),
    MOTOCICLO("04"),
    MOTONETA("03"),
    ONIBUS("08"),
    REBOQUE("10"),
    TRICICLO("05"),
    TRATOR("17");

    private String codigo;

    private NFNotaInfoTipoVeiculo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoTipoVeiculo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoTipoVeiculo veiculo : NFNotaInfoTipoVeiculo.values()) {
            if (veiculo.getCodigo().equals(codigo)) {
                return veiculo;
            }
        }
        return null;
    }
}