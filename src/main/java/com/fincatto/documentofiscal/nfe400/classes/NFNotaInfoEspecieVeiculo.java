package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoEspecieVeiculo {

    PASSAGEIRO("1", "Passageiro"),
    CARGA("2", "Carga"),
    MISTO("3", "Misto"),
    CORRIDA("4", "Corrida"),
    TRACAO("5", "Tra\u00e7\u00e3o"),
    ESPECIAL("6", "Especial"),
    COLECAO("7", "Cole\u00e7\u00e3o");

    private final String codigo;
    private final String descricao;

    NFNotaInfoEspecieVeiculo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}