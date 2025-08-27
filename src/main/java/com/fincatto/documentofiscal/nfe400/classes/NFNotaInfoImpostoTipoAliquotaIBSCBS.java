package com.fincatto.documentofiscal.nfe400.classes;

/**
 * Enum que representa os tipos de aliquota do IBSCBS
 * 
 * @author Marcos Lombardi de Andrade
 */
public enum NFNotaInfoImpostoTipoAliquotaIBSCBS {

	PADRAO("Padrão"),
	FIXA("Fixa"),
	UNIFORME_SETORIAL("Uniforme setorial"),
	UNIFORME_NACIONAL("Uniforme nacional (referência)"),
	SEM_ALIQUOTA("Sem alíquota");

	private final String tipoAliquota;

	private NFNotaInfoImpostoTipoAliquotaIBSCBS(final String tipoAliquota) {
		this.tipoAliquota = tipoAliquota;
	}

	public String getTipoAliquota() {
		return this.tipoAliquota;
	}
	
}
