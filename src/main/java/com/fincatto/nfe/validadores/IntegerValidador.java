package com.fincatto.nfe.validadores;

public class IntegerValidador {

    public static void tamanho4(final Integer valor) {
        IntegerValidador.valida(valor, 9999);
    }

    public static void tamanho7(final Integer valor) {
        IntegerValidador.valida(valor, 9999999);
    }

    private static void valida(final Integer valor, final int maximo) {
        if (valor > maximo) {
            throw new IllegalStateException("Valor extrapolou o tamanho do campo");
        }
    }
}