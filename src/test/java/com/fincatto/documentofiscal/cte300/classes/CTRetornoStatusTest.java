package com.fincatto.documentofiscal.cte300.classes;

import org.junit.Assert;
import org.junit.Test;

/*
 * Created by Eldevan Nery Junior on 22/07/2022 13:46
 */
public class CTRetornoStatusTest {

    @Test
    public void valueOfCodigoStringTest() {
        Assert.assertEquals(CTRetornoStatus.CODIGO_100, CTRetornoStatus.valueOfCodigo("100"));
    }

    @Test
    public void valueOfCodigoIntegerTest() {
        Assert.assertEquals(CTRetornoStatus.CODIGO_100, CTRetornoStatus.valueOfCodigo(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfCodigoNaoMapeadoTest() {
        Assert.assertNull(CTRetornoStatus.valueOfCodigo(900));
    }

    @Test
    public void isAutorizadoTest() {
        Assert.assertTrue(CTRetornoStatus.CODIGO_100.isAutorizado());
    }

    @Test
    public void isDenegadoTest() {
        Assert.assertTrue(CTRetornoStatus.CODIGO_110.isDenegado());
        Assert.assertTrue(CTRetornoStatus.CODIGO_301.isDenegado());
        Assert.assertTrue(CTRetornoStatus.CODIGO_302.isDenegado());
        Assert.assertTrue(CTRetornoStatus.CODIGO_303.isDenegado());
        Assert.assertTrue(CTRetornoStatus.CODIGO_304.isDenegado());
        Assert.assertTrue(CTRetornoStatus.CODIGO_305.isDenegado());
        Assert.assertTrue(CTRetornoStatus.CODIGO_306.isDenegado());
        Assert.assertFalse(CTRetornoStatus.CODIGO_100.isDenegado());
    }

    @Test
    public void isRejeitadoTest() {
        Assert.assertTrue(CTRetornoStatus.CODIGO_230.isRejeitado());
        Assert.assertFalse(CTRetornoStatus.CODIGO_100.isRejeitado());
    }

    @Test
    public void isDuplicadoTest() {
        Assert.assertTrue(CTRetornoStatus.CODIGO_539.isDuplicado());
        Assert.assertFalse(CTRetornoStatus.CODIGO_100.isDuplicado());
    }

}