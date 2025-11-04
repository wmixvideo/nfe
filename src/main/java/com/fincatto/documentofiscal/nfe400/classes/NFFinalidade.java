package com.fincatto.documentofiscal.nfe400.classes;

public enum NFFinalidade {

    NORMAL("1", "NF-e normal"),
    COMPLEMENTAR("2", "NF-e complementar"),
    AJUSTE("3", "NF-e de ajuste"),
    DEVOLUCAO_MERCADORIA("4", "Devolu\u00e7\u00e3o de mercadoria"),
    NOTA_CREDITO("5", "Nota de cr\u00e9dito"),
    NOTA_DEBITO("6", "Nota de d\u00e9bito");

    private final String codigo;
    private final String descricao;

    NFFinalidade(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFFinalidade valueOfCodigo(final String codigo) {
        for (final NFFinalidade tipo : NFFinalidade.values()) {
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