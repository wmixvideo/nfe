package com.fincatto.nfe.validadores;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class BigDecimalParser {

    public static String tamanho15Com2CasasDecimais(BigDecimal valor) {
        try {
            valor = valor.round(new MathContext(14, RoundingMode.UNNECESSARY));
            valor = valor.setScale(2, BigDecimal.ROUND_FLOOR);
            return new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(valor);
        } catch (final ArithmeticException e) {
            throw new IllegalStateException("Tamanho deve ser no max de 15 digitos");
        }
    }

    public static String tamanho15Com3CasasDecimais(BigDecimal valor) {
        try {
            valor = valor.round(new MathContext(14, RoundingMode.UNNECESSARY));
            valor = valor.setScale(3, BigDecimal.ROUND_FLOOR);
            return new DecimalFormat("0.000", DecimalFormatSymbols.getInstance(Locale.US)).format(valor);
        } catch (final ArithmeticException e) {
            throw new IllegalStateException("Tamanho deve ser no max de 15 digitos");
        }
    }

    public static String tamanho11ComAte10CasasDecimas(BigDecimal valor) {
        try {
            valor = valor.round(new MathContext(21, RoundingMode.UNNECESSARY));
            valor = valor.setScale(10, BigDecimal.ROUND_FLOOR);
            return new DecimalFormat("0.##########", DecimalFormatSymbols.getInstance(Locale.US)).format(valor);
        } catch (final ArithmeticException e) {
            throw new IllegalStateException("Tamanho deve ser no max de 22 digitos");
        }
    }

    public static void comAte4CasasDecimais(final BigDecimal valor) {

    }
}