package com.fincatto.documentofiscal.nfe400.classes;

/**
 * Enum que representa os tipos de aliquota do IBSCBS
 * 
 * @author Marcos Lombardi de Andrade
 */
public enum NFNotaInfoImpostoTipoAliquotaIBSCBS {

	PADRAO("Padr\u00e3o"),
	FIXA("Fixa"),
	UNIFORME_SETORIAL("Uniforme setorial"),
	UNIFORME_NACIONAL("Uniforme nacional (refer\u00eancia)"),
	SEM_ALIQUOTA("Sem al\u00edquota");

	private final String tipoAliquota;

	private NFNotaInfoImpostoTipoAliquotaIBSCBS(final String tipoAliquota) {
		this.tipoAliquota = tipoAliquota;
	}

	public String getTipoAliquota() {
		return this.tipoAliquota;
	}
	
}
