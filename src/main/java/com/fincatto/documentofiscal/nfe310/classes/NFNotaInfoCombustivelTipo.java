package com.fincatto.documentofiscal.nfe310.classes;

import org.apache.commons.lang3.StringUtils;

public enum NFNotaInfoCombustivelTipo {

    ALCOOL("01", "\u00c1lcool"),
    GASOLINA("02", "Gasolina"),
    DIESEL("03", "Diesel"),
    GASOGENIO("04", "Gasog\u00eanio"),
    GAS_METANO("05", "G\u00e1s metano"),
    ELETRICO_FONTE_INTERNA("06", "El\u00e9trico (fonte interna)"),
    ELETRICO_FONTE_EXTERNA("07", "El\u00e9trico (fonte externa)"),
    GASOL_GAS_NATURAL_COMBUSTIVEL("08", "Gasol/G\u00e1s natural/Combust\u00edvel"),
    ALCOOL_GAS_NATURAL("09", "\u00c1lcool/G\u00e1s natural"),
    DIESEL_GAS_NATURAL("10", "Diesel/G\u00e1s natural"),
    VIDE_CAMPO_OBSERVACAO("11", "Vide campo observa\u00e7\u00e3o"),
    ALCOOL_GAS_NATURAL_VEICULAR("12", "\u00c1lcool/G\u00e1s natural veicular"),
    GASOLINA_GAS_NATURAL_VEICULAR("13", "Gasolina/G\u00e1s natural veicular"),
    DIESEL_GAS_NATURAL_VEICULAR("14", "Diesel/G\u00e1s natural veicular"),
    GAS_NATURAL_VEICULAR("15", "G\u00e1s natural veicular"),
    ALCOOL_GASOLINA("16", "\u00c1lcool/Gasolina"),
    GASOLINA_ALCOOL_GAS_NATURAL("17", "Gasolina/\u00c1lcool/G\u00e1s natural"),
    GASOLINA_ELETRICO("18", "Gasolina/El\u00e9trico");

    private final String codigo;
    private final String descricao;

    NFNotaInfoCombustivelTipo(final String codigo, final String descricao) {
        this.codigo = StringUtils.leftPad(codigo,2,"0");
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoCombustivelTipo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoCombustivelTipo tipo : NFNotaInfoCombustivelTipo.values()) {
            if (tipo.getCodigo().equals(StringUtils.leftPad(codigo,2,"0"))) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}