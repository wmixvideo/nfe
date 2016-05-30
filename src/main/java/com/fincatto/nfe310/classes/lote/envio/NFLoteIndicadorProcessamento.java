package com.fincatto.nfe310.classes.lote.envio;

public enum NFLoteIndicadorProcessamento {

    PROCESSAMENTO_ASSINCRONO("0", "Processamento Assíncrono"),
    PROCESSAMENTO_SINCRONO("1", "Processamento Síncrono");

    private final String codigo;
    private final String desc;

    NFLoteIndicadorProcessamento(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}