package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemProdutoVeiculoRestricao {

    NAO_HA("0"),
    ALIENACAO_FIDUCIARIA("1"),
    ARRENDAMENTO_MERCANTIL("2"),
    RESERVA_DOMINIO("3"),
    PENHOR("4"),
    OUTRAS("9");

    private final String codigo;

    private NFNotaInfoItemProdutoVeiculoRestricao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public static NFNotaInfoItemProdutoVeiculoRestricao valueOfCodigo(final String codigo) {
        for (final NFNotaInfoItemProdutoVeiculoRestricao tipo : NFNotaInfoItemProdutoVeiculoRestricao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}