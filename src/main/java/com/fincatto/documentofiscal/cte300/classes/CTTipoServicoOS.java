package com.fincatto.documentofiscal.cte300.classes;

public enum CTTipoServicoOS {

    TRANSPORTE_DE_PESSOAS("6", "Transporte de Pessoas"),
    TRANSPORTE_DE_VALORES("7", "Transporte de Valores"),
    EXCESSO_DE_BAGAGEM("8", "Excesso de Bagagem");

    private final String codigo;
    private final String descricao;

    CTTipoServicoOS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoServicoOS valueOfCodigo(final String codigo) {
        for (final CTTipoServicoOS tipo : CTTipoServicoOS.values()) {
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