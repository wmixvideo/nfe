package com.fincatto.nfe310.classes;

public enum NFNotaInfoImpostoTributacaoISSQN {
    NORMAL("N"),
    RETIDA("R"),
    SUBSTITUTA("S"),
    ISENTA("I");

    private String codigo;

    private NFNotaInfoImpostoTributacaoISSQN(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoImpostoTributacaoISSQN valueOfCodigo(final String codigo) {
        for (final NFNotaInfoImpostoTributacaoISSQN impostoTributacaoISSQN : NFNotaInfoImpostoTributacaoISSQN.values()) {
            if (impostoTributacaoISSQN.getCodigo().equals(codigo)) {
                return impostoTributacaoISSQN;
            }
        }
        return null;
    }
}