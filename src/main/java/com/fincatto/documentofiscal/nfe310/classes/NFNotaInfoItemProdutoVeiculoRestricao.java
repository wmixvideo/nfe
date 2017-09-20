package com.fincatto.documentofiscal.nfe310.classes;

public enum NFNotaInfoItemProdutoVeiculoRestricao {

    NAO_HA("0", "N\u00e3o h\u00e1"),
    ALIENACAO_FIDUCIARIA("1", "Aliena\u00e7\u00e3o fiduci\u00e1ria"),
    ARRENDAMENTO_MERCANTIL("2", "Arrendamento mercantil"),
    RESERVA_DOMINIO("3", "Reserva dom\u00ednio"),
    PENHOR("4", "Penhor"),
    OUTRAS("9", "Outras");

    private final String codigo;
    private final String descricao;

    NFNotaInfoItemProdutoVeiculoRestricao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
}