package com.fincatto.nfe310.classes;

public enum NFAmbiente {

    PRODUCAO("1"),
    HOMOLOGACAO("2");

    private final String codigo;

    private NFAmbiente(final String codigo) {
        this.codigo = codigo;
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
}
