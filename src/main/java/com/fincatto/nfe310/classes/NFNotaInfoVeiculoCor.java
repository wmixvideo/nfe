package com.fincatto.nfe310.classes;

public enum NFNotaInfoVeiculoCor {

    AMARELA("01"),
    AZUL("02"),
    BEGE("03"),
    BRANCA("04"),
    CINZA("05"),
    DOURADA("06"),
    GRENA("07"),
    LARANJA("08"),
    MARROM("09"),
    PRATA("10"),
    PRETA("11"),
    ROSA("12"),
    ROXA("13"),
    VERDE("14"),
    VERMELHA("15"),
    FANTASIA("16");

    private String codigo;

    private NFNotaInfoVeiculoCor(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoVeiculoCor valueOfCodigo(final String codigo) {
        for (final NFNotaInfoVeiculoCor veiculoCor : NFNotaInfoVeiculoCor.values()) {
            if (veiculoCor.getCodigo().equals(codigo)) {
                return veiculoCor;
            }
        }
        return null;
    }
}