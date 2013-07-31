package com.fincatto.nfe;

public enum Ambiente {
	
	PRODUCAO("1"), HOMOLOGACAO("2");
	
	private final String codigo;
	
	private Ambiente(final String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public static Ambiente valueOfCodigo(final String codigo) {
		for (Ambiente ambiente : Ambiente.values()) {
			if (ambiente.getCodigo().equalsIgnoreCase(codigo)) {
				return ambiente;
			}
		}
		return null;
	}
}
