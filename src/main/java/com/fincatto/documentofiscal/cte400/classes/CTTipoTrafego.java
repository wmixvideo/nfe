package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoTrafego {

    PROPRIO("0", "Próprio"),
    MUTUO("1", "Mútuo"),
    RODOFERROVIARIO("2", "Rodoferroviário"),
    RODOVIARIO("3", "Rodoviário");

    private final String codigo;
    private final String descricao;

    CTTipoTrafego(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoTrafego valueOfCodigo(final String codigo) {
        for (final CTTipoTrafego tipo : CTTipoTrafego.values()) {
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