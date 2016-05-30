package com.fincatto.nfe310.classes;

public enum NFNotaInfoCombustivelTipo {

    ALCOOL("01", "Álcool"),
    GASOLINA("02", "Gasolina"),
    DIESEL("03", "Diesel"),
    GASOGENIO("04", "Gasogênio"),
    GAS_METANO("05", "Gás metano"),
    ELETRICO_FONTE_INTERNA("06", "Elétrico (fonte interna)"),
    ELETRICO_FONTE_EXTERNA("07", "Elétrico (fonte externa)"),
    GASOL_GAS_NATURAL_COMBUSTIVEL("08", "Gasol/Gás natural/Combustível"),
    ALCOOL_GAS_NATURAL("09", "Álcool/Gás natural"),
    DIESEL_GAS_NATURAL("10", "Diesel/Gás natural"),
    VIDE_CAMPO_OBSERVACAO("11", "Vide campo observação"),
    ALCOOL_GAS_NATURAL_VEICULAR("12", "Álcool/Gás natural veicular"),
    GASOLINA_GAS_NATURAL_VEICULAR("13", "Gasolina/Gás natural veicular"),
    DIESEL_GAS_NATURAL_VEICULAR("14", "Diesel/Gás natural veicular"),
    GAS_NATURAL_VEICULAR("15", "Gás natural veicular"),
    ALCOOL_GASOLINA("16", "Álcool/Gasolina"),
    GASOLINA_ALCOOL_GAS_NATURAL("17", "Gasolina/Álcool/Gás natural"),
    GASOLINA_ELETRICO("18", "Gasolina/Elétrico");

    private final String codigo;
    private final String desc;

    NFNotaInfoCombustivelTipo(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
    
}