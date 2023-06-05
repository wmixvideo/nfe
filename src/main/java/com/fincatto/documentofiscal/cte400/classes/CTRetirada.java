package com.fincatto.documentofiscal.cte400.classes;

public enum CTRetirada {

    SIM("0", "Sim"),
    NAO("1", "Não");

    private final String codigo;
    private final String descricao;

    CTRetirada(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTRetirada valueOfCodigo(final String codigo) {
        for (final CTRetirada tipo : CTRetirada.values()) {
            if (tipo.getCodigo().equals(codigo)) {
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