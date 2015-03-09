package com.fincatto.nfe310.validadores;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class BigDecimalParser {

    private BigDecimalParser() {
    }

    public static String tamanho11Com3CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.000", 11, 3);
    }

    public static String tamanho15Com2CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.00", 16, 2);
    }

    public static String tamanho15Com3CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.000", 15, 3);
    }

    public static String tamanho15Com4CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.0000", 16, 4);
    }

    public static String tamanho21ComAte10CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.##########", 21, 10);
    }

    public static String tamanho15comAte4CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.####", 15, 4);
    }

    public static String tamanho5Com2CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.00", 6, 2);
    }

    public static String tamanho7ComAte4CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.00##", 7, 4);
    }

    public static String tamanho16ComAte4CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.####", 16, 4);
    }

    public static String tamanho16Com4CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.0000", 16, 4);
    }

    public static String tamanho9Com4CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.0000", 9, 4);
    }

    public static String tamanho4Com2CasasDecimais(final BigDecimal valor) {
        return BigDecimalParser.parse(valor, "0.00", 4, 2);
    }

    private static String parse(BigDecimal valor, final String formato, final int tamanho, final int posicaoPontoFlutuante) {
        if (valor.toPlainString().length() > tamanho || StringUtils.split(valor.toPlainString(), ".")[0].length() > (tamanho - (posicaoPontoFlutuante + 1)) || valor.scale() > posicaoPontoFlutuante) {
            throw new IllegalStateException("Valor extrapolou o tamanho de casas");
        }
        valor = valor.round(new MathContext(valor.precision(), RoundingMode.UNNECESSARY));
        return new DecimalFormat(formato, DecimalFormatSymbols.getInstance(Locale.US)).format(valor);
    }
}