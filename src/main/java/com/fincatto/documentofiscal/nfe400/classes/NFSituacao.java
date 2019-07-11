package com.fincatto.documentofiscal.nfe400.classes;

public enum NFSituacao {

    AUTORIZADO("1", "Uso autorizado"),
    DENEGADO("2", "Uso denegado"),
    CANCELADO("3", "NF-e cancelada");

    private final String codigo;
    private final String descricao;

    NFSituacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFSituacao valueOfCodigo(final String codigo) {
        for (final NFSituacao situacao : NFSituacao.values()) {
            if (situacao.getCodigo().equals(codigo)) {
                return situacao;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}