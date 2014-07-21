package com.fincatto.nfe.validadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringValidador {

    public static void mmaaaa(final String aamm) throws ParseException {
        new SimpleDateFormat("mm/yyyy").parse(aamm);
    }
}