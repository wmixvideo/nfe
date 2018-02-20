package com.fincatto.documentofiscal.nfe400.classes.lote.envio;

public enum NFLoteIndicadorProcessamento {

    PROCESSAMENTO_ASSINCRONO("0", "Processamento Ass\u00edncrono"),
    PROCESSAMENTO_SINCRONO("1", "Processamento S\u00edncrono");

    private final String codigo;
    private final String descricao;

    NFLoteIndicadorProcessamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
        return codigo + " - " + descricao;
    }
}