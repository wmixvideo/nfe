package com.fincatto.documentofiscal.validadores;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalParserTest {

    @Test
    public void tamanho11Com3CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho11Com3CasasDecimais(null, ""));
        Assert.assertEquals("1.000", BigDecimalParser.tamanho11Com3CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.010", BigDecimalParser.tamanho11Com3CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.012", BigDecimalParser.tamanho11Com3CasasDecimais(new BigDecimal(".012"), ""));
    }

    @Test
    public void tamanho13Com2CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho13Com2CasasDecimais(null, ""));
        Assert.assertEquals("1.00", BigDecimalParser.tamanho13Com2CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.01", BigDecimalParser.tamanho13Com2CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.10", BigDecimalParser.tamanho13Com2CasasDecimais(new BigDecimal(".1"), ""));
    }
    @Test
    public void tamanho15Com2CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho15Com2CasasDecimais(null, ""));
        Assert.assertEquals("0.01", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("5.00", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("5"), ""));
        Assert.assertEquals("100.00", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("100"), ""));
        Assert.assertEquals("0.90", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal(".9"), ""));
        Assert.assertEquals("182.64", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("182.64"), ""));
    }

    @Test
    public void tamanho15Com3CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho15Com3CasasDecimais(null, ""));
        Assert.assertEquals("0.001", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal(".001"), ""));
        Assert.assertEquals("5.000", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("5"), ""));
        Assert.assertEquals("100.000", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("100"), ""));
        Assert.assertEquals("0.900", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal(".9"), ""));
        Assert.assertEquals("182.640", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("182.64"), ""));
    }

    @Test
    public void tamanho15Com4CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho15Com4CasasDecimais(null, ""));
        Assert.assertEquals("9999999999.9999", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("9999999999.9999"), ""));
        Assert.assertEquals("0.1000", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("0.0001", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("1.0000", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("1"), ""));
    }

    @Test
    public void tamanho21ComAte10CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho21ComAte10CasasDecimais(null, ""));
        Assert.assertEquals("9999999999.9999999999", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("9999999999.9999999999"), ""));
        Assert.assertEquals("1", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.1", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("0.156", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("0.156"), ""));
    }

    @Test
    public void tamanho16ComAte4CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho16ComAte4CasasDecimais(null, ""));
        Assert.assertEquals("99999999999.9999", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("99999999999.9999"), ""));
        Assert.assertEquals("0.0001", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("0.1", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("1", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("1"), ""));
    }

    @Test
    public void tamanho15ComAte6CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho15comAte6CasasDecimais(null, ""));
        Assert.assertEquals("999999999.999999", BigDecimalParser.tamanho15comAte6CasasDecimais(new BigDecimal("999999999.999999"), ""));
        Assert.assertEquals("0.0001", BigDecimalParser.tamanho15comAte6CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("0.1", BigDecimalParser.tamanho15comAte6CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("1", BigDecimalParser.tamanho15comAte6CasasDecimais(new BigDecimal("1"), ""));
    }

    @Test
    public void tamanho5Com2CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho5Com2CasasDecimais(null, ""));
        Assert.assertEquals("99.99", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("99.99"), ""));
        Assert.assertEquals("0.01", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("0.01"), ""));
        Assert.assertEquals("0.10", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("80.00", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("80"), ""));
        Assert.assertEquals("80.40", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("80.4"), ""));
    }

    @Test
    public void tamanho7ComAte4CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho7ComAte4CasasDecimais(null, ""));
        Assert.assertEquals("1.00", BigDecimalParser.tamanho7ComAte4CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.01", BigDecimalParser.tamanho7ComAte4CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.012", BigDecimalParser.tamanho7ComAte4CasasDecimais(new BigDecimal(".012"), ""));
        Assert.assertEquals("0.0123", BigDecimalParser.tamanho7ComAte4CasasDecimais(new BigDecimal(".0123"), ""));
    }

    @Test
    public void tamanho15comAte4CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho15comAte4CasasDecimais(null, ""));
        Assert.assertEquals("9999999999.9999", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9999"), ""));
        Assert.assertEquals("9999999999.9", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9"), ""));
        Assert.assertEquals("9999999999", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999"), ""));
        Assert.assertEquals("0.0001", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("1", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("1"), ""));
    }

    @Test
    public void tamanho16Com4CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho16Com4CasasDecimais(null, ""));
        Assert.assertEquals("1.0000", BigDecimalParser.tamanho16Com4CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.0100", BigDecimalParser.tamanho16Com4CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.0120", BigDecimalParser.tamanho16Com4CasasDecimais(new BigDecimal(".012"), ""));
        Assert.assertEquals("0.0123", BigDecimalParser.tamanho16Com4CasasDecimais(new BigDecimal(".0123"), ""));
    }

    @Test
    public void tamanho9Com4CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho9Com4CasasDecimais(null, ""));
        Assert.assertEquals("1.0000", BigDecimalParser.tamanho9Com4CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.0100", BigDecimalParser.tamanho9Com4CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.0120", BigDecimalParser.tamanho9Com4CasasDecimais(new BigDecimal(".012"), ""));
        Assert.assertEquals("0.0123", BigDecimalParser.tamanho9Com4CasasDecimais(new BigDecimal(".0123"), ""));
    }

    @Test
    public void tamanho4Com2CasasDecimais() {
        Assert.assertNull(BigDecimalParser.tamanho4Com2CasasDecimais(null, ""));
        Assert.assertEquals("1.00", BigDecimalParser.tamanho4Com2CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.10", BigDecimalParser.tamanho4Com2CasasDecimais(new BigDecimal(".1"), ""));
        Assert.assertEquals("0.12", BigDecimalParser.tamanho4Com2CasasDecimais(new BigDecimal(".12"), ""));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoDeInteiros() {
        BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("99999999999999.9"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoDeCasasDecimais() {
        BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("99999999999.999"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom2CasasDecimais() {
        BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("99999999999999.99"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom3CasasDecimais() {
        BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("9999999999999.999"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolar21Caracteres() {
        BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("999999999999.9999999999"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void validaTamanhoErro() {
        BigDecimalParser.validaTamanho(new BigDecimal("10.00000"),
                "", 11,4, true);
    }

    @Test
    public void validaTamanho() {
        BigDecimalParser.validaTamanho(new BigDecimal("10.00000"),
                "", 11,5, true);

        BigDecimalParser.validaTamanho(new BigDecimal("10.000"),
                "", 11,5, false);

        BigDecimalParser.validaTamanho(new BigDecimal("99999.99999"),
                "", 11,5, false);

    }


}
