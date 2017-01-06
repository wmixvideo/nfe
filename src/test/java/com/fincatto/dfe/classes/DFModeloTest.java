package com.fincatto.dfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class DFModeloTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("55", DFModelo.NFE.getCodigo());
        Assert.assertEquals("65", DFModelo.NFCE.getCodigo());
        Assert.assertEquals("57", DFModelo.CTE.getCodigo());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assert.assertEquals(DFModelo.NFE, DFModelo.valueOfCodigo("55"));
        Assert.assertEquals(DFModelo.NFCE, DFModelo.valueOfCodigo("65"));
        Assert.assertEquals(DFModelo.CTE, DFModelo.valueOfCodigo("57"));
    }
}