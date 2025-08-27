package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoImpressao {

    RETRATO("1", "Retrato"),
    PAISAGEM("2", "Paisagem");

    private final String codigo;
    private final String descricao;

    CTTipoImpressao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoImpressao valueOfCodigo(final String codigo) {
        for (final CTTipoImpressao tipo : CTTipoImpressao.values()) {
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