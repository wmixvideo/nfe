package com.fincatto.documentofiscal.nfe400.classes.nota;

public enum NFIndicadorIntermediador {

	OPERACAO_SEM_INTERMEDIADOR("0", "Opera\u00e7\u00e3o sem intermediador (em site ou plataforma pr\u00f3pria)"),
	OPERACAO_COM_INTERMEDIADOR("1",
			"Opera\u00e7\u00e3o em site ou plataforma de terceiros (intermediadores/marketplace)");

	private final String codigo;
	private final String descricao;

	NFIndicadorIntermediador(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static NFIndicadorIntermediador valueOfCodigo(final String codigo) {
		for (final NFIndicadorIntermediador indicador : NFIndicadorIntermediador.values()) {
			if (indicador.getCodigo().equals(codigo)) {
				return indicador;
			}
		}
		throw new IllegalStateException(String.format("Nao existe o codigo %s", codigo));
	}

	@Override
	public String toString() {
		return this.codigo + " - " + this.descricao;
	}
}
