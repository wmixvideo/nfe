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
    public void deveRepresentarADescricaoCorretamente() {
        Assert.assertEquals("NF-e", DFModelo.NFE.getDescricao());
        Assert.assertEquals("NFC-e", DFModelo.NFCE.getDescricao());
        Assert.assertEquals("CT-e", DFModelo.CTE.getDescricao());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assert.assertEquals(DFModelo.NFE, DFModelo.valueOfCodigo("55"));
        Assert.assertEquals(DFModelo.NFCE, DFModelo.valueOfCodigo("65"));
        Assert.assertEquals(DFModelo.CTE, DFModelo.valueOfCodigo("57"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assert.assertNull(DFModelo.valueOfCodigo("58"));
    }

    @Test
    public void deveObterToStringCorretamente() {
        Assert.assertEquals("55 - NF-e", DFModelo.NFE.toString());
        Assert.assertEquals("65 - NFC-e", DFModelo.NFCE.toString());
        Assert.assertEquals("57 - CT-e", DFModelo.CTE.toString());
    }
}