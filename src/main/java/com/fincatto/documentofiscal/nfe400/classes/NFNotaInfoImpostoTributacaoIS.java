package com.fincatto.documentofiscal.nfe400.classes;

public enum NFNotaInfoImpostoTributacaoIS {

    CST_000("000", "Tributa\u00e7\u00e3o integral"),
    CST_010("010", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes - opera\u00e7\u00f5es setor financeiro"),
    CST_011_REDUZIDA_60("011", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes reduzidas em 60%"),
    CST_011_REDUZIDA_30("011", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes reduzidas em 30%"),
    CST_200_ALIQUOTA_ZERO("200", "Al\u00edquota zero"),
    CST_200_ALIQUOTA_ZERO_CBS_REDUZIDA_IBS("200", "Al\u00edquota zero apenas CBS e reduzida em 60% para IBS"),
    CST_200_REDUZIDA_80("200", "Al\u00edquota reduzida em 80%"),
    CST_200_REDUZIDA_70("200", "Al\u00edquota reduzida em 70%"),
    CST_200_REDUZIDA_60("200", "Al\u00edquota reduzida em 60%"),
    CST_200_REDUZIDA_50("200", "Al\u00edquota reduzida em 50%"),
    CST_200_REDUZIDA_40("200", "Al\u00edquota reduzida em 40%"),
    CST_200_REDUZIDA_30("200", "Al\u00edquota reduzida em 30%"),
    CST_210_REDUZIDA_50_REDUCAO_BASE("210", "Al\u00edquota reduzida em 50% com redutor de base de c\u00e1lculo"),
    CST_210_REDUZIDA_70_REDUCAO_BASE("210", "Al\u00edquota reduzida em 70% com redutor de base de c\u00e1lculo"),
    CST_220("220", "Al\u00edquota fixa"),
    CST_221("221", "Al\u00edquota fixa proporcional"),
    CST_222("222", "Redu\u00e7\u00e3o de base de c\u00e1lculo"),
    CST_400("400", "Isen\u00e7\u00e3o"),
    CST_410("410", "Imunidade e n\u00e3o incid\u00eancia"),
    CST_510("510", "Diferimento"),
    CST_550("550", "Suspens\u00e3o"),
    CST_620("620", "Tributa\u00e7\u00e3o monof\u00e1sica"),
    CST_800("800", "Transfer\u00eancia de cr\u00e9dito"),
    CST_810("810", "Ajustes"),
    CST_820("820", "Tributa\u00e7\u00e3o em declara\u00e7\u00e3o de regime espec\u00edfico"),
    CST_830("830", "Exclus\u00e3o de base de c\u00e1lculo");

    private final String codigo;
    private final String descricao;

    NFNotaInfoImpostoTributacaoIS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFNotaInfoImpostoTributacaoIS valueOfCodigo(final String codigoISS) {
        for (final NFNotaInfoImpostoTributacaoIS iss : NFNotaInfoImpostoTributacaoIS.values()) {
            if (iss.getCodigo().equals(codigoISS)) {
                return iss;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}