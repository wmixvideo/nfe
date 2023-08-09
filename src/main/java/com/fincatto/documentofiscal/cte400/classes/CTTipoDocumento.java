package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoDocumento {

	DECLARACAO("00", "Declaração"),
	DUTOVIARIO("10", "Dutoviário"),
	CFeSAT("59", "CFe-SAT"),
	NFCe("65", "NFC-e"),
	OUTROS("99", "Outros");

    private final String codigo;
    private final String descricao;

    CTTipoDocumento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoDocumento valueOfCodigo(final String codigo) {
        for (final CTTipoDocumento tipo : CTTipoDocumento.values()) {
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