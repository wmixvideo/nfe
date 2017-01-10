package com.fincatto.dfe.classes;

public enum DFModelo {

    NFE("55", "NF-e"),
    NFCE("65", "NFC-e"),
    CTE("57", "CT-e");

    private final String codigo;
    private final String descricao;

    DFModelo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static DFModelo valueOfCodigo(final String codigo) {
        for (final DFModelo tipo : DFModelo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getCodigo() + " - " + getDescricao();
    }
}