package com.fincatto.documentofiscal.cte200.classes;

public enum CTTipoCte {

    NORMAL("0", "CT-e Normal"),
    COMPLEMENTO("1", "CT-e de Complemento de Valores"),
    ANULACAO("2", "CT-e de Anulac\u0327a\u0303o"),
    SUBSTITUTO("3", "CT-e Substituto");

    private final String codigo;
    private final String descricao;

    CTTipoCte(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTTipoCte valueOfCodigo(final String codigo) {
        for (final CTTipoCte tipo : CTTipoCte.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}