package com.fincatto.documentofiscal.utils;

import org.junit.Assert;
import org.junit.Test;

public class DFUtilsTest {
    @Test
    public void deveRejeitarCnpjNulo() {
        Assert.assertFalse(DFUtils.isCnpjValido(null));
    }

    @Test
    public void deveRejeitarCnpjVazio() {
        Assert.assertFalse(DFUtils.isCnpjValido(""));
    }

    @Test
    public void deveRejeitarCnpjComTodosDigitosIguais() {
        Assert.assertFalse(DFUtils.isCnpjValido("00000000000000"));
        Assert.assertFalse(DFUtils.isCnpjValido("11111111111111"));
    }

    @Test
    public void deveValidarCnpjNumericoTradicional() {
        Assert.assertTrue(DFUtils.isCnpjValido("03918609000132"));
        Assert.assertTrue(DFUtils.isCnpjValido("11222333000181"));
    }

    @Test
    public void deveRejeitarCnpjNumericoComDigitoInvalido() {
        Assert.assertFalse(DFUtils.isCnpjValido("03918609000199"));
        Assert.assertFalse(DFUtils.isCnpjValido("11222333000100"));
    }

    @Test
    public void deveRejeitarCnpjComTamanhoInvalido() {
        Assert.assertFalse(DFUtils.isCnpjValido("0391860900013"));
        Assert.assertFalse(DFUtils.isCnpjValido("039186090001322"));
    }

    @Test
    public void deveRejeitarCnpjComCaracteresEspeciais() {
        Assert.assertFalse(DFUtils.isCnpjValido("03.918.609/0001-32"));
    }

    @Test
    public void deveValidarCnpjAlfanumerico() {
        Assert.assertTrue(DFUtils.isCnpjValido("12ABC34501DE35"));
    }

    @Test
    public void deveValidarCnpjAlfanumericoCaseInsensitive() {
        Assert.assertTrue(DFUtils.isCnpjValido("12abc34501de35"));
    }

    @Test
    public void deveRejeitarCnpjAlfanumericoComDigitoInvalido() {
        Assert.assertFalse(DFUtils.isCnpjValido("12ABC34501DE99"));
    }

    @Test
    public void deveRejeitarCnpjComLetraNosDigitosVerificadores() {
        Assert.assertFalse(DFUtils.isCnpjValido("12ABC34501DEAB"));
    }

    @Test
    public void isCPFValido() {
        Assert.assertFalse(DFUtils.isCpfValido(null));
        Assert.assertFalse(DFUtils.isCpfValido(""));
        Assert.assertFalse(DFUtils.isCpfValido("00000000000"));
        Assert.assertFalse(DFUtils.isCpfValido("11111111111"));
        Assert.assertFalse(DFUtils.isCpfValido("12345678909"));
        Assert.assertTrue(DFUtils.isCpfValido("38883975022"));
    }

    @Test
    public void testIsNumerico() {
        Assert.assertFalse(DFUtils.isNumerico(null));
        Assert.assertFalse(DFUtils.isNumerico(""));
        Assert.assertFalse(DFUtils.isNumerico(" 12 "));
        Assert.assertTrue(DFUtils.isNumerico("0"));
        Assert.assertTrue(DFUtils.isNumerico("1234567890"));
    }
}
