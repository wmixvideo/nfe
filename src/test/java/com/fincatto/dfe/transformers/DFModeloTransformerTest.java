package com.fincatto.dfe.transformers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFModelo;

public class DFModeloTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNull(new DFModeloTransformer().read(null));
        Assert.assertEquals(DFModelo.NFE, new DFModeloTransformer().read("55"));
        Assert.assertEquals(DFModelo.NFCE, new DFModeloTransformer().read("65"));
        Assert.assertEquals(DFModelo.CTE, new DFModeloTransformer().read("57"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assert.assertEquals("55", new DFModeloTransformer().write(DFModelo.NFE));
        Assert.assertEquals("65", new DFModeloTransformer().write(DFModelo.NFCE));
        Assert.assertEquals("57", new DFModeloTransformer().write(DFModelo.CTE));
    }
}