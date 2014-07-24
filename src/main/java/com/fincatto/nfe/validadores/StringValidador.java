package com.fincatto.nfe.validadores;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidador {

    public static void mmaaaa(final String aamm) {
        try {
            new SimpleDateFormat("mm/yyyy").parse(aamm);
        } catch (final ParseException e) {
            throw new IllegalStateException("Formato invalido (mm/aaaa)");
        }
    }

    public static void tamanho60(final String string) {
        StringValidador.validaTamanho(string, 60);
    }

    public static void tamanho22(final String string) {
        StringValidador.validaTamanho(string, 22);
    }

    public static void tamanho20(final String string) {
        StringValidador.validaTamanho(string, 20);
    }

    public static void tamanho2000(final String string) {
        StringValidador.validaTamanho(string, 2000);
    }

    public static void tamanho5000(final String string) {
        StringValidador.validaTamanho(string, 5000);
    }

    private static void validaTamanho(final String string, final int tamanho) {
        if (string.length() < 1 || string.length() > tamanho) {
            throw new IllegalStateException(MessageFormat.format("Este campo deve possuir entre 1-{0} caracteres", tamanho));
        }
    }

    public static void placaDeVeiculo(final String placaVeiculo) {
        boolean achou = false;
        final String[] padroesDePlaca = { "(?i)^[A-Z]{3}[0-9]{4}$", "(?i)^[A-Z]{3}[0-9]{3}$", "(?i)^[A-Z]{2}[0-9]{4}$", "(?i)^[A-Z]{4}[0-9]{3}$" };
        for (final String padraoDePlaca : Arrays.asList(padroesDePlaca)) {
            final Matcher matcher = Pattern.compile(padraoDePlaca).matcher(placaVeiculo);
            if (matcher.find()) {
                achou = true;
                break;
            }
        }
        if (!achou) {
            throw new IllegalStateException("Nao esta no padrao");
        }
    }

    public static void cnpj(final String cnpj) {
        final Matcher matcher = Pattern.compile("^[0-9]{14}$").matcher(cnpj);
        if (!matcher.find()) {
            throw new IllegalStateException("Formato CNPJ Invalido");
        }
    }

    public static void cpf(final String cpf) {
        final Matcher matcher = Pattern.compile("^[0-9]{11}$").matcher(cpf);
        if (!matcher.find()) {
            throw new IllegalStateException("Formato CPF Invalido");
        }
    }

    public static void inscricaoEstadual(final String inscricaoEstadual) {
        final Matcher matcher = Pattern.compile("^(ISENTO|[0-9]{2,14}|)$").matcher(inscricaoEstadual);
        if (!matcher.find()) {
            throw new IllegalStateException("Inscricao estadual invalido");
        }
    }
}