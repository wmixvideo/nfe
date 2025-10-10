package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoAgropecuarioTipoGuia {

    GTA("1", "Guia de Tr\u00E2nsito Animal"),
    TTA("2", "Termo de Tr\u00E2nsito Animal"),
    DTA("3", "Documento de Transfer\u00EAncia Animal"),
    ATV("4", "Autoriza\u00E7\u00E3o de Tr\u00E2nsito Vegetal"),
    PTV("5", "Permiss\u00E3o de Tr\u00E2nsito Vegetal"),
    GTV("6", "Guia de Tr\u00E2nsito Vegetal"),
    GUIA_FLORESTAL("7", "Guia Florestal (DOF, SisFlora - PA e MT ou SIAM - MG)");

    private final String codigo;
    private final String descricao;

    NFNotaInfoAgropecuarioTipoGuia(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoAgropecuarioTipoGuia valueOfCodigo(final String codigo) {
        for (final NFNotaInfoAgropecuarioTipoGuia tpGuia : NFNotaInfoAgropecuarioTipoGuia.values()) {
            if (tpGuia.getCodigo().equals(codigo)) {
                return tpGuia;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}