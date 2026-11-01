package com.fincatto.documentofiscal.validadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFIntegerValidadorTest {
    @Test
    public void deveValidarCasoValorParaTamanho7EstejaValido() {
        DFIntegerValidador.tamanho7(9999999, "");
    }

    @Test
    public void deveValidarCasoValorParaTamanho4EstejaValido() {
        DFIntegerValidador.tamanho4(9999, "");
    }

    @Test
    public void deveValidarCasoValorSejaExatamente7() {
        DFIntegerValidador.exatamente7(1000000, "");
        DFIntegerValidador.exatamente7(9999999, "");
    }

    @Test
    public void deveLancarExcecaoCasoValorParaTamanho7SejaInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFIntegerValidador.tamanho7(10000000, ""));
    }

    @Test
    public void deveLancarExcecaoCasoValorParaTamanho4SejaInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFIntegerValidador.tamanho4(10000, ""));
    }

    @Test
    public void deveValidarTamanho(){
        DFIntegerValidador.tamanho3(12, "");
        DFIntegerValidador.tamanho6(123456, "");
        DFIntegerValidador.tamanho9(12345678, "");
        DFIntegerValidador.tamanho1a2(1, "");
        DFIntegerValidador.tamanho1a2(99, "");
        DFIntegerValidador.tamanho3maximo990(3, "");
        DFIntegerValidador.tamanho3maximo990(100, "");
        DFIntegerValidador.tamanho3maximo990(990, "");
    }

    @Test
    public void deveValidarTamanhoExatamente(){
        DFIntegerValidador.exatamente1(9, "");
        DFIntegerValidador.exatamente2(99, "");
        DFIntegerValidador.exatamente4(9999, "");
        DFIntegerValidador.exatamente6(999999, "");
    }
}
