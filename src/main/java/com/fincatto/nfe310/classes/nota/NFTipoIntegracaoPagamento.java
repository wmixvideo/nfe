package com.fincatto.nfe310.classes.nota;

public enum NFTipoIntegracaoPagamento {

    INTEGRADO("1", "Integrado"),
    SEPARADO("2", "Separado");

    private final String codigo;
    private final String desc;

    NFTipoIntegracaoPagamento(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFTipoIntegracaoPagamento valueOfCodigo(final String codigo) {
        for (final NFTipoIntegracaoPagamento operadora : NFTipoIntegracaoPagamento.values()) {
            if (operadora.getCodigo().equals(codigo)) {
                return operadora;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return codigo+" - "+desc;
    }
}