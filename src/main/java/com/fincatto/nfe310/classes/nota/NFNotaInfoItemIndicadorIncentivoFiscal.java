package com.fincatto.nfe310.classes.nota;

public enum NFNotaInfoItemIndicadorIncentivoFiscal {
    SIM("1"),
    NAO("2");

    private String codigo;

    private NFNotaInfoItemIndicadorIncentivoFiscal(final String codigo) {
        this.codigo = codigo;
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
}