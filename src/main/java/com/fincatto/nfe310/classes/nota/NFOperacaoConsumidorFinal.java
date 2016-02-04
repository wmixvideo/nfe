package com.fincatto.nfe310.classes.nota;

public enum NFOperacaoConsumidorFinal {
    NAO("0"),
    SIM("1");

    private String codigo;

    private NFOperacaoConsumidorFinal(final String codigo) {
        this.codigo = codigo;
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
}