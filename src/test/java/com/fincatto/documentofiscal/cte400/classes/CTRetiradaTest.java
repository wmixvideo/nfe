package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTRetiradaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTRetirada.valueOfCodigo(null));
    	Assert.assertEquals("0", CTRetirada.SIM.getCodigo());
    	Assert.assertEquals("1", CTRetirada.NAO.getCodigo());
    }

}
