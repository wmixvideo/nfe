package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoDirecao {

    NORTE("N", "NORTE"),
    LESTE("L", "LESTE"),
    SUL("S", "SUL"),
    OESTE("O", "OESTE");

    private final String codigo;
    private final String descricao;

    CTTipoDirecao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoDirecao valueOfCodigo(final String codigo) {
        for (final CTTipoDirecao tipo : CTTipoDirecao.values()) {
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