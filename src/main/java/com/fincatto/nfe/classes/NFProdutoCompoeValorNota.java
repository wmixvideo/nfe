package com.fincatto.nfe.classes;

public enum NFProdutoCompoeValorNota {
	
	NAO("0", "N\u00e3o"),
	SIM("1", "Sim");
	
	private final String codigo;
	private final String descricao;
	
	private NFProdutoCompoeValorNota(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFProdutoCompoeValorNota valueOfCodigo(final String codigo) {
		for (NFProdutoCompoeValorNota produtoCompoeValorNota : NFProdutoCompoeValorNota.values()) {
			if (produtoCompoeValorNota.getCodigo().equals(codigo)) {
				return produtoCompoeValorNota;
			}
		}
		return null;
	}
}