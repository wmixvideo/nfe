package com.fincatto.nfe200.validadores;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.validadores.BigDecimalParser;

public class BigDecimalParserTest {

    @Test
    public void devePermitirValores15Com2CasasDecimais() {
        Assert.assertEquals("0.01", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal(".01")));
        Assert.assertEquals("5.00", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("5")));
        Assert.assertEquals("100.00", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("100")));
        Assert.assertEquals("0.90", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal(".9")));
        Assert.assertEquals("182.64", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("182.64")));
    }

    @Test
    public void devePermitirValores15Com3CasasDecimais() {
        Assert.assertEquals("0.001", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal(".001")));
        Assert.assertEquals("5.000", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("5")));
        Assert.assertEquals("100.000", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("100")));
        Assert.assertEquals("0.900", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal(".9")));
        Assert.assertEquals("182.640", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("182.64")));
    }

    @Test
    public void devePermitirValores15Com4CasasDecimais() {
        Assert.assertEquals("9999999999.9999", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("9999999999.9999")));
        Assert.assertEquals("0.1000", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("0.1")));
        Assert.assertEquals("0.0001", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("0.0001")));
        Assert.assertEquals("1.0000", BigDecimalParser.tamanho15Com4CasasDecimais(new BigDecimal("1")));
    }

    @Test
    public void devePermitirValores22ComAte10CasasDecimais() {
        Assert.assertEquals("9999999999.9999999999", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("9999999999.9999999999")));
        Assert.assertEquals("1", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("1")));
        Assert.assertEquals("0.1", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("0.1")));
        Assert.assertEquals("0.156", BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("0.156")));
    }

    @Test
    public void devePermitirValores16ComAte4CasasDecimais() {
        Assert.assertEquals("99999999999.9999", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("99999999999.9999")));
        Assert.assertEquals("0.0001", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("0.0001")));
        Assert.assertEquals("0.1", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("0.1")));
        Assert.assertEquals("1", BigDecimalParser.tamanho16ComAte4CasasDecimais(new BigDecimal("1")));
    }

    @Test
    public void devePermitirValores5Com2CasasDecimais() {
        Assert.assertEquals("99.99", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("99.99")));
        Assert.assertEquals("0.01", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("0.01")));
        Assert.assertEquals("0.10", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("0.1")));
        Assert.assertEquals("80.00", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("80")));
        Assert.assertEquals("80.40", BigDecimalParser.tamanho5Com2CasasDecimais(new BigDecimal("80.4")));
    }

    @Test
    public void devePermitirValores15ComAte4CasasDecimais() {
        Assert.assertEquals("9999999999.9999", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9999")));
        Assert.assertEquals("9999999999.9", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9")));
        Assert.assertEquals("9999999999", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999")));
        Assert.assertEquals("0.0001", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("0.0001")));
        Assert.assertEquals("1", BigDecimalParser.tamanho15comAte4CasasDecimais(new BigDecimal("1")));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolacaoDeInteiros() {
        BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("9999999999999.9"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolacaoDeCasasDecimais() {
        BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("99999999999.999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom2CasasDecimais() {
        BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("9999999999999.99"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom3CasasDecimais() {
        BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("999999999999.999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolar21Caracteres() {
        BigDecimalParser.tamanho21ComAte10CasasDecimais(new BigDecimal("999999999999.9999999999"));
    }
}