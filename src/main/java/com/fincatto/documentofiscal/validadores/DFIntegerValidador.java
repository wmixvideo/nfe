package com.fincatto.documentofiscal.validadores;

public abstract class DFIntegerValidador {

    public static void tamanho4(final Integer valor, final String info) {
        DFIntegerValidador.limite(valor, 9999, info);
    }

    public static void tamanho7(final Integer valor, final String info) {
        DFIntegerValidador.limite(valor, 9999999, info);
    }

    public static void tamanho9(final Integer valor, final String info) {
        DFIntegerValidador.limite(valor, 999999999, info);
    }

    public static void exatamente7(final Integer valor, final String info) {
        DFIntegerValidador.intervalo(valor, 1000000, 9999999, info);
    }

    public static void exatamente4(final int valor, final String info) {
        DFIntegerValidador.intervalo(valor, 1000, 9999, info);
    }

    public static void tamanho3(final int valor, final String info) {
        DFIntegerValidador.limite(valor, 999, info);
    }

    public static void tamanho3maximo990(final int valor, final String info) {
        DFIntegerValidador.limite(valor, 990, info);
    }

    public static void exatamente6(final Integer valor, final String info) {
        DFIntegerValidador.intervalo(valor, 100000, 999999, info);
    }

    public static void tamanho6(final Integer valor, final String info) {
        DFIntegerValidador.limite(valor, 999999, info);
    }

    public static void exatamente1(final Integer valor, final String info) {
        DFIntegerValidador.limite(valor, 9, info);
    }

    public static void tamanho1a2(final int valor, final String info) {
        DFIntegerValidador.intervalo(valor, 1, 99, info);
    }

    public static void tamanho1a3(final int valor, final String info) {
        DFIntegerValidador.intervalo(valor, 1, 999, info);
    }

    public static void exatamente2(final Integer valor, final String info) {
        DFIntegerValidador.intervalo(valor, 10, 99, info);
    }

    private static void limite(final Integer valor, final int maximo, final String info) {
        if (valor != null && valor > maximo) {
            throw new NumberFormatException("Valor extrapolou o tamanho do campo " + info);
        }
    }

    private static void intervalo(final Integer valor, final int minimo, final int maximo, final String info) {
        if (valor != null && (valor < minimo || valor > maximo)) {
            throw new NumberFormatException(String.format("Valor %s tem tamanho fora do intervalo de [%s-%s]", info, minimo, maximo));
        }
    }
}
