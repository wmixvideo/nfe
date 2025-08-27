package com.fincatto.documentofiscal.cte400.classes;

public enum CTModal {

    RODOVIARIO("01", "Rodoviário"),
    AEREO("02", "Aério"),
    AQUATICO("03", "Aquático"),
    FERROVIARIO("04", "Ferroviário"),
    DUTOVIARIO("05", "Dutoviário"),
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

    public String getDescricao() {
        return this.descricao;
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
        return codigo + " - " + descricao;
    }
}