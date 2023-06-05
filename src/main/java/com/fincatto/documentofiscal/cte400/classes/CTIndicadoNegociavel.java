package com.fincatto.documentofiscal.cte400.classes;

public enum CTIndicadoNegociavel {

    NAO_NEGOCIAVEL("0", "Não Negociável"),
    NEGOCIAVEL("1", "Negociável");

    private final String codigo;
    private final String descricao;

    CTIndicadoNegociavel(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTIndicadoNegociavel valueOfCodigo(final String codigo) {
        for (final CTIndicadoNegociavel tipo : CTIndicadoNegociavel.values()) {
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