package com.fincatto.documentofiscal.validadores;

import java.math.BigInteger;

public abstract class BigIntegerValidador {

    public static void tamanho12(final BigInteger valor, final String info) {
        if (valor != null && valor.compareTo(new BigInteger("999999999999")) > 0) {
            throw new NumberFormatException(String.format("%s com tamanho maior que 12", info));
        }
    }

    public static void tamanho11(final BigInteger valor, final String info) {
        if (valor != null && valor.compareTo(new BigInteger("99999999999")) > 0) {
            throw new NumberFormatException(String.format("%s com tamanho maior que 11", info));
        }
    }
}
