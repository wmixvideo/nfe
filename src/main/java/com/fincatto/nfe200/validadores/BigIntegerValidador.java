package com.fincatto.nfe200.validadores;

import java.math.BigInteger;

public class BigIntegerValidador {

    public static void tamanho12(final BigInteger valor) {
        if (valor.compareTo(new BigInteger("999999999999")) > 0) {
            throw new IllegalStateException("Tamanho maior que 12");
        }
    }
}