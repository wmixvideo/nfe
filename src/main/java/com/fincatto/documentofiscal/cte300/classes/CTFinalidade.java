package com.fincatto.documentofiscal.cte300.classes;

public enum CTFinalidade {

    NORMAL("0", "Normal"),
    COMPLEMENTAR_VALORES("1", "Complementar de Valores"),
    ANULACAO("2", "Anulação"),
    DEVOLUCAO_OU_RETORNO("3", "Substituto");

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