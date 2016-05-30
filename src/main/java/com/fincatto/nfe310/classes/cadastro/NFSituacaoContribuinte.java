package com.fincatto.nfe310.classes.cadastro;

public enum NFSituacaoContribuinte {

    NAO_HABILITADO(0, "Não habilitado"),
    HABILITADO(1, "Habilitado");

    private final int codigo;
    private final String desc;

    NFSituacaoContribuinte(final int codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public static NFSituacaoContribuinte valueOfCodigo(final int codigo) {
        for (final NFSituacaoContribuinte situacaoContribuinte : NFSituacaoContribuinte.values()) {
            if (situacaoContribuinte.getCodigo() == codigo) {
                return situacaoContribuinte;
            }
        }
        throw new IllegalStateException(String.format("Codigo nao mapeado (%s)", codigo));
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}