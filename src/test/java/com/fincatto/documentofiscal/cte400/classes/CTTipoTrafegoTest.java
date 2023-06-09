package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoTrafegoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoTrafego.valueOfCodigo(null));
    	Assert.assertEquals("0", CTTipoTrafego.PROPRIO.getCodigo());
    	Assert.assertEquals("1", CTTipoTrafego.MUTUO.getCodigo());
    	Assert.assertEquals("2", CTTipoTrafego.RODOFERROVIARIO.getCodigo());
    	Assert.assertEquals("3", CTTipoTrafego.RODOVIARIO.getCodigo());
	}

}
