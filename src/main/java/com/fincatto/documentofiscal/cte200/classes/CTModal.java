package com.fincatto.documentofiscal.cte200.classes;

public enum CTModal {

    RODOVIARIO("01", "Rodovi\u00e1rio"),
    AEREO("02", "Ae\u0301reo"),
    AQUAVIARIO("03", "Aquavia\u0301rio"),
    FERROVIARIO("04", "Ferrovia\u0301rio"),
    DUTOVIARIO("05", "Dutovia\u0301rio"),
    MULTIMODAL("06", "Multimodal");

    private final String codigo;
    private final String descricao;

    CTModal(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTModal valueOfCodigo(final String codigo) {
        for (final CTModal tipo : CTModal.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.descricao;
    }
}