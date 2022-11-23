package com.fincatto.documentofiscal.validadores;

import java.math.BigInteger;

import org.junit.Test;

public class DFBigIntegerValidadorTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirTamanhoMaiorQue12() {
        DFBigIntegerValidador.tamanho12(new BigInteger("1000000000000"), "");
    }

    @Test
    public void devePermitirTamanhoDentroDe12Campos() {
        DFBigIntegerValidador.tamanho12(BigInteger.ONE, "");
        DFBigIntegerValidador.tamanho12(new BigInteger("999999999999"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirTamanhoMaiorQue11() {
        DFBigIntegerValidador.tamanho11(new BigInteger("100000000000"), "");
    }

    @Test
    public void devePermitirTamanhoDentroDe11Campos() {
        DFBigIntegerValidador.tamanho11(BigInteger.ONE, "");
        DFBigIntegerValidador.tamanho11(new BigInteger("99999999999"), "");
    }

}
