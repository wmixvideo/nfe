package com.fincatto.documentofiscal.cte300.classes;

import org.junit.Assert;
import org.junit.Test;


public class CTClasseTarifaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTClasseTarifa.valueOfCodigo(null));
    	Assert.assertEquals("M", CTClasseTarifa.Tarifa_Minima.getCodigo());
		Assert.assertEquals("G", CTClasseTarifa.Tarifa_Geral.getCodigo());
		Assert.assertEquals("E", CTClasseTarifa.Tarifa_Específica.getCodigo());
    }

}
