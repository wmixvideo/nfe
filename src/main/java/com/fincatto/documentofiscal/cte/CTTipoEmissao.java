package com.fincatto.documentofiscal.cte;

import java.util.List;

public enum CTTipoEmissao {
    EMISSAO_NORMAL("1", "Normal"),
    CONTINGENCIA_OFFLINE("2", "Contingência Offline"),
    REGIME_ESPECIAL_NFF("3", "Regime Especial NFF"),
    @Deprecated(since = "NT 2026.004 v1.00") CONTINGENCIA_EPEC("4", "EPEC pela SVC"),
    @Deprecated(since = "NT 2026.004 v1.00") CONTINGENCIA_FSDA("5", "Contingência FSDA"),
    CONTINGENCIA_SVCRS("7", "Contingência SVCRS"),
    CONTINGENCIA_SVCSP("8", "Contingência SVCSP");

    private final String codigo;
    private final String descricao;

    CTTipoEmissao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static CTTipoEmissao valueOfCodigo(final String codigo) {
        for (final CTTipoEmissao tipo : CTTipoEmissao.values()) {
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

    public static List<CTTipoEmissao> tiposPermitemSign() {
        return List.of(CONTINGENCIA_EPEC, CONTINGENCIA_OFFLINE);
    }
}