package com.fincatto.documentofiscal.nfe400.classes;

/**
 * Enum que representa os tipos de dados do IBSCBS
 * 
 * @author Marcos Lombardi de Andrade
 */

public enum NFNotaInfoImpostoTipoDadoIBSCBS {

	NA("N/A"),
	ZERO("0"),
	UM("1"),
	TRINTA("30"),
	QUARENTA("40"),
	CINQUENTA("50"),
	SESSENTA("60"),
	SETENTA("70"),
	OITENTA("80"),
	CEM("100");

	private final String tipoDado;

	private NFNotaInfoImpostoTipoDadoIBSCBS(final String tipoDado) {
		this.tipoDado = tipoDado;
	}

	public String getTipoDado() {
		return this.tipoDado;
	}
}
