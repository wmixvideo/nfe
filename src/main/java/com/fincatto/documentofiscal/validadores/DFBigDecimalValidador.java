package com.fincatto.documentofiscal.validadores;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class DFBigDecimalValidador {

    public static String tamanho11Com3CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.000", 12, 3, info);
    }

    public static String tamanho13Com2CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.00", 13, 2, info);
    }

    public static String tamanho15Com2CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.00", 16, 2, info);
    }

    public static String tamanho15Com3CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.000", 16, 3, info);
    }

    public static String tamanho15Com4CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.0000", 16, 4, info);
    }
    
    public static String tamanho11Com4CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.0000", 11, 4, info);
    }

    public static String tamanho21ComAte10CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.##########", 22, 10, info);
    }

    public static String tamanho15comAte4CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.####", 16, 4, info);
    }

    public static String tamanho15comAte6CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.######", 16, 6, info);
    }

    public static String tamanho5Com2CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.00", 7, 2, info);
    }

    public static String tamanho7ComAte4CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.00##", 8, 4, info);
    }

    public static String tamanho16ComAte4CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.####", 17, 4, info);
    }

    public static String tamanho16Com4CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.0000", 17, 4, info);
    }

    public static String tamanho9Com4CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.0000", 10, 4, info);
    }

    public static String tamanho4Com2CasasDecimais(final BigDecimal valor, final String info) {
        return DFBigDecimalValidador.parse(valor, "0.00", 5, 2, info);
    }

    public static String validaTamanho(BigDecimal valor, final String info, Integer tamanho, Integer posicaoPontoFlutuante, Boolean pontoFlutuanteExato) {
        valor = ObjectUtils.defaultIfNull(valor, BigDecimal.ZERO);
        tamanho = ObjectUtils.defaultIfNull(tamanho, 12);
        posicaoPontoFlutuante = ObjectUtils.defaultIfNull(posicaoPontoFlutuante, 2);
        pontoFlutuanteExato = ObjectUtils.defaultIfNull(pontoFlutuanteExato, false);
        return DFBigDecimalValidador.parse(valor, StringUtils.rightPad("0.", posicaoPontoFlutuante + 2, pontoFlutuanteExato ? "0" : "#"), tamanho, posicaoPontoFlutuante, info);
    }

    private static String parse(BigDecimal valor, final String formato, final int tamanho, final int posicaoPontoFlutuante, final String info) {
        if (valor == null) {
            return null;
        }
        if (valor.toPlainString().length() > tamanho || StringUtils.split(valor.toPlainString(), ".")[0].length() > (tamanho - (posicaoPontoFlutuante + 1)) || valor.scale() > posicaoPontoFlutuante) {
            throw new NumberFormatException(String.format("Valor %s extrapolou o tamanho de casas", info));
        }
        valor = valor.round(new MathContext(valor.precision(), RoundingMode.UNNECESSARY));
        return new DecimalFormat(formato, DecimalFormatSymbols.getInstance(Locale.US)).format(valor);
    }
}