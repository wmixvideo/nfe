package com.fincatto.documentofiscal.nfe400.classes;

/**
 * C21a - Tipo de regime de apuração do IBS e da CBS (NT 2026.005).
 */
public enum NFTipoRegimeIBSCBS {

    SIMPLES_NACIONAL_REGIME_REGULAR("1", "Contribuinte do Simples Nacional (CRT=1 ou 2) com opção pelo regime regular do IBS e da CBS"),
    NORMAL_OPCAO_PENDENTE_SIMPLES_NACIONAL("2", "Contribuinte do Regime Normal (CRT=3) com opção pendente pelo CRT=1 sem regime regular do IBS e da CBS"),
    NORMAL_OPCAO_PENDENTE_SIMPLES_NACIONAL_EXCESSO_SUBLIMITE("3", "Contribuinte do Regime Normal (CRT=3) com opção pendente pelo CRT=2 sem regime regular do IBS e da CBS"),
    NORMAL_OPCAO_PENDENTE_SIMPLES_NACIONAL_REGIME_REGULAR("4", "Contribuinte do Regime Normal (CRT=3) com opção pendente pelo Simples Nacional (CRT=1 ou 2) com regime regular do IBS e da CBS");

    private final String codigo;
    private final String descricao;

    NFTipoRegimeIBSCBS(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static NFTipoRegimeIBSCBS valueOfCodigo(final String codigo) {
        for (final NFTipoRegimeIBSCBS valor : NFTipoRegimeIBSCBS.values()) {
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
