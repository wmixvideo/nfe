package com.fincatto.documentofiscal.cte200.classes;

public enum CTUnidadeMedida {

    M3("00", "Metro c\u00fabico"),
    KG("01", "Quilo"),
    TON("02", "Tonelada"),
    UNIDADE("03", "Unidade"),
    LITRO("04", "Litro"),
    MMBTU("05", "Million BTU");

    private final String codigo;
    private final String descricao;

    CTUnidadeMedida(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
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
        return this.codigo + " - " + this.descricao;
    }
}