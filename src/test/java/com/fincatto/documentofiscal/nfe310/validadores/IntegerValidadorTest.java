package com.fincatto.documentofiscal.nfe310.validadores;

import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.validadores.IntegerValidador;

public class IntegerValidadorTest {

    @Test
    public void deveValidarCasoValorParaTamanho7EstejaValido() {
        IntegerValidador.tamanho7(9999999, "");
    }

    @Test
    public void deveValidarCasoValorParaTamanho4EstejaValido() {
        IntegerValidador.tamanho4(9999, "");
    }

    @Test
    public void deveValidarCasoValorSejaExatamente7() {
        IntegerValidador.exatamente7(1000000, "");
        IntegerValidador.exatamente7(9999999, "");
    }

    @Test(expected = NumberFormatException.class)
    public void deveLancarExcecaoCasoValorParaTamanho7SejaInvalido() {
        IntegerValidador.tamanho7(10000000, "");
    }

    @Test(expected = NumberFormatException.class)
    public void deveLancarExcecaoCasoValorParaTamanho4SejaInvalido() {
        IntegerValidador.tamanho4(10000, "");
    }
}