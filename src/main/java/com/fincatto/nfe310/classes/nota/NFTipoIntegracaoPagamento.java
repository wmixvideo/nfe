package com.fincatto.nfe310.classes.nota;

public enum NFTipoIntegracaoPagamento {

    INTEGRADO("1"),
    SEPARADO("2");

    private String codigo;

    NFTipoIntegracaoPagamento(final String codigo) {
        this.codigo = codigo;
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
}