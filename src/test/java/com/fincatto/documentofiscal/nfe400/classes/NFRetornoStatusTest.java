package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFRetornoStatusTest {

    @Test
    public void valueOfCodigoStringTest() {
        Assert.assertEquals(NFRetornoStatus.CODIGO_100, NFRetornoStatus.valueOfCodigo("100"));
    }

    @Test
    public void valueOfCodigoIntegerTest() {
        Assert.assertEquals(NFRetornoStatus.CODIGO_100, NFRetornoStatus.valueOfCodigo(100));
    }

    @Test
    public void valueOfCodigoNaoMapeadoTest() {
        Assert.assertNull(NFRetornoStatus.valueOfCodigo(666));
    }

    @Test
    public void isAutorizadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_100.isAutorizado());
        Assert.assertFalse(NFRetornoStatus.CODIGO_620.isAutorizado());
    }

    @Test
    public void isDenegadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_110.isDenegado());
        Assert.assertTrue(NFRetornoStatus.CODIGO_301.isDenegado());
        Assert.assertTrue(NFRetornoStatus.CODIGO_302.isDenegado());
        Assert.assertTrue(NFRetornoStatus.CODIGO_303.isDenegado());
        Assert.assertFalse(NFRetornoStatus.CODIGO_100.isDenegado());
    }

    @Test
    public void isRejeitadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_230.isRejeitado());
        Assert.assertFalse(NFRetornoStatus.CODIGO_100.isRejeitado());
        Assert.assertFalse(NFRetornoStatus.CODIGO_206.isRejeitado());
    }

    @Test
    public void isDuplicadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_539.isDuplicado());
        Assert.assertTrue(NFRetornoStatus.CODIGO_204.isDuplicado());
        Assert.assertFalse(NFRetornoStatus.CODIGO_100.isDuplicado());
    }

    @Test
    public void isJaInutilizadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_206.isJaInutilizado());
        Assert.assertFalse(NFRetornoStatus.CODIGO_100.isJaInutilizado());
    }
}