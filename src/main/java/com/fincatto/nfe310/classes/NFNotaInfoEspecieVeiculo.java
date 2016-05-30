package com.fincatto.nfe310.classes;

public enum NFNotaInfoEspecieVeiculo {
    PASSAGEIRO("1", "Passageiro"),
    CARGA("2", "Carga"),
    MISTO("3", "Misto"),
    CORRIDA("4", "Corrida"),
    TRACAO("5", "Tração"),
    ESPECIAL("6", "Especial"),
    COLECAO("7", "Coleção");

    private final String codigo;
    private final String desc;

    NFNotaInfoEspecieVeiculo(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}