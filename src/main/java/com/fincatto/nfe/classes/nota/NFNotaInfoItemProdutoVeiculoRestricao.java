package com.fincatto.nfe.classes.nota;

public enum NFNotaInfoItemProdutoVeiculoRestricao {
	
	NAO_HA("0", "Na\u0303o ha\u0301"),
	ALIENACAO_FIDUCIARIA("1", "Alienac\u0327a\u0303o fiducia\u0301ria"),
	ARRENDAMENTO_MERCANTIL("2", "Arrendamento mercantil"),
	RESERVA_DOMINIO("3", "Reserva de domi\u0301nio"),
	PENHOR("4", "Penhor"),
	OUTRAS("9", "Outras");
	
	private final String codigo;
	private final String descricao;
	
	private NFNotaInfoItemProdutoVeiculoRestricao(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFNotaInfoItemProdutoVeiculoRestricao valueOfCodigo(final String codigo) {
		for (NFNotaInfoItemProdutoVeiculoRestricao tipo : NFNotaInfoItemProdutoVeiculoRestricao.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}
