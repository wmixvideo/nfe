package com.fincatto.documentofiscal.cte200.classes;

import java.util.Arrays;
import java.util.List;

public enum CTTipoEntregaData {

    SEM_DATA("0", "Sem data definida"),
    NA_DATA("1", "Na data"),
    ATE_DATA("2", "Ate\u0301 a data"),
    A_PARTIR_DATA("3", "A partir da data"),
    NO_PERIODO("4", "No per\u00edodo");

    public static final List<CTTipoEntregaData> COM_DATA = Arrays.asList(CTTipoEntregaData.NA_DATA, CTTipoEntregaData.ATE_DATA, CTTipoEntregaData.A_PARTIR_DATA);

    private final String codigo;
    private final String descricao;

    CTTipoEntregaData(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static CTTipoEntregaData valueOfCodigo(final String codigo) {
        for (final CTTipoEntregaData tipo : CTTipoEntregaData.values()) {
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