package com.fincatto.documentofiscal.cte400.classes;

public enum CTUnidadeMedida {

    M3("00", "M3"),
    KG("01", "KG"),
    TON("02", "TON"),
    UNIDADE("03", "UNIDADE"),
    LITROS("04", "LITROS"),
    MMBTU("05", "MMBTU");

    private final String codigo;
    private final String descricao;

    CTUnidadeMedida(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTUnidadeMedida valueOfCodigo(final String codigo) {
        for (final CTUnidadeMedida tipo : CTUnidadeMedida.values()) {
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