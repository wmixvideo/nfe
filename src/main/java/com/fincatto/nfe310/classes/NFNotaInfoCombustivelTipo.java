package com.fincatto.nfe310.classes;

public enum NFNotaInfoCombustivelTipo {

    ALCOOL("01"),
    GASOLINA("02"),
    DIESEL("03"),
    GASOGENIO("04"),
    GAS_METANO("05"),
    ELETRICO_FONTE_INTERNA("06"),
    ELETRICO_FONTE_EXTERNA("07"),
    GASOL_GAS_NATURAL_COMBUSTIVEL("08"),
    ALCOOL_GAS_NATURAL("09"),
    DIESEL_GAS_NATURAL("10"),
    VIDE_CAMPO_OBSERVACAO("11"),
    ALCOOL_GAS_NATURAL_VEICULAR("12"),
    GASOLINA_GAS_NATURAL_VEICULAR("13"),
    DIESEL_GAS_NATURAL_VEICULAR("14"),
    GAS_NATURAL_VEICULAR("15"),
    ALCOOL_GASOLINA("16"),
    GASOLINA_ALCOOL_GAS_NATURAL("17"),
    GASOLINA_ELETRICO("18");

    private String codigo;

    private NFNotaInfoCombustivelTipo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoCombustivelTipo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoCombustivelTipo tipo : NFNotaInfoCombustivelTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}