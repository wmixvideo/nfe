package com.fincatto.documentofiscal.nfe400.classes;

import java.math.BigDecimal;

/**
 * Enum que representa as aliquotas do IBSCBS
 * 
 * @author Marcos Lombardi de Andrade
 */

public enum NFNotaInfoImpostoAliquotaIBSCBS {

	NA(null),
	ZERO(new BigDecimal("0")),
	UM(new BigDecimal("1")),	
	TRINTA(new BigDecimal("30")),
	QUARENTA(new BigDecimal("40")),
	CINQUENTA(new BigDecimal("50")),
	SESSENTA(new BigDecimal("60")),
	SETENTA(new BigDecimal("70")),
	OITENTA(new BigDecimal("80")),
	CEM(new BigDecimal("100"));

	private final BigDecimal tipoDado;

	private NFNotaInfoImpostoAliquotaIBSCBS(final BigDecimal tipoDado) {
		this.tipoDado = tipoDado;
	}

	public BigDecimal getTipoDado() {
		return this.tipoDado;
	}
}
