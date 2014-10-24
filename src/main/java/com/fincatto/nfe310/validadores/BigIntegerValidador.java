package com.fincatto.nfe310.validadores;

import java.math.BigInteger;

public class BigIntegerValidador {

    public static void tamanho12(final BigInteger valor) {
        if (valor.compareTo(new BigInteger("999999999999")) > 0) {
            throw new IllegalStateException("Tamanho maior que 12");
        }
    }

    public static void tamanho11(final BigInteger valor) {
        if (valor.compareTo(new BigInteger("99999999999")) > 0) {
            throw new IllegalStateException("Tamanho maior que 11");
        }
    }
}