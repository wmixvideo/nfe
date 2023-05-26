package com.fincatto.documentofiscal.cte300.classes;

public enum CTTipoEspecieGtv {

    NUMERARIO("1", "Numerário"),
    CHEQUE("2", "Cheque"),
    MOEDA("3", "Moeda"),
    OUTROS("4", "Outros");

    private final String codigo;
    private final String descricao;

    CTTipoEspecieGtv(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoEspecieGtv valueOfCodigo(final String codigo) {
        for (final CTTipoEspecieGtv tipo : CTTipoEspecieGtv.values()) {
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
