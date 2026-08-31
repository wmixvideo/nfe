package com.fincatto.documentofiscal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFModeloTest {

	@Test
	public void deveRepresentarOCodigoCorretamente() {
		Assertions.assertEquals("01", DFModelo.AVULSA.getCodigo());
		Assertions.assertEquals("04", DFModelo.PRODUTOR.getCodigo());
		Assertions.assertEquals("55", DFModelo.NFE.getCodigo());
		Assertions.assertEquals("65", DFModelo.NFCE.getCodigo());
		Assertions.assertEquals("57", DFModelo.CTE.getCodigo());
		Assertions.assertEquals("58", DFModelo.MDFE.getCodigo());
		Assertions.assertEquals("67", DFModelo.CTeOS.getCodigo());
	}
	
    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("01 - Nota avulsa", DFModelo.AVULSA.toString());
        Assertions.assertEquals("04 - Nota produtor", DFModelo.PRODUTOR.toString());
        Assertions.assertEquals("55 - NF-e", DFModelo.NFE.toString());
        Assertions.assertEquals("65 - NFC-e", DFModelo.NFCE.toString());
        Assertions.assertEquals("57 - CT-e", DFModelo.CTE.toString());
        Assertions.assertEquals("58 - MDF-e", DFModelo.MDFE.toString());
        Assertions.assertEquals("67 - CT-e OS", DFModelo.CTeOS.toString());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assertions.assertEquals(DFModelo.AVULSA, DFModelo.valueOfCodigo("01"));
        Assertions.assertEquals(DFModelo.PRODUTOR, DFModelo.valueOfCodigo("04"));
        Assertions.assertEquals(DFModelo.NFE, DFModelo.valueOfCodigo("55"));
        Assertions.assertEquals(DFModelo.NFCE, DFModelo.valueOfCodigo("65"));
        Assertions.assertEquals(DFModelo.CTE, DFModelo.valueOfCodigo("57"));
        Assertions.assertEquals(DFModelo.MDFE, DFModelo.valueOfCodigo("58"));
        Assertions.assertEquals(DFModelo.CTeOS, DFModelo.valueOfCodigo("67"));
    }
}
