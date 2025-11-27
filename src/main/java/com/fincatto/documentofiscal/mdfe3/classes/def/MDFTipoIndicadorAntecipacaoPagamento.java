package com.fincatto.documentofiscal.mdfe3.classes.def;

/**
 * @Author FAGNER ROGER
 */
public enum MDFTipoIndicadorAntecipacaoPagamento {

    NAO("0", "N\u00e3o"),
    SIM("1", "Sim");

    private final String codigo;
    private final String descricao;

    MDFTipoIndicadorAntecipacaoPagamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static MDFTipoIndicadorAntecipacaoPagamento valueOfCodigo(final String codigo) {
        for (final MDFTipoIndicadorAntecipacaoPagamento operacao : MDFTipoIndicadorAntecipacaoPagamento.values()) {
            if (operacao.getCodigo().equals(codigo)) {
                return operacao;
            }
        }
        return null;
    }

    public String getCodigo() {
        return this.codigo;
    }

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}
