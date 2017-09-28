package com.fincatto.dfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class DFModeloTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("55", DFModelo.NFE.getCodigo());
        Assert.assertEquals("65", DFModelo.NFCE.getCodigo());
        Assert.assertEquals("57", DFModelo.CTE.getCodigo());
        Assert.assertEquals("58", DFModelo.MDFE.getCodigo());
    }

    @Test
    public void deveRepresentarADescricaoCorretamente() {
        Assert.assertEquals("NF-e", DFModelo.NFE.getDescricao());
        Assert.assertEquals("NFC-e", DFModelo.NFCE.getDescricao());
        Assert.assertEquals("CT-e", DFModelo.CTE.getDescricao());
        Assert.assertEquals("MDF-e", DFModelo.MDFE.getDescricao());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assert.assertEquals(DFModelo.NFE, DFModelo.valueOfCodigo("55"));
        Assert.assertEquals(DFModelo.NFCE, DFModelo.valueOfCodigo("65"));
        Assert.assertEquals(DFModelo.CTE, DFModelo.valueOfCodigo("57"));
        Assert.assertEquals(DFModelo.MDFE, DFModelo.valueOfCodigo("58"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assert.assertNull(DFModelo.valueOfCodigo("99"));
    }

    @Test
    public void deveObterToStringCorretamente() {
        Assert.assertEquals("55 - NF-e", DFModelo.NFE.toString());
        Assert.assertEquals("65 - NFC-e", DFModelo.NFCE.toString());
        Assert.assertEquals("57 - CT-e", DFModelo.CTE.toString());
        Assert.assertEquals("58 - MDF-e", DFModelo.MDFE.toString());
    }
}