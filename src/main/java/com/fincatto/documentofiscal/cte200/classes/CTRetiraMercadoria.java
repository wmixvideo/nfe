package com.fincatto.documentofiscal.cte200.classes;

public enum CTRetiraMercadoria {

    SIM("0", "Sim"),
    NAO("1", "Nao");

    private final String codigo;
    private final String descricao;

    CTRetiraMercadoria(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTRetiraMercadoria valueOfCodigo(final String codigo) {
        for (final CTRetiraMercadoria formaPagamento : CTRetiraMercadoria.values()) {
            if (formaPagamento.getCodigo().equals(codigo)) {
                return formaPagamento;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}