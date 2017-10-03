package com.fincatto.documentofiscal.validadores;

import java.math.BigInteger;

import org.junit.Test;

public class BigIntegerValidadorTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirTamanhoMaiorQue12() {
        BigIntegerValidador.tamanho12(new BigInteger("1000000000000"), "");
    }

    @Test
    public void devePermitirTamanhoDentroDe12Campos() {
        BigIntegerValidador.tamanho12(BigInteger.ONE, "");
        BigIntegerValidador.tamanho12(new BigInteger("999999999999"), "");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirTamanhoMaiorQue11() {
        BigIntegerValidador.tamanho11(new BigInteger("100000000000"), "");
    }

    @Test
    public void devePermitirTamanhoDentroDe11Campos() {
        BigIntegerValidador.tamanho11(BigInteger.ONE, "");
        BigIntegerValidador.tamanho11(new BigInteger("99999999999"), "");
    }

}
