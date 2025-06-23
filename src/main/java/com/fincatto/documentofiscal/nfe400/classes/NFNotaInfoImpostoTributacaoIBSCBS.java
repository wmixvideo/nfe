package com.fincatto.documentofiscal.nfe400.classes;

import java.util.Arrays;

public enum NFNotaInfoImpostoTributacaoIBSCBS {

	TRIBUTACAO_INTEGRAL("000", "Tributa\u00e7\u00e3o integral"),
	TRIBUTACAO_COM_ALIQUOTAS_UNIFORMES_OPERACOES_SETOR_FINANCEIRO("010", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes – opera\u00e7\u00f5es setor financeiro"),
	TRIBUTACAO_COM_ALIQUOTAS_UNIFORMES_REDUZIDAS_EM_60("011", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes reduzidas em 60%"),
	TRIBUTACAO_COM_ALIQUOTAS_UNIFORMES_REDUZIDAS_EM_30("011", "Tributa\u00e7\u00e3o com al\u00edquotas uniformes reduzidas em 30%"),
	ALIQUOTA_ZERO("200", "Al\u00edquota zero"),
	ALIQUOTA_ZERO_APENAS_CBS_E_REDUZIDA_EM_60_PARA_IBS("200", "Al\u00edquota zero apenas CBS e reduzida em 60% para IBS"),
	ALIQUOTA_REDUZIDA_EM_80("200", "Al\u00edquota reduzida em 80%"),
	ALIQUOTA_REDUZIDA_EM_70("200", "Al\u00edquota reduzida em 70%"),
	ALIQUOTA_REDUZIDA_EM_60("200", "Al\u00edquota reduzida em 60%"),
	ALIQUOTA_REDUZIDA_EM_50("200", "Al\u00edquota reduzida em 50%"),
	ALIQUOTA_REDUZIDA_EM_40("200", "Al\u00edquota reduzida em 40%"),
	ALIQUOTA_REDUZIDA_EM_30("200", "Al\u00edquota reduzida em 30%"),
	ALIQUOTA_REDUZIDA_EM_50_COM_REDUTOR_DE_BASE_DE_CALCULO("210", "Al\u00edquota reduzida em 50% com redutor de base de c\u00e1lculo"),
	ALIQUOTA_REDUZIDA_EM_70_COM_REDUTOR_DE_BASE_DE_CALCULO("210", "Al\u00edquota reduzida em 70% com redutor de base de c\u00e1lculo"),
	ALIQUOTA_FIXA("220", "Al\u00edquota fixa"), 
	ALIQUOTA_FIXA_PROPORCIONAL("221", "Al\u00edquota fixa proporcional"),
	REDUCAO_DE_BASE_DE_CALCULO("222", "Redu\u00e7\u00e3o de base de c\u00e1lculo"), 
	ISENCAO("400", "Isen\u00e7\u00e3o"),
	IMUNIDADE_E_NAO_INCIDENCIA("410", "Imunidade e n\u00e3o incid\u00eancia"), 
	DIFERIMENTO("510", "Diferimento"),
	SUSPENSAO("550", "Suspens\u00e3o"), 
	TRIBUTACAO_MONOFASICA("620", "Tributa\u00e7\u00e3o monof\u00e1sica"),
	TRANSFERENCIA_DE_CREDITO("800", "Transfer\u00eancia de cr\u00e9dito"), 
	AJUSTES("810", "Ajustes"),
	TRIBUTACAO_EM_DECLARACAO_DE_REGIME_ESPECIFICO("820", "Tributa\u00e7\u00e3o em declara\u00e7\u00e3o de regime espec\u00edfico"),
	EXCLUSAO_DE_BASE_DE_CALCULO("830", "Exclus\u00e3o de base de c\u00e1lculo");

	private final String codigo;
	private final String descricao;

	NFNotaInfoImpostoTributacaoIBSCBS(final String codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static NFNotaInfoImpostoTributacaoIBSCBS valueOfCodigo(final String codigoIBSCBS) {
		return Arrays.stream(NFNotaInfoImpostoTributacaoIBSCBS.values())
					.filter(ibscbs -> ibscbs.getCodigo().equals(codigoIBSCBS))
						.findFirst().orElse(null);
	}

	@Override
	public String toString() {
		return codigo + " - " + descricao;
	}
}
