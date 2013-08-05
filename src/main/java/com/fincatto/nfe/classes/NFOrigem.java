package com.fincatto.nfe.classes;

public enum NFOrigem {
	
	NACIONAL("0", "Nacional"),
	ESTRANGEIRA_IMPORTACAO_DIRETA("1", "Estrangeira com importacao direta"),
	ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO("2", "Estrangeira adquirida no mercado interno");
	
	private final String codigo;
	private final String descricao;
	
	private NFOrigem(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFOrigem valueOfCodigo(final String codigo) {
		for (NFOrigem origem : NFOrigem.values()) {
			if (origem.getCodigo().equals(codigo)) {
				return origem;
			}
		}
		return null;
	}
}
