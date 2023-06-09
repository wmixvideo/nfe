package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoDirecaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTTipoDirecao.valueOfCodigo(null));
    	Assert.assertEquals("N", CTTipoDirecao.NORTE.getCodigo());
    	Assert.assertEquals("L", CTTipoDirecao.LESTE.getCodigo());
    	Assert.assertEquals("S", CTTipoDirecao.SUL.getCodigo());
    	Assert.assertEquals("O", CTTipoDirecao.OESTE.getCodigo());
    }

}
