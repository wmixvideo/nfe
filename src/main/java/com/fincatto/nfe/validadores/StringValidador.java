package com.fincatto.nfe.validadores;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringValidador {

    public static void mmaaaa(final String aamm) throws ParseException {
        new SimpleDateFormat("mm/yyyy").parse(aamm);
    }

    public static void tamanho60(final String string) {
        StringValidador.validaTamanho(string, 60);
    }

    public static void tamanho22(final String string) {
        StringValidador.validaTamanho(string, 22);
    }

    private static void validaTamanho(final String string, final int tamanho) {
        if (string.length() < 1 || string.length() > tamanho) {
            throw new IllegalStateException(MessageFormat.format("Deve possuir entre 1-{0} caracteres", tamanho));
        }
    }
}