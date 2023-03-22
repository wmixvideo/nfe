package com.fincatto.documentofiscal.nfe400.classes;

import org.apache.commons.lang3.StringUtils;

public enum NFNotaInfoTipoVeiculo {

    CICLOMOTO("2", "Ciclomotor"),
    MOTONETA("3", "Motoneta"),
    MOTOCICLO("4", "Motociclo"),
    TRICICLO("5", "Triciclo"),
    AUTOMOVEL("6", "Autom\u00f3vel"),
    MICROONIBUS("7", "Micro\u00f4nibus"),
    ONIBUS("8", "\u00d4nibus"),
    REBOQUE("10", "Reboque"),
    SEMIRREBOQUE("11", "Semirreboque"),
    CAMINHONETA("13", "Caminhoneta"),
    CAMINHAO("14", "Caminh\u00e3o"),
    TRATOR("17", "Trator"),
    TRATOR_RODAS("18","Trator rodas"),
    TRATOR_ESTEIRAS("19","Trator esteiras"),
    TRATOR_MISTO("20","Trator misto"),
    QUADRICICLO("21","Quadriciclo"),
    ESP_ONIBUS("22", "Especial \u00d4nibus"),
    CARGA_CAM("24", "Carga"),
    MISTO_CAM("23", "Misto"),
    UTILITARIO("25","Utilit\u00e1rio"),
    MOTOR_CASA("26","Motor Casa");



    private final String codigo;
    private final String descricao;

    NFNotaInfoTipoVeiculo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
        return codigo + " - " + descricao;
    }
}