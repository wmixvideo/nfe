package com.fincatto.nfe.validadores;

import org.junit.Assert;
import org.junit.Test;

public class StringValidatorTest {

    @Test
    public void deveValidarDataPadraoBrasileiro() {
        StringValidador.mmaaaa("12/2014");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaPadraoAmericano() {
        StringValidador.mmaaaa("2014-12");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaSemCaracterSeparador() {
        StringValidador.mmaaaa("201412");
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroIntervalo60() {
        StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh");
        StringValidador.tamanho60("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo60() {
        try {
            StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho60("");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroIntervalo() {
        StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV");
        StringValidador.tamanho22("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo22() {
        try {
            StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho22("");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroDoIntervalo() {
        StringValidador.tamanho20("AZgCErXz4DlSwRmsJaey");
        StringValidador.tamanho20("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo20() {
        try {
            StringValidador.tamanho20("AZgCErXz4DlSwRmsJaey1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho20("");
        }
        Assert.fail("Validacao falhou");
    }
}