package com.fincatto.documentofiscal.cte400.classes;

public enum CTModeloNF {

	NF_Modelo_01_ou_1A_ou_Avulsa("01", "NF Modelo 01/1A e Avulsa"),
	NF_DE_PRODUTOR("04", "NF de Produtor");

    private final String codigo;
    private final String descricao;

    CTModeloNF(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTModeloNF valueOfCodigo(final String codigo) {
        for (final CTModeloNF tipo : CTModeloNF.values()) {
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