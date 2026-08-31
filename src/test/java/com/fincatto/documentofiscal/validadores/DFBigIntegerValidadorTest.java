package com.fincatto.documentofiscal.validadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class DFBigIntegerValidadorTest {

    @Test
    public void naoDevePermitirTamanhoMaiorQue12() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigIntegerValidador.tamanho12(new BigInteger("1000000000000"), ""));
    }

    @Test
    public void devePermitirTamanhoDentroDe12Campos() {
        DFBigIntegerValidador.tamanho12(BigInteger.ONE, "");
        DFBigIntegerValidador.tamanho12(new BigInteger("999999999999"), "");
    }

    @Test
    public void naoDevePermitirTamanhoMaiorQue11() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigIntegerValidador.tamanho11(new BigInteger("100000000000"), ""));
    }

    @Test
    public void devePermitirTamanhoDentroDe11Campos() {
        DFBigIntegerValidador.tamanho11(BigInteger.ONE, "");
        DFBigIntegerValidador.tamanho11(new BigInteger("99999999999"), "");
    }

}
