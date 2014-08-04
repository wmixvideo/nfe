package com.fincatto.nfe.classes.nota;

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
}