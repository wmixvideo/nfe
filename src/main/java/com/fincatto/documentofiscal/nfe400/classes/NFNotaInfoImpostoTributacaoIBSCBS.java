package com.fincatto.documentofiscal.nfe400.classes;

import java.util.Arrays;

public enum NFNotaInfoImpostoTributacaoIBSCBS {

	// Link download tabela https://www.nfe.fazenda.gov.br/portal/exibirArquivo.aspx?conteudo=ix44jDLyQog=
	// CST_cClassTribPublicacao_20250618.xlsx
	
	SITUACOES_TRIBUTADAS_INTEGRALMENTE_PELO_IBS_E_CBS("000", "Tributa\u00e7\u00e3o integral", "000001", "Situações tributadas integralmente pelo IBS e CBS"),
	EXPLORACAO_DE_VIA("000", "Tributa\u00e7\u00e3o integral", "000002", "Exploração de via"),
	REGIME_AUTOMOTIVO_PROJETOS_INCENTIVADOS_ART_311("000", "Tributa\u00e7\u00e3o integral", "000003", "Regime automotivo - projetos incentivados (art. 311)"),
	REGIME_AUTOMOTIVO_PROJETOS_INCENTIVADOS_ART_312("000", "Tributa\u00e7\u00e3o integral", "000004", "Regime automotivo - projetos incentivados (art. 312)"),
	TRIBUTACAO_COM_ALIQUOTAS_UNIFORMES_OPERACOES_FGTS("010", "Tributa\u00e7\u00e3o integral", "010001", "Tributação com alíquotas uniformes - operações do FGTS");

	private NFNotaInfoImpostoTributacaoIBSCBS(String cCstIBSCBS, String xCstIBSCBS, String cClassTrib, String xClassTrib) {
		this.cCstIBSCBS = cCstIBSCBS;
		this.xCstIBSCBS = xCstIBSCBS;
		this.cClassTrib = cClassTrib;
		this.xClassTrib = xClassTrib;
	}

	public static NFNotaInfoImpostoTributacaoIBSCBS valueOfCodigo(final String cClassTrib) {
		return Arrays.stream(NFNotaInfoImpostoTributacaoIBSCBS.values())
					.filter(ibscbs -> ibscbs.getcClassTrib().equals(cClassTrib))
						.findFirst().orElse(null);
	}
	
	// Coluna A
	private final String cCstIBSCBS;
	// Coluna B
	private final String xCstIBSCBS;
	// Coluna C
	private final String cClassTrib;
	// Coluna D
	private final String xClassTrib;

	public String getcCstIBSCBS() {
		return cCstIBSCBS;
	}

	public String getxCstIBSCBS() {
		return xCstIBSCBS;
	}

	public String getcClassTrib() {
		return cClassTrib;
	}

	public String getxClassTrib() {
		return xClassTrib;
	}

	@Override
	public String toString() {
		return cClassTrib + " - " + xClassTrib;
	}
	
}
