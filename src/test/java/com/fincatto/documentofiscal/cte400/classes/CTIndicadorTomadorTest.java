package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTIndicadorTomadorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTIndicadorTomador.valueOfCodigo(null));
    	Assert.assertEquals("1", CTIndicadorTomador.CONTRIBUINTE_ICMS.getCodigo());
    	Assert.assertEquals("2", CTIndicadorTomador.CONTRIBUINTE_ISENTO.getCodigo());
        Assert.assertEquals("9", CTIndicadorTomador.NAO_CONTRIBUINTE.getCodigo());
    }

}
