package com.fincatto.nfe310.classes;

public enum NFFormaPagamentoPrazo {
	
	A_VISTA("0", "A vista"),
	A_PRAZO("1", "A prazo"),
	OUTROS("2", "Outros");
	
	private final String codigo;
	private final String descricao;
	
	private NFFormaPagamentoPrazo(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFFormaPagamentoPrazo valueOfCodigo(final String codigo) {
		for (NFFormaPagamentoPrazo formaPagamento : NFFormaPagamentoPrazo.values()) {
			if (formaPagamento.getCodigo().equals(codigo)) {
				return formaPagamento;
			}
		}
		return null;
	}
}