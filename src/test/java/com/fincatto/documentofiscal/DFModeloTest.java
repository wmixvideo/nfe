package com.fincatto.documentofiscal;

import org.junit.Assert;
import org.junit.Test;

public class DFModeloTest {

	@Test
	public void deveRepresentarOCodigoCorretamente() {
		Assert.assertEquals("01", DFModelo.AVULSA.getCodigo());
		Assert.assertEquals("04", DFModelo.PRODUTOR.getCodigo());
		Assert.assertEquals("55", DFModelo.NFE.getCodigo());
		Assert.assertEquals("65", DFModelo.NFCE.getCodigo());
		Assert.assertEquals("57", DFModelo.CTE.getCodigo());
		Assert.assertEquals("67", DFModelo.CTeOS.getCodigo());
	}
	
    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("01 - Nota avulsa", DFModelo.AVULSA.toString());
        Assert.assertEquals("04 - Nota produtor", DFModelo.PRODUTOR.toString());
        Assert.assertEquals("55 - NF-e", DFModelo.NFE.toString());
        Assert.assertEquals("65 - NFC-e", DFModelo.NFCE.toString());
        Assert.assertEquals("57 - CT-e", DFModelo.CTE.toString());
        Assert.assertEquals("67 - CT-e OS", DFModelo.CTeOS.toString());
    }

}
