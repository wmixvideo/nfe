package com.fincatto.nfe.validadores;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

public class StringValidatorTest {

    @Test
    public void deveValidarDataPadraoBrasileiro() throws ParseException {
        StringValidador.mmaaaa("12/2014");
    }

    @Test(expected = ParseException.class)
    public void deveLancarExcecaoCasoEstejaPadraoAmericano() throws ParseException {
        StringValidador.mmaaaa("2014-12");
    }

    @Test(expected = ParseException.class)
    public void deveLancarExcecaoCasoEstejaSemCaracterSeparador() throws ParseException {
        StringValidador.mmaaaa("201412");
    }

    @Test
    public void deveValidarTamanhoDeStringComRangeDe60Caracteres() {
        StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh");
        StringValidador.tamanho60("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoStringExtrapole60CaracteresOuSejaVazia() {
        try {
            StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho60("");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanhoDeStringComRangeDe22Caracteres() {
        StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV");
        StringValidador.tamanho22("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoStringExtrapole22CaracteresOuSejaVazia() {
        try {
            StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho22("");
        }
        Assert.fail("Validacao falhou");
    }
}