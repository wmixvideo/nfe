package com.fincatto.dfe.classes;

public enum DFAmbiente {

    PRODUCAO("1"),
    HOMOLOGACAO("2");

    private final String codigo;

    private DFAmbiente(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public boolean isHomologacao() {
    	return this == HOMOLOGACAO;
    }

    public boolean isProducao() {
    	return this == PRODUCAO;
    }

    public static DFAmbiente valueOfCodigo(final String codigo) {
        for (DFAmbiente ambiente : DFAmbiente.values()) {
            if (ambiente.getCodigo().equalsIgnoreCase(codigo)) {
                return ambiente;
            }
        }
        return null;
    }
}
