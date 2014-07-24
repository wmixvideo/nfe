package com.fincatto.nfe.validadores;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.util.Locale;

public class BigDecimalParser {

    public static String tamanho15Com2CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.valida(valor, "0.00", 15, 2);
    }

    public static String tamanho15Com3CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.valida(valor, "0.000", 15, 3);
    }

    public static String tamanho22ComAte10CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.valida(valor, "0.##########", 22, 10);
    }

    public static String comAte4CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.valida(valor, "0.####", 15, 4);
    }

    public static String tamanho5Com2CasasDecimais(final BigDecimal aliquotaRetencao) {
        return BigDecimalParser.valida(aliquotaRetencao, "0.00", 5, 2);
    }

    private static String valida(BigDecimal valor, final String formato, final int tamanho, final int posicaoPontoFlutuante) {
        if (valor.precision() > tamanho || valor.toPlainString().length() > tamanho) {
            throw new IllegalStateException("Valor extrapolou o tamanho de casas");
        }
        try {
            valor = valor.round(new MathContext(valor.precision(), RoundingMode.UNNECESSARY));
            valor = valor.setScale(posicaoPontoFlutuante, BigDecimal.ROUND_FLOOR);
            return new DecimalFormat(formato, DecimalFormatSymbols.getInstance(Locale.US)).format(valor);
        } catch (final ArithmeticException e) {
            throw new IllegalStateException(MessageFormat.format("Tamanho deve ser no max de {0} digitos", (tamanho)));
        }
    }
}