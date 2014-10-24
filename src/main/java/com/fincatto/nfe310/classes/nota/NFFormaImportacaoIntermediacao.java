package com.fincatto.nfe310.classes.nota;

public enum NFFormaImportacaoIntermediacao {

    IMPORTACAO_CONTA_PROPRIA("1"),
    IMPORTACAO_CONTA_ORDEM("2"),
    IMPORTACAO_ENCOMENDA("3");

    private String codigo;

    private NFFormaImportacaoIntermediacao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFFormaImportacaoIntermediacao valueOfCodigo(final String codigo) {
        for (final NFFormaImportacaoIntermediacao intermediacao : NFFormaImportacaoIntermediacao.values()) {
            if (intermediacao.getCodigo().equals(codigo)) {
                return intermediacao;
            }
        }
        return null;
    }
}