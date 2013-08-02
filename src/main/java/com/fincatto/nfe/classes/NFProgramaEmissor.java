package com.fincatto.nfe.classes;

public enum NFProgramaEmissor {
	
	CONTRIBUINTE("0", "Aplicativo do contribuinte");
	
	private final String codigo;
	private final String descricao;
	
	private NFProgramaEmissor(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFProgramaEmissor valueOfCodigo(final String codigo) {
		for (NFProgramaEmissor tipo : NFProgramaEmissor.values()) {
			if (tipo.getCodigo().equals(codigo)) {
				return tipo;
			}
		}
		return null;
	}
}