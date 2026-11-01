package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFOperadoraCartaoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {

        Assertions.assertEquals(NFOperadoraCartao.VISA, NFOperadoraCartao.valueOfCodigo("01"));
        Assertions.assertEquals(NFOperadoraCartao.MASTERCARD, NFOperadoraCartao.valueOfCodigo("02"));
        Assertions.assertEquals(NFOperadoraCartao.AMERICAN_EXPRESS, NFOperadoraCartao.valueOfCodigo("03"));
        Assertions.assertEquals(NFOperadoraCartao.SOROCRED, NFOperadoraCartao.valueOfCodigo("04"));
        Assertions.assertEquals(NFOperadoraCartao.OUTROS, NFOperadoraCartao.valueOfCodigo("99"));
        Assertions.assertNull(NFOperadoraCartao.valueOfCodigo("00"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFOperadoraCartao.VISA.getCodigo());
        Assertions.assertEquals("02", NFOperadoraCartao.MASTERCARD.getCodigo());
        Assertions.assertEquals("03", NFOperadoraCartao.AMERICAN_EXPRESS.getCodigo());
        Assertions.assertEquals("04", NFOperadoraCartao.SOROCRED.getCodigo());
        Assertions.assertEquals("99", NFOperadoraCartao.OUTROS.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("01 - Visa", NFOperadoraCartao.VISA.toString());
    }
}