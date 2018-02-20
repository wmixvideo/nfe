package com.fincatto.documentofiscal.validadores;

import org.junit.Test;

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

    @Test
    public void deveValidarTamanho(){
        IntegerValidador.tamanho3(12, "");
        IntegerValidador.tamanho6(123456, "");
        IntegerValidador.tamanho9(12345678, "");
        IntegerValidador.tamanho1a2(1, "");
        IntegerValidador.tamanho1a2(99, "");
        IntegerValidador.tamanho3maximo990(3, "");
        IntegerValidador.tamanho3maximo990(100, "");
        IntegerValidador.tamanho3maximo990(990, "");
    }

    @Test
    public void deveValidarTamanhoExatamente(){
        IntegerValidador.exatamente1(9, "");
        IntegerValidador.exatamente2(99, "");
        IntegerValidador.exatamente4(9999, "");
        IntegerValidador.exatamente6(999999, "");
    }
}
