package com.fincatto.nfe.classes.nota;

public enum NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria {
	
	PRECO_TABELADO("0", "Preco tabelado ou maximo sugerido"),
	LISTA_NEGATIVA("1", "Lista negativa"),
	LISTA_POSITIVA("2", "Lista positiva"),
	LISTA_NEUTRA("3", "Lista neutra"),
	MVA("4", "Margem de valor agregado"),
	PAUTA("5", "Pauta");
	
	private final String codigo;
	private final String descricao;
	
	private NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria valueOfCodigo(final String codigo) {
		for (NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria modalidade : NFNotaInfoItemImpostoICMSModalidadeBaseCaluloSubstituicaoTributaria.values()) {
			if (modalidade.getCodigo().equals(codigo)) {
				return modalidade;
			}
		}
		return null;
	}
}
