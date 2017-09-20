package com.fincatto.documentofiscal.nfe310.classes.nota;

public enum NFOperacaoConsumidorFinal {

    NAO("0", "N\u00e3o"),
    SIM("1", "Sim");

    private final String codigo;
    private final String descricao;

    NFOperacaoConsumidorFinal(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static NFOperacaoConsumidorFinal valueOfCodigo(final String codigo) {
        for (final NFOperacaoConsumidorFinal operacao : NFOperacaoConsumidorFinal.values()) {
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