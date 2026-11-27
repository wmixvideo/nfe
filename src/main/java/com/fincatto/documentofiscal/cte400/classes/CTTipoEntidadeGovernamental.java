package com.fincatto.documentofiscal.cte400.classes;

public enum CTTipoEntidadeGovernamental {

    UNIAO("1", "União"),
    ESTADOS("2", "Estados"),
    DISTRITO_FEDERAL("3", "Distrito Federal"),
    MUNICIPIOS("4", "Municípios"),
    CONSORCIO_PUBLICO("5", "Consórcio Público"),
    COMITE_GESTOR_IBS("6", "Comitê Gestor do IBS");

    private String codigo;
    private String descricao;

    CTTipoEntidadeGovernamental(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoEntidadeGovernamental valueOfCodigo(final String codigo) {
        for (final CTTipoEntidadeGovernamental tipo : CTTipoEntidadeGovernamental.values()) {
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
