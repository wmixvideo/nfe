package com.fincatto.nfe310.classes.nota;

public enum NFOperacaoConsumidorFinal {
    NAO("0", "Não"),
    SIM("1", "Sim");

    private final String codigo;
    private final String desc;

    NFOperacaoConsumidorFinal(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}