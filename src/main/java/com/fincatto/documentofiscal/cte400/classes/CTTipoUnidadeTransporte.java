package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoUnidadeTransporte {

	RODOVIARIO_TRACAO("1", "Rodoviário Tração"),
	RODOVIARIO_REBOQUE("2", "Rodoviário Reboque"),
	NAVIO("3", "Navio"),
	BALSA("4", "Balsa"),
	AERONAVE("5", "Aeronave"),
	VAGAO("6", "Vagão"),
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
        for (final CTTipoUnidadeTransporte tipo : CTTipoUnidadeTransporte.values()) {
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