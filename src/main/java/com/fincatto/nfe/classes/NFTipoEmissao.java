package com.fincatto.nfe.classes;

public enum NFTipoEmissao {
	
	NORMAL("1", "Normal"),
	CONTINGENCIA_FS("2", "Conting\u00eancia FS"),
	CONTINGENCIA_SCAN("3", "Conting\u00eancia SCAN"),
	CONTINGENCIA_DPEC("4", "Conting\u00eancia DPEC"),
	CONTINGENCIA_FSDA("5", "Conting\u00eancia FSDA");
	
	private final String codigo;
	private final String descricao;
	
	private NFTipoEmissao(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFTipoEmissao valueOfCodigo(final String codigo) {
		for (NFTipoEmissao tipo : NFTipoEmissao.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}