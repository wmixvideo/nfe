package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoRegimeTributario {

	SIMPLES_NACIONAL("1", "Simples Nacional"),
	SIMPLES_NACIONAL_EXCESSO_SUBLIME_RECEITA_BRUTA("2", "Simples Nacional, excesso sublimite de receita bruta"),
	REGIME_NORMAL("3", "Regime Normal"),
    SIMPLES_NACIONAL_MEI("4", "Simples Nacional - Microempreendedor Individual – MEI");

    private final String codigo;
    private final String descricao;

    CTTipoRegimeTributario(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoRegimeTributario valueOfCodigo(final String codigo) {
        for (final CTTipoRegimeTributario tipo : CTTipoRegimeTributario.values()) {
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