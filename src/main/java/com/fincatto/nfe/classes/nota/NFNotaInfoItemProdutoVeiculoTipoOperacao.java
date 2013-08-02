package com.fincatto.nfe.classes.nota;

public enum NFNotaInfoItemProdutoVeiculoTipoOperacao {
	
	OUTROS("0", "Outros"),
	VENDA_CONCESSIONARIA("1", "Venda concessionaria"),
	FATURAMENTO_DIRETO_CONSUMIDOR_FINAL("2", "Faturamento direto para consumidor final"),
	FATURAMENTO_DIRETO_GRANDES_CONSUMIDORES("3", "Venda direta para grandes consumidores");
	
	private final String codigo;
	private final String descricao;
	
	private NFNotaInfoItemProdutoVeiculoTipoOperacao(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFNotaInfoItemProdutoVeiculoTipoOperacao valueOfCodigo(final String codigo) {
		for (NFNotaInfoItemProdutoVeiculoTipoOperacao tipo : NFNotaInfoItemProdutoVeiculoTipoOperacao.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}
