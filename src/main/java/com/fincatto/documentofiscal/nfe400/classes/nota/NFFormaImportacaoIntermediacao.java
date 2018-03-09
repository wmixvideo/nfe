package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFFormaImportacaoIntermediacao {

    IMPORTACAO_CONTA_PROPRIA("1", "Importa\u00e7\u00e3o conta pr\u00f3pria"),
    IMPORTACAO_CONTA_ORDEM("2", "Importa\u00e7\u00e3o conta ordem"),
    IMPORTACAO_ENCOMENDA("3", "Importa\u00e7\u00e3o encomenda");

    private final String codigo;
    private final String descricao;

    NFFormaImportacaoIntermediacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}