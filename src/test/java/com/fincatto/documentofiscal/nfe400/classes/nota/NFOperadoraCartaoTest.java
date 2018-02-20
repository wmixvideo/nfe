package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFOperadoraCartaoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {

        Assert.assertEquals(NFOperadoraCartao.VISA, NFOperadoraCartao.valueOfCodigo("01"));
        Assert.assertEquals(NFOperadoraCartao.MASTERCARD, NFOperadoraCartao.valueOfCodigo("02"));
        Assert.assertEquals(NFOperadoraCartao.AMERICAN_EXPRESS, NFOperadoraCartao.valueOfCodigo("03"));
        Assert.assertEquals(NFOperadoraCartao.SOROCRED, NFOperadoraCartao.valueOfCodigo("04"));
        Assert.assertEquals(NFOperadoraCartao.OUTROS, NFOperadoraCartao.valueOfCodigo("99"));
        Assert.assertNull(NFOperadoraCartao.valueOfCodigo("00"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", NFOperadoraCartao.VISA.getCodigo());
        Assert.assertEquals("02", NFOperadoraCartao.MASTERCARD.getCodigo());
        Assert.assertEquals("03", NFOperadoraCartao.AMERICAN_EXPRESS.getCodigo());
        Assert.assertEquals("04", NFOperadoraCartao.SOROCRED.getCodigo());
        Assert.assertEquals("99", NFOperadoraCartao.OUTROS.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("01 - Visa", NFOperadoraCartao.VISA.toString());
    }
}