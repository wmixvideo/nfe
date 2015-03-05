package com.fincatto.nfe310.validadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringValidador {

    private StringValidador() {
    }

    public static void mmaaaa(final String mmaaaa) {
        try {
            new SimpleDateFormat("mm/yyyy").parse(mmaaaa);
        } catch (final ParseException e) {
            throw new IllegalStateException(String.format("Formato invalido (mm/aaaa) (%s)", mmaaaa));
        }
    }

    public static void aamm(final String aamm) {
        try {
            new SimpleDateFormat("yymm").parse(aamm);
        } catch (final ParseException e) {
            throw new IllegalStateException(String.format("Formato invalido (aamm) (%s)", aamm));
        }
    }

    public static void codigoDeBarras(final String codigoDeBarras) {
        final Matcher matcher = Pattern.compile("^([0-9]{0}|[0-9]{8}|[0-9]{12,14})$").matcher(codigoDeBarras);
        if (!matcher.find()) {
            throw new IllegalStateException(String.format("Codigo de barras com formato invalido (%s)", codigoDeBarras));
        }
    }

    public static void telefone(final String telefone) {
        if (telefone != null) {
            final Matcher matcher = Pattern.compile("^[0-9]{6,14}$").matcher(telefone);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Telefone de tamanho invalido (%s)", telefone));
            }
        }
    }

    public static void tamanho256(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 256);
        }
    }

    public static void tamanho9(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 9);
        }
    }

    public static void tamanho60(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 60);
        }
    }

    public static void tamanho2ate60(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 2, 60);
        }
    }

    public static void tamanho22(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 22);
        }
    }

    public static void tamanho21(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 21);
        }
    }

    public static void tamanho20(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 20);
        }
    }

    public static void tamanho2000(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 2000);
        }
    }

    public static void tamanho5000(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 5000);
        }
    }

    public static void tamanho40(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 40);
        }
    }

    public static void placaDeVeiculo(final String placaVeiculo) {
        if (placaVeiculo != null) {
            final Matcher matcher = Pattern.compile("^([A-Z]{2,3}[0-9]{4}|[A-Z]{3,4}[0-9]{3})$").matcher(placaVeiculo);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Placa de veiculo nao esta no padrao (%s)", placaVeiculo));
            }
        }
    }

    public static void cnpj(final String cnpj) {
        if (cnpj != null) {
            final Matcher matcher = Pattern.compile("^[0-9]{14}$").matcher(cnpj);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Formato CNPJ Invalido (%s)", cnpj));
            }
        }
    }

    public static void cpf(final String cpf) {
        if (cpf != null) {
            final Matcher matcher = Pattern.compile("^[0-9]{11}$").matcher(cpf);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Formato CPF Invalido (%s)", cpf));
            }
        }
    }

    public static void inscricaoEstadual(final String inscricaoEstadual) {
        if (inscricaoEstadual != null) {
            final Matcher matcher = Pattern.compile("^(ISENTO|[0-9]{2,14}|)$").matcher(inscricaoEstadual);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Inscricao estadual invalido (%s)", inscricaoEstadual));
            }
        }
    }

    public static void inscricaoEstadualSemIsencao(final String inscricaoEstadual) {
        if (inscricaoEstadual != null) {
            final Matcher matcher = Pattern.compile("^([0-9]{2,14}|)$").matcher(inscricaoEstadual);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Inscricao estadual invalido (%s)", inscricaoEstadual));
            }
        }
    }

    public static void exatamente3(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 3);
        }
    }

    public static void exatamente5(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 5);
        }
    }

    public static void exatamente9(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 9);
        }
    }

    public static void exatamente17(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 17);
        }
    }

    public static void exatamente4(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 4);
        }
    }

    public static void exatamente6(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 6);
        }
    }

    public static void exatamente21(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 21);
        }
    }

    public static void exatamente1(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 1);
        }
    }

    public static void tamanho15(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 15);
        }
    }

    public static void tamanho12(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 12);
        }
    }

    public static void tamanho120(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 120);
        }
    }

    public static void tamanho6(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 6);
        }
    }

    public static void tamanho500(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 500);
        }
    }

    public static void tamanho3(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 3);
        }
    }

    public static void exatamente7(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 7);
        }
    }

    public static void exatamente8(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 8);
        }
    }

    public static void exatamente2(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 2);
        }
    }

    public static void tamanho8a9(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 8, 9);
        }
    }

    public static void tamanho15a256(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 15, 256);
        }
    }

    public static void tamanho15a255(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 15, 255);
        }
    }

    public static void tamanho5a20(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 5, 20);
        }
    }

    public static void tamanho5a60(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 5, 60);
        }
    }

    public static void tamanho2a4(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 2, 4);
        }
    }

    public static void tamanho8a9N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.intervalo(string, 8, 9);
        }
    }

    public static void tamanho15a1000(final String string) {
        if (string != null) {
            StringValidador.intervalo(string, 15, 1000);
        }
    }

    public static void tamanho30(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 30);
        }
    }

    public static void exatamente44(final String string) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 44);
        }
    }

    public static void exatamente7N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.exatamente7(string);
        }
    }

    public static void exatamente44N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.exatamente44(string);
        }
    }

    public static void exatamente4N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.exatamente4(string);
        }
    }

    public static void exatamente6N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.exatamente6(string);
        }
    }

    public static void tamanho15N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.validaTamanhoMaximo(string, 15);
        }
    }

    public static void tamanho9N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.validaTamanhoMaximo(string, 9);
        }
    }

    public static void tamanho3N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.validaTamanhoMaximo(string, 3);
        }
    }

    public static void exatamente20N(final String string) {
        if (string != null) {
            StringValidador.apenasNumerico(string);
            StringValidador.validaTamanhoExato(string, 20);
        }
    }

    public static void fci(final String numeroControleFCI) {
        if (numeroControleFCI != null) {
            final Matcher matcher = Pattern.compile("^([A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12})$").matcher(numeroControleFCI);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("FCI fora do padrao (%s)", numeroControleFCI));
            }
        }
    }

    public static void ncm(final String ncm) {
        if (ncm != null) {
            final Matcher matcher = Pattern.compile("^([0-9]{2}|[0][1-9][0-9]{6}|[1-9][0-9]{7})$").matcher(ncm);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("NCM fora do padrao (%s)", ncm));
            }
        }
    }

    private static void apenasNumerico(final String string) {
        if (!StringUtils.isNumeric(string)) {
            throw new IllegalStateException(String.format("a string precisa ser numerica (%s)", string));
        }
    }

    private static void validaTamanhoMaximo(final String string, final int tamanho) {
        if (string.length() < 1 || string.length() > tamanho) {
            throw new IllegalStateException(String.format("\"%s\" deve possuir entre 1-%s caracteres", string, tamanho));
        }
    }

    private static void validaTamanhoExato(final String string, final int tamanho) {
        if (string.length() != tamanho) {
            throw new IllegalStateException(String.format("\"%s\" deve possuir %s caracteres", string, tamanho));
        }
    }

    private static void intervalo(final String string, final int inicio, final int fim) {
        if (string.length() < inicio || string.length() > fim) {
            throw new IllegalStateException(String.format("\"%s\" deve possuir entre %s-%s caracteres", string, inicio, fim));
        }
    }

    public static void nve(final String nve) {
        final Matcher matcher = Pattern.compile("^[A-Z]{2}[0-9]{4}$").matcher(nve);
        if (!matcher.find()) {
            throw new IllegalStateException(String.format("NVE fora do padrao (%s)", nve));
        }
    }

    public static void itemListaServico(final String itemListaServicos) {
        final Matcher matcher = Pattern.compile("^\\d{2}\\.\\d{2}$").matcher(itemListaServicos);
        if (!matcher.find()) {
            throw new IllegalStateException(String.format("Item Lista de servico fora do padrao (%s)", itemListaServicos));
        }
    }

    public static void exatamente54(final String string) {
        StringValidador.validaTamanhoExato(string, 54);
    }

    public static void exatamente15N(final String string) {
        StringValidador.validaTamanhoExato(string, 15);
        StringValidador.apenasNumerico(string);
    }

    public static void modeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        if (!modeloDocumentoFiscal.equals("55")) {
            throw new IllegalStateException(String.format("Modelo Fiscal Invalido (%s)", modeloDocumentoFiscal));
        }
    }

    public static void identificador(final String identificador) {
        final Matcher matcher = Pattern.compile("^ID\\d{41}$").matcher(identificador);
        if (!matcher.find()) {
            throw new IllegalStateException(String.format("Identificador fora do padrao (%s)", identificador));
        }
    }
}