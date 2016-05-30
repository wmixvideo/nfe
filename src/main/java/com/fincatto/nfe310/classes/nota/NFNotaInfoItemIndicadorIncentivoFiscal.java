package com.fincatto.nfe310.classes.nota;

public enum NFNotaInfoItemIndicadorIncentivoFiscal {
    SIM("1", "Sim"),
    NAO("2", "Não");

    private final String codigo;
    private final String desc;

    NFNotaInfoItemIndicadorIncentivoFiscal(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemIndicadorIncentivoFiscal valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemIndicadorIncentivoFiscal incentivoFiscal : NFNotaInfoItemIndicadorIncentivoFiscal.values()) {
            if (incentivoFiscal.getCodigo().equals(codigo)) {
                return incentivoFiscal;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}