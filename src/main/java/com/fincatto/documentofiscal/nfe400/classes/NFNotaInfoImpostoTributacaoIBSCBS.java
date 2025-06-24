package com.fincatto.documentofiscal.nfe400.classes;

import java.util.Arrays;

/**
 * Grupo UB. Informacoes dos tributos IBS / CBS e Imposto Seletivo
 * @author Marcos Lombardi
 * @since 4.0.85
 */
public enum NFNotaInfoImpostoTributacaoIBSCBS {

	// Link download tabela https://www.nfe.fazenda.gov.br/portal/exibirArquivo.aspx?conteudo=ix44jDLyQog=
	// CST_cClassTribPublicacao_20250618.xlsx
	
	SITUACOES_TRIBUTADAS_INTEGRALMENTE_PELO_IBS_E_CBS("000", "Tributa\u00e7\u00e3o integral", "000001", "Situa\u00e7\u00f5es tributadas integralmente pelo IBS e CBS"),
	EXPLORACAO_DE_VIA("000", "Tributa\u00e7\u00e3o integral", "000002", "Explora\u00e7\u00e3o de via"),
	REGIME_AUTOMOTIVO_PROJETOS_INCENTIVADOS_ART_311("000", "Tributa\u00e7\u00e3o integral", "000003", "Regime automotivo - projetos incentivados (art. 311)"),
	REGIME_AUTOMOTIVO_PROJETOS_INCENTIVADOS_ART_312("000", "Tributa\u00e7\u00e3o integral", "000004", "Regime automotivo - projetos incentivados (art. 312)"),
	OPERACOES_FGTS_NAO_REALIZADAS_PELA_CAIXA_ECONOMICA_FEDERAL("010", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes - opera\u00e7\u00f5es do FGTS", "010001", "Opera\u00e7\u00f5es do FGTS n\u00e3o realizadas pela Caixa Econ\u00f4mica Federal");

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
