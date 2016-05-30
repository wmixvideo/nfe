package com.fincatto.nfe310.classes.nota;

public enum NFFormaImportacaoIntermediacao {

    IMPORTACAO_CONTA_PROPRIA("1", "Importação conta própria"),
    IMPORTACAO_CONTA_ORDEM("2", "Importação conta ordem"),
    IMPORTACAO_ENCOMENDA("3", "Importação encomenda");

    private final String codigo;
    private final String desc;

    NFFormaImportacaoIntermediacao(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}