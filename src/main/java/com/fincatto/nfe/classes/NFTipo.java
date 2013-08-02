package com.fincatto.nfe.classes;

public enum NFTipo {
	
	ENTRADA("0", "Entrada"),
	SAIDA("1", "Saida");
	
	private final String codigo;
	private final String descricao;
	
	private NFTipo(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFTipo valueOfCodigo(final String codigo) {
		for (NFTipo tipo : NFTipo.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}