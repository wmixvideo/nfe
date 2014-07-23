package com.fincatto.nfe.validadores;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class BigDecimalParserTest {

    @Test
    public void devePermitirValoresCom2CasasDecimais() {
        Assert.assertEquals("0.01", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal(".01")));
        Assert.assertEquals("5.00", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("5")));
        Assert.assertEquals("100.00", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("100")));
        Assert.assertEquals("0.90", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal(".9")));
        Assert.assertEquals("182.64", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("182.64")));
    }

    @Test
    public void devePermitirValoresCom3CasasDecimais() {
        Assert.assertEquals("0.001", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal(".001")));
        Assert.assertEquals("5.000", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("5")));
        Assert.assertEquals("100.000", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("100")));
        Assert.assertEquals("0.900", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal(".9")));
        Assert.assertEquals("182.640", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("182.64")));
    }

    @Test
    public void devePermitirValoresComAte10CasasDecimais() {
        Assert.assertEquals("99999999999.9999999999", BigDecimalParser.tamanho11ComAte10CasasDecimas(new BigDecimal("99999999999.9999999999")));
        Assert.assertEquals("1", BigDecimalParser.tamanho11ComAte10CasasDecimas(new BigDecimal("1")));
        Assert.assertEquals("0.1", BigDecimalParser.tamanho11ComAte10CasasDecimas(new BigDecimal("0.1")));
        Assert.assertEquals("0.156", BigDecimalParser.tamanho11ComAte10CasasDecimas(new BigDecimal("0.156")));
    }

    @Test
    public void deveTruncarCom2CasasDecimais() {
        Assert.assertEquals("0.15", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("0.156")));
        Assert.assertEquals("0.15", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("0.155")));
        Assert.assertEquals("0.15", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("0.159")));
        Assert.assertEquals("0.15", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("0.151")));
        Assert.assertEquals("0.15", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("0.150")));
        Assert.assertEquals("99999999999.99", BigDecimalParser.tamanho15Com2CasasDecimais(new BigDecimal("99999999999.999")));
    }

    @Test
    public void deveTruncar10CasasDecimais() {
        Assert.assertEquals("0.0000000001", BigDecimalParser.tamanho11ComAte10CasasDecimas(new BigDecimal("0.00000000019")));
        Assert.assertEquals("9999999999.9999999999", BigDecimalParser.tamanho11ComAte10CasasDecimas(new BigDecimal("9999999999.99999999999")));
    }

    @Test
    public void deveTruncar3CasasDecimais() {
        Assert.assertEquals("0.155", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("0.1556")));
        Assert.assertEquals("0.155", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("0.1555")));
        Assert.assertEquals("0.155", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("0.1559")));
        Assert.assertEquals("0.155", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("0.1551")));
        Assert.assertEquals("0.155", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("0.1550")));
        Assert.assertEquals("99999999999.999", BigDecimalParser.tamanho15Com3CasasDecimais(new BigDecimal("99999999999.999")));
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
        BigDecimalParser.tamanho11ComAte10CasasDecimas(new BigDecimal("999999999999.9999999999"));
    }
}