package com.fincatto.documentofiscal.transformers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFModelo;

public class DFModeloTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
    	Assert.assertNull(new DFModeloTransformer().read(null));
    	Assert.assertEquals(DFModelo.AVULSA, new DFModeloTransformer().read("01"));
    	Assert.assertEquals(DFModelo.PRODUTOR, new DFModeloTransformer().read("04"));
    	Assert.assertEquals(DFModelo.NFE, new DFModeloTransformer().read("55"));
    	Assert.assertEquals(DFModelo.NFCE, new DFModeloTransformer().read("65"));
    	Assert.assertEquals(DFModelo.CTE, new DFModeloTransformer().read("57"));
    	Assert.assertEquals(DFModelo.CTeOS, new DFModeloTransformer().read("67"));
    }
    
    @Test
    public void deveTestarEscrita() throws Exception {
    	Assert.assertEquals("01", new DFModeloTransformer().write(DFModelo.AVULSA));
    	Assert.assertEquals("04", new DFModeloTransformer().write(DFModelo.PRODUTOR));
    	Assert.assertEquals("55", new DFModeloTransformer().write(DFModelo.NFE));
    	Assert.assertEquals("65", new DFModeloTransformer().write(DFModelo.NFCE));
    	Assert.assertEquals("57", new DFModeloTransformer().write(DFModelo.CTE));
    	Assert.assertEquals("67", new DFModeloTransformer().write(DFModelo.CTeOS));
    }

}
