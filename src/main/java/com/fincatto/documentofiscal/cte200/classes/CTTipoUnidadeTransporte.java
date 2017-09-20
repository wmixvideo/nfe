package com.fincatto.documentofiscal.cte200.classes;

public enum CTTipoUnidadeTransporte {

    RODOVIARIO_TRACAO("1", "Rodovia\u0301rio Trac\u0327a\u0303o"),
    RODOVIARIO_REBOQUE("2", "Rodovia\u0301rio Reboque"),
    NAVIO("3", "Navio"),
    BALSA("4", "Balsa"),
    AERONAVE("5", "Aeronave"),
    VAGAO("6", "Vaga\u0303o"),
    OUTROS("7", "Outros");

    private final String codigo;
    private final String descricao;

    CTTipoUnidadeTransporte(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoUnidadeTransporte valueOfCodigo(final String codigo) {
        for (final CTTipoUnidadeTransporte formaPagamento : CTTipoUnidadeTransporte.values()) {
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