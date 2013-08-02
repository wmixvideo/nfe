package com.fincatto.nfe.classes;

public enum NFTipoImpressao {
	
	RETRATO("1", "Retrato"),
	PAISAGEM("2", "Paisagem");
	
	private final String codigo;
	private final String descricao;
	
	private NFTipoImpressao(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFTipoImpressao valueOfCodigo(final String codigo) {
		for (NFTipoImpressao tipo : NFTipoImpressao.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}