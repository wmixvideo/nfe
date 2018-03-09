package com.fincatto.documentofiscal.nfe400.classes;

import org.apache.commons.lang3.StringUtils;

public enum NFNotaInfoTipoVeiculo {

    AUTOMOVEL("06", "Autom\u00f3vel"),
    CAMINHAO("14", "Caminh\u00e3o"),
    CAMINHONETA("13", "Caminhoneta"),
    CARGA_CAM("24", "Carga"),
    CICLOMOTO("02", "Ciclomotor"),
    ESP_ONIBUS("22", "Especial \u00d4nibus"),
    MICROONIBUS("07", "Micro\u00f4nibus"),
    MISTO_CAM("23", "Misto"),
    MOTOCICLO("04", "Motociclo"),
    MOTONETA("03", "Motoneta"),
    ONIBUS("08", "\u00d4nibus"),
    REBOQUE("10", "Reboque"),
    TRICICLO("05", "Triciclo"),
    TRATOR("17", "Trator");

    private final String codigo;
    private final String descricao;

    NFNotaInfoTipoVeiculo(final String codigo, final String descricao) {
        this.codigo = StringUtils.leftPad(codigo,2,"0");
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoTipoVeiculo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoTipoVeiculo tipoVeiculo : NFNotaInfoTipoVeiculo.values()) {
            if (tipoVeiculo.getCodigo().equals(StringUtils.leftPad(codigo,2,"0"))) {
                return tipoVeiculo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}