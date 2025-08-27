package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoImpostoTributacaoICMS {

    CST_00("00", "Tributada integralmente"),
    CST_02("02", "Tributação monofásica própria sobre combustíveis"),
    CST_10("10", "Tributada com cobran\u00e7a de ICMS por ST"),
    CST_15("15", "Tributação monofásica própria e com responsabilidade pela retenção sobre combustíveis"),
    CST_20("20", "Com redu\u00e7\u00e3o da base de c\u00e1lculo"),
    CST_30("30", "Isenta ou n\u00e3o tributada com cobran\u00e7a de ICMS por ST"),
    CST_40("40", "Isenta"),
    CST_41("41", "N\u00e3o tributada"),
    CST_50("50", "Suspens\u00e3o"),
    CST_51("51", "Diferimento"),
    CST_53("53", "Tributação monofásica sobre combustíveis com recolhimento diferido"),
    CST_60("60", "ICMS cobrado anteriormente por ST"),
    CST_61("61", "Tributação monofásica sobre combustíveis cobrada anteriormente"),
    CST_70("70", "Com redu\u00e7\u00e3o da base de c\u00e1lculo/Cobran\u00e7a ICMS por ST/ICMS ST"),
    CST_90("90", "Outros");

    private final String codigo;
    private final String descricao;

    NFNotaInfoImpostoTributacaoICMS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }
    
    public String getDescricao() {
        return this.descricao;
    }

    public static NFNotaInfoImpostoTributacaoICMS valueOfCodigo(final String codigoICMS) {
        for (final NFNotaInfoImpostoTributacaoICMS icms : NFNotaInfoImpostoTributacaoICMS.values()) {
            if (icms.getCodigo().equals(codigoICMS)) {
                return icms;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}