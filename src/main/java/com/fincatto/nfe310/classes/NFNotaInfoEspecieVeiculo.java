package com.fincatto.nfe310.classes;

public enum NFNotaInfoEspecieVeiculo {
    PASSAGEIRO("1"),
    CARGA("2"),
    MISTO("3"),
    CORRIDA("4"),
    TRACAO("5"),
    ESPECIAL("6"),
    COLECAO("7");

    private String codigo;

    private NFNotaInfoEspecieVeiculo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoEspecieVeiculo valueOfCodigo(final String codigo) {
        for (final NFNotaInfoEspecieVeiculo especieVeiculo : NFNotaInfoEspecieVeiculo.values()) {
            if (especieVeiculo.getCodigo().equals(codigo)) {
                return especieVeiculo;
            }
        }
        return null;
    }
}