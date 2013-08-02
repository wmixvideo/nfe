package com.fincatto.nfe.classes.nota;

public enum NFNotaInfoItemProdutoVeiculoCondicaoChassi {
	
	NORMAL("N", "Normal"),
	REMARCADO("R", "Remarcado");
	
	private final String codigo;
	private final String descricao;
	
	private NFNotaInfoItemProdutoVeiculoCondicaoChassi(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFNotaInfoItemProdutoVeiculoCondicaoChassi valueOfCodigo(final String codigo) {
		for (NFNotaInfoItemProdutoVeiculoCondicaoChassi tipo : NFNotaInfoItemProdutoVeiculoCondicaoChassi.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}
