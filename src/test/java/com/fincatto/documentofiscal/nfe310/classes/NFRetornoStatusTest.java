package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFRetornoStatus;

public class NFRetornoStatusTest {

    @Test
    public void valueOfCodigoStringTest() {
        Assert.assertEquals(NFRetornoStatus.AUTORIZADO_USO_NFE, NFRetornoStatus.valueOfCodigo("100"));
    }

    @Test
    public void valueOfCodigoIntegerTest() {
        Assert.assertEquals(NFRetornoStatus.AUTORIZADO_USO_NFE, NFRetornoStatus.valueOfCodigo(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfCodigoNaoMapeadoTest() {
        NFRetornoStatus.valueOfCodigo(666);
    }

    @Test
    public void isAutorizadoTest() {
        Assert.assertTrue(NFRetornoStatus.AUTORIZADO_USO_NFE.isAutorizado());
        Assert.assertFalse(NFRetornoStatus.CHAVE_DE_ACESSO_DIFERENTE_NO_DB_SEFAZ.isAutorizado());
    }

    @Test
    public void isDenegadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_110.isDenegado());
        Assert.assertTrue(NFRetornoStatus.CODIGO_301.isDenegado());
        Assert.assertTrue(NFRetornoStatus.CODIGO_302.isDenegado());
        Assert.assertTrue(NFRetornoStatus.CODIGO_303.isDenegado());
        Assert.assertFalse(NFRetornoStatus.AUTORIZADO_USO_NFE.isDenegado());
    }

    @Test
    public void isRejeitadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_230.isRejeitado());
        Assert.assertFalse(NFRetornoStatus.AUTORIZADO_USO_NFE.isRejeitado());
    }

    @Test
    public void isDuplicadoTest() {
        Assert.assertTrue(NFRetornoStatus.CODIGO_539.isDuplicado());
        Assert.assertFalse(NFRetornoStatus.AUTORIZADO_USO_NFE.isDuplicado());
    }
}