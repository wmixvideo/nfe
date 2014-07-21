package com.fincatto.nfe.validadores;

import java.text.ParseException;

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
}