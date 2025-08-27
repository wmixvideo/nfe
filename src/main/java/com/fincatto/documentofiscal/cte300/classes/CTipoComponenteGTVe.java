package com.fincatto.documentofiscal.cte300.classes;

public enum CTipoComponenteGTVe {
    CUSTODIA("1", "Custodia"),
    EMBARQUE("2", "Embarque"),
    TEMPO_DE_ESPERA("3", "Tempo de espera"),
    MALOTE("4", "Malote"),
    AD_VALOREM("5", "Ad Valorem"),
    OUTROS("6", "Outros");

    private final String codigo;
    private final String descricao;

    CTipoComponenteGTVe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTipoComponenteGTVe valueOfCodigo(final String codigo) {
        for (final CTipoComponenteGTVe valor : CTipoComponenteGTVe.values()) {
            if (valor.getCodigo().equals(codigo)) {
                return valor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
