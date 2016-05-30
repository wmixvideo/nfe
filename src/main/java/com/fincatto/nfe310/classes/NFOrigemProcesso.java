package com.fincatto.nfe310.classes;

public enum NFOrigemProcesso {
    SEFAZ("0", "Sefaz"),
    JUSTICA_FEDERAL("1", "Justiça Federal"),
    JUSTICA_ESTADUAL("2", "Justiça Estadual"),
    SECEX_RFB("3", "Secex RFB"),
    OUTROS("9", "Outros");

    private final String codigo;
    private final String desc;

    NFOrigemProcesso(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFOrigemProcesso valueOfCodigo(final String codigo) {
        for (final NFOrigemProcesso origemProcesso : NFOrigemProcesso.values()) {
            if (origemProcesso.getCodigo().equals(codigo)) {
                return origemProcesso;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}