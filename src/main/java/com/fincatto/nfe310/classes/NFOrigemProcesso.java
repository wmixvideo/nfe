package com.fincatto.nfe310.classes;

public enum NFOrigemProcesso {
    SEFAZ("0"),
    JUSTICA_FEDERAL("1"),
    JUSTICA_ESTADUAL("2"),
    SECEX_RFB("3"),
    OUTROS("9");

    private String codigo;

    private NFOrigemProcesso(final String codigo) {
        this.codigo = codigo;
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
}