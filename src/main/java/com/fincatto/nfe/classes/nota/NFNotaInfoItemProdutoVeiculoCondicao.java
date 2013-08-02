package com.fincatto.nfe.classes.nota;

public enum NFNotaInfoItemProdutoVeiculoCondicao {
	
	ACABADO("1", "Acabado"),
	INACABADO("2", "Inacabado"),
	REMARCADO("3", "Semi-acabado");
	
	private final String codigo;
	private final String descricao;
	
	private NFNotaInfoItemProdutoVeiculoCondicao(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFNotaInfoItemProdutoVeiculoCondicao valueOfCodigo(final String codigo) {
		for (NFNotaInfoItemProdutoVeiculoCondicao tipo : NFNotaInfoItemProdutoVeiculoCondicao.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}
