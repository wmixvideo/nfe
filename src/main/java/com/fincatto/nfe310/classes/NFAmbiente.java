package com.fincatto.nfe310.classes;

public enum NFAmbiente {

    PRODUCAO("1", "Produção"),
    HOMOLOGACAO("2", "Homologação");

    private final String codigo;
    private final String desc;

    NFAmbiente(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFAmbiente valueOfCodigo(final String codigo) {
        for (NFAmbiente ambiente : NFAmbiente.values()) {
            if (ambiente.getCodigo().equalsIgnoreCase(codigo)) {
                return ambiente;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}
