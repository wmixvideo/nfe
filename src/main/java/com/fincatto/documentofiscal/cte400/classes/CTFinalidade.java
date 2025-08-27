package com.fincatto.documentofiscal.cte400.classes;

public enum CTFinalidade {

    NORMAL("0", "CT-e Normal"),
    COMPLEMENTAR("1", "CT-e de Complemento de Valores"),
    SUBSTITUTO("3", "CT-e de Substituição");

    private final String codigo;
    private final String descricao;

    CTFinalidade(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTFinalidade valueOfCodigo(final String codigo) {
        for (final CTFinalidade tipo : CTFinalidade.values()) {
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