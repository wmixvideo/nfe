package com.fincatto.documentofiscal.nfe400.classes;

public enum NFOrigemProcesso {

    SEFAZ("0", "Sefaz"),
    JUSTICA_FEDERAL("1", "Justi\u00e7a Federal"),
    JUSTICA_ESTADUAL("2", "Justi\u00e7a Estadual"),
    SECEX_RFB("3", "Secex RFB"),
    CONFAZ("4", "CONFAZ"),
    OUTROS("9", "Outros");

    private final String codigo;
    private final String descricao;

    NFOrigemProcesso(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
        return codigo + " - " + descricao;
    }
}