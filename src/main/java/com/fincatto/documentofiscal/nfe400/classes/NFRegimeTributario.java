package com.fincatto.documentofiscal.nfe400.classes;

public enum NFRegimeTributario {

    SIMPLES_NACIONAL("1", "Simples nacional"),
    SIMPLES_NACIONAL_EXCESSO_RECEITA("2", "Simples nacional com excesso de sublimite da receita bruta"),
    NORMAL("3", "Regime normal"),
    MEI("4", "Simples Nacional - Microempreendedor Individual - MEI");

    private final String codigo;
    private final String descricao;

    NFRegimeTributario(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFRegimeTributario valueOfCodigo(final String codigo) {
        for (final NFRegimeTributario regimeTributario : NFRegimeTributario.values()) {
            if (regimeTributario.getCodigo().equals(codigo)) {
                return regimeTributario;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}