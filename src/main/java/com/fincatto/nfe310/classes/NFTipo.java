package com.fincatto.nfe310.classes;

public enum NFTipo {

    ENTRADA("0", "Entrada"),
    SAIDA("1", "Saída");

    private final String codigo;
    private final String desc;

    NFTipo(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipo valueOfCodigo(final String codigo) {
        for (final NFTipo tipo : NFTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}