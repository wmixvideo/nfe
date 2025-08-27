package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;


public class CTClasseTarifaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTClasseTarifa.valueOfCodigo(null));
        Assert.assertEquals("M", CTClasseTarifa.MINIMA.getCodigo());
        Assert.assertEquals("G", CTClasseTarifa.GERAL.getCodigo());
        Assert.assertEquals("E", CTClasseTarifa.ESPECIFICA.getCodigo());
    }

}
