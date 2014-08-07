package com.fincatto.nfe.classes;

public enum NFNotaInfoItemProdutoArmamentoTipo {
	
	PERMITIDO("0", "Uso permitido"),
	RESTRITO("1", "Uso restrito");
	
	private final String codigo;
	private final String descricao;
	
	private NFNotaInfoItemProdutoArmamentoTipo(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFNotaInfoItemProdutoArmamentoTipo valueOfCodigo(final String codigo) {
		for (NFNotaInfoItemProdutoArmamentoTipo tipo : NFNotaInfoItemProdutoArmamentoTipo.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}
