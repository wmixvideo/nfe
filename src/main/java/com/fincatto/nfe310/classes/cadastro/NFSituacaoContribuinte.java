package com.fincatto.nfe310.classes.cadastro;

public enum NFSituacaoContribuinte {

    NAO_HABILITADO(0),
    HABILITADO(1);

    private int codigo;

    private NFSituacaoContribuinte(final int codigo) {
        this.codigo = codigo;
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
}