package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFNotaInfoItemIndicadorIncentivoFiscal {

    SIM("1", "Sim"),
    NAO("2", "N\u00e3o");

    private final String codigo;
    private final String descricao;

    NFNotaInfoItemIndicadorIncentivoFiscal(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
        return codigo + " - " + descricao;
    }
}