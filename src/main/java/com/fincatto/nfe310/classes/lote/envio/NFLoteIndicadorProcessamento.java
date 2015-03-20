package com.fincatto.nfe310.classes.lote.envio;

public enum NFLoteIndicadorProcessamento {

    PROCESSAMENTO_ASSINCRONO("0"),
    PROCESSAMENTO_SINCRONO("1");

    private String codigo;

    private NFLoteIndicadorProcessamento(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFLoteIndicadorProcessamento valueOfCodigo(final String codigo) {
        for (final NFLoteIndicadorProcessamento indicadorProcessamento : NFLoteIndicadorProcessamento.values()) {
            if (indicadorProcessamento.getCodigo().equals(codigo)) {
                return indicadorProcessamento;
            }
        }
        return null;
    }
}