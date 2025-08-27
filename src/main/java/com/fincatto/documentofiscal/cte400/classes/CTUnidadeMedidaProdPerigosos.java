package com.fincatto.documentofiscal.cte400.classes;

public enum CTUnidadeMedidaProdPerigosos {

    KG("1", "KG"),
    KG_G("2", "KG G (quilograma bruto)"),
    LITROS("3", "LITROS"),
    TI("4", "TI (Índice de Transporte para Radioativos)"),
    UNIDADES("5", "Unidades (apenas para artigos perigosos medidos em unidades que não se enquadram nos itens acima. Exemplo: baterias, celulares, equipamentos, veículos, dentre outros)");

    private final String codigo;
    private final String descricao;

    CTUnidadeMedidaProdPerigosos(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTUnidadeMedidaProdPerigosos valueOfCodigo(final String codigo) {
        for (final CTUnidadeMedidaProdPerigosos tipo : CTUnidadeMedidaProdPerigosos.values()) {
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