package com.fincatto.nfe310.classes;

public enum NFNotaInfoItemProdutoVeiculoRestricao {

    NAO_HA("0", "Não há"),
    ALIENACAO_FIDUCIARIA("1", "Alienação fiduciária"),
    ARRENDAMENTO_MERCANTIL("2", "Arrendamento mercantil"),
    RESERVA_DOMINIO("3", "Reserva domínio"),
    PENHOR("4", "Penhor"),
    OUTRAS("9", "Outras");

    private final String codigo;
    private final String desc;

    NFNotaInfoItemProdutoVeiculoRestricao(final String codigo, final String desc) {
        this.codigo = codigo;
        this.desc = desc;
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
    	return codigo+" - "+desc;
    }
}