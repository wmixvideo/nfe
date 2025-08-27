package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTFinalidadeTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTFinalidade.valueOfCodigo(null));
    	Assert.assertEquals("0", CTFinalidade.NORMAL.getCodigo());
    	Assert.assertEquals("1", CTFinalidade.COMPLEMENTAR.getCodigo());
    	Assert.assertEquals("3", CTFinalidade.SUBSTITUTO.getCodigo());
    }

}
