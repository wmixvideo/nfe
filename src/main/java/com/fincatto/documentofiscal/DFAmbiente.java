package com.fincatto.documentofiscal;

public enum DFAmbiente {

    PRODUCAO("1", "Produ\u00e7\u00e3o"),
    HOMOLOGACAO("2", "Homologa\u00e7\u00e3o");

    private final String codigo;
    private final String descricao;

    DFAmbiente(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static DFAmbiente valueOfCodigo(final String codigo) {
        for (DFAmbiente ambiente : DFAmbiente.values()) {
            if (ambiente.getCodigo().equalsIgnoreCase(codigo)) {
                return ambiente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
