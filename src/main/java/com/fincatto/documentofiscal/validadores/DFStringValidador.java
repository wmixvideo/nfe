package com.fincatto.documentofiscal.validadores;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMSST;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNotaInfoItemImpostoICMS;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class DFStringValidador {

    public static void mmaaaa(final String mmaaaa) {
        if (mmaaaa != null) {
            try {
                DateTimeFormatter.ofPattern("mm/yyyy").parse(mmaaaa);
            } catch (final Exception e) {
                throw new IllegalStateException(String.format("Formato invalido (mm/aaaa) (%s)", mmaaaa));
            }
        }
    }

    public static void aamm(final String aamm) {
        if (aamm != null) {
            try {
                DateTimeFormatter.ofPattern("yymm").parse(aamm);
            } catch (final Exception e) {
                throw new IllegalStateException(String.format("Formato invalido (aamm) (%s)", aamm));
            }
        }
    }

    public static void codigoDeBarras(final String codigoDeBarras) {
        if (codigoDeBarras != null) {
            final Matcher matcher = Pattern.compile("^([0-9]{0}|[0-9]{8}|[0-9]{12,14}|SEM GTIN)$").matcher(codigoDeBarras);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Codigo de barras com formato invalido (%s)", codigoDeBarras));
            }
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

    public static String telefone(final String telefone, final String info) {
        if (telefone != null) {
            final Matcher matcher = Pattern.compile("^[0-9]{6,14}$").matcher(telefone);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Telefone de tamanho invalido (%s) em %s", telefone, info));
            }
        }
        return telefone;
    }

    public static void email(final String email) {
        if (email != null) {
            final String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            final Matcher matcher = Pattern.compile(regex).matcher(email);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Email invalido (%s)", email));
            }
        }
    }

    public static String email(final String email, final String info) {
        if (email != null) {
            final String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            final Matcher matcher = Pattern.compile(regex).matcher(email);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Email invalido (%s) em %s", email, info));
            }
        }
        return email;
    }

    public static void tamanho256(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 256, info);
        }
    }

    public static void tamanho9(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 9, info);
        }
    }

    public static void tamanho60(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 60, info);
        }
    }

    public static void tamanho1ate8(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 1, 8, info);
        }
    }

    public static void tamanho2ate60(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 2, 60, info);
        }
    }

    public static void tamanho2ate40(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 2, 40, info);
        }
    }

    public static void tamanho2ate255(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 2, 255, info);
        }
    }

    public static void tamanho2ate2000(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 2, 2000, info);
        }
    }

    public static void tamanho25ate250(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 25, 250, info);
        }
    }

    public static void tamanho22(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 22, info);
        }
    }

    public static void tamanho21(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 21, info);
        }
    }

    public static void tamanho20(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 20, info);
        }
    }

    public static void tamanho20N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.tamanho20(string, info);
        }
    }

    public static void tamanho2000(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 2000, info);
        }
    }

    public static void tamanho5000(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 5000, info);
        }
    }

    public static void tamanho40(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 40, info);
        }
    }

    public static void placaDeVeiculo(final String placaVeiculo) {
        if (placaVeiculo != null) {
            final Matcher matcher = Pattern.compile("^([A-Z]{2,3}[0-9]{4}|[A-Z]{3,4}[0-9]{3}|[A-Z]{3}[0-9][A-Z][0-9]{2})$").matcher(placaVeiculo);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Placa de veiculo nao esta no padrao (%s)", placaVeiculo));
            }
        }
    }

    public static void placaDeVeiculo(final String placaVeiculo, final String info) {
        if (placaVeiculo != null) {
            final Matcher matcher = Pattern.compile("^([A-Z]{2,3}[0-9]{4}|[A-Z]{3,4}[0-9]{3}|[A-Z]{3}[0-9][A-Z][0-9]{2})$").matcher(placaVeiculo);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("%s nao esta no padrao (%s)", info, placaVeiculo));
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

    public static String cnpj(final String cnpj, final String info) {
        if (cnpj != null) {
            final Matcher matcher = Pattern.compile("^[0-9]{14}$").matcher(cnpj);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Formato CNPJ Invalido (%s) em %s", cnpj, info));
            }
        }
        return cnpj;
    }

    public static void cpf(final String cpf) {
        if (cpf != null) {
            final Matcher matcher = Pattern.compile("^[0-9]{11}$").matcher(cpf);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Formato CPF Invalido (%s)", cpf));
            }
        }
    }

    public static String cpf(final String cpf, final String info) {
        if (cpf != null) {
            final Matcher matcher = Pattern.compile("^[0-9]{11}$").matcher(cpf);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Formato CPF Invalido (%s) em %s", cpf, info));
            }
        }
        return cpf;
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

    public static String inscricaoEstadualSemIsencao(final String inscricaoEstadual, final String info) {
        if (inscricaoEstadual != null) {
            final Matcher matcher = Pattern.compile("^([0-9]{2,14}|)$").matcher(inscricaoEstadual);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Inscricao estadual invalido (%s) em %s", inscricaoEstadual, info));
            }
        }
        return inscricaoEstadual;
    }

    public static void exatamente3(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 3, info);
        }
    }

    public static void exatamente5(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 5, info);
        }
    }

    public static void exatamente9(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 9, info);
        }
    }

    public static void exatamente9N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoExato(string, 9, info);
        }
    }

    public static void exatamente17(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 17, info);
        }
    }

    public static void exatamente4(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 4, info);
        }
    }

    public static void exatamente6(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 6, info);
        }
    }

    public static void exatamente21(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 21, info);
        }
    }

    public static void exatamente1(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 1, info);
        }
    }

    public static void exatamente13(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 13, info);
        }
    }

    public static void codigoProdutoAnvisa(final String string, final String info) {
        if (string != null) {
            if (string.toUpperCase().matches("[A-Z]*")) {
                if (!Objects.equals(string.toUpperCase(), "ISENTO")) {
                    throw new IllegalStateException(String.format("C\u00f3digo produto anvisa (%s) diferente de ISENTO", string));
                }
            } else {
                if (string.length() <= 11) {
                    DFStringValidador.validaTamanhoExato(string, 11, info);
                } else {
                    DFStringValidador.validaTamanhoExato(string, 13, info);
                }
            }
        }
    }

    public static void tamanho15(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 15, info);
        }
    }

    public static void tamanho12(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 12, info);
        }
    }

    public static void tamanho12N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 12, info);
        }
    }

    public static void tamanho120(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 120, info);
        }
    }

    public static void tamanho160(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 160, info);
        }
    }

    public static void tamanho10(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 10, info);
        }
    }

    public static void tamanho10N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 10, info);
        }
    }

    public static void tamanho100(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 100, info);
        }
    }

    public static void tamanho6(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 6, info);
        }
    }

    public static void tamanho6N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 6, info);
        }
    }

    public static void tamanho500(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 500, info);
        }
    }

    public static void tamanho3(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 3, info);
        }
    }

    public static void exatamente7(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 7, info);
        }
    }

    public static void exatamente8(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 8, info);
        }
    }

    public static void exatamente8N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoExato(string, 8, info);
        }
    }

    public static void exatamente2(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 2, info);
        }
    }

    public static void exatamente2N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoExato(string, 2, info);
        }
    }

    public static void tamanho8a9(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 8, 9, info);
        }
    }

    public static void tamanho15a256(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 15, 256, info);
        }
    }

    public static void tamanho15a255(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 15, 255, info);
        }
    }

    public static void tamanho5a20(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 5, 20, info);
        }
    }

    public static void tamanho5a14(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 5, 14, info);
        }
    }

    public static void tamanho5a60(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 5, 60, info);
        }
    }

    public static void tamanho4a60(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 4, 60, info);
        }
    }

    public static void tamanho2a4(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 2, 4, info);
        }
    }

    public static void tamanho2a9N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.intervalo(string, 2, 9, info);
        }
    }

    public static void tamanho8a9N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.intervalo(string, 8, 9, info);
        }
    }

    public static void tamanho15a1000(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 15, 1000, info);
        }
    }

    public static void tamanho100a600(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 100, 600, info);
        }
    }

    public static void tamanho2a95(final String string, final String info) {
        if (string != null) {
            DFStringValidador.intervalo(string, 2, 95, info);
        }
    }

    public static void tamanho30(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 30, info);
        }
    }

    public static void exatamente44(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoExato(string, 44, info);
        }
    }

    public static void exatamente7N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.exatamente7(string, info);
        }
    }

    public static void exatamente44N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.exatamente44(string, info);
        }
    }

    public static void exatamente4N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.exatamente4(string, info);
        }
    }

    public static void exatamente6N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.exatamente6(string, info);
        }
    }

    public static void tamanho15N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 15, info);
        }
    }

    public static void tamanho14N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 14, info);
        }
    }

    public static void tamanho4(final String string, final String info) {
        if (string != null) {
            DFStringValidador.validaTamanhoMaximo(string, 4, info);
        }
    }

    public static void tamanho4N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 4, info);
        }
    }

    public static void tamanho9N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 9, info);
        }
    }

    public static void tamanho2ou3N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.intervalo(string, 2, 3, info);
        }
    }

    public static void tamanho3N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 3, info);
        }
    }

    public static void tamanho2N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 2, info);
        }
    }

    public static void exatamente20N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoExato(string, 20, info);
        }
    }

    public static void tamanho25N(final String string, final String info) {
        if (string != null) {
            DFStringValidador.apenasNumerico(string, info);
            DFStringValidador.validaTamanhoMaximo(string, 25, info);
        }
    }

    /**
     * Metodo para validacao de Strings.
     *
     * @param paraValidar String a ser validada
     * @param info Informacao de retorno caso haja erro.
     * @param tamanho tamanho para validacao da {@code String} , pode ser
     * {@code null} :
     * @param exatamente <pre>
     * se false {@code null} a {@code String}
     *                   nao precisa ter o tamanho exato do parametro anterior.
     * </pre>
     *
     * @param numerico se true {@code null} a {@code String} precisa ser
     * numerica[0-9].
     * @param paraValidar}.
     * @return retorna a propria {@code String} {
     */
    public static String validador(final String paraValidar, final String info, Integer tamanho, Boolean exatamente, Boolean numerico) {
        tamanho = ObjectUtils.defaultIfNull(tamanho, 1);
        exatamente = ObjectUtils.defaultIfNull(exatamente, false);
        numerico = ObjectUtils.defaultIfNull(numerico, true);
        if (paraValidar != null) {
            if (numerico) {
                DFStringValidador.apenasNumerico(paraValidar, info);
            }
            if (exatamente) {
                DFStringValidador.validaTamanhoExato(paraValidar, tamanho, info);
            } else {
                DFStringValidador.validaTamanhoMaximo(paraValidar, tamanho, info);
            }
        }
        return paraValidar;
    }

    /**
     * @See #validador
     */
    public static String validador(final String paraValidar, final String info, final Integer tamanho, final Boolean exatamente) {
        return DFStringValidador.validador(paraValidar, info, tamanho, exatamente, null);
    }

    /**
     * @See #validador
     */
    public static String validador(final String paraValidar, final String info, final Integer tamanho) {
        return DFStringValidador.validador(paraValidar, info, tamanho, null, null);
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
            final Matcher matcher = Pattern.compile("^([0-9]{2}|[0-9]{8})$").matcher(ncm);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("NCM fora do padrao (%s)", ncm));
            }
        }
    }

    private static void apenasNumerico(final String string, final String info) {
        if (string != null && !StringUtils.isNumeric(string)) {
            throw new IllegalStateException(String.format("A string %s precisa ser numerica (%s)", info, string));
        }
    }

    public static void validaTamanhoMaximo(final String string, final int tamanho, final String info) {
        if (string != null && (string.length() < 1 || string.length() > tamanho)) {
            throw new IllegalStateException(String.format("%s \"%s\" deve possuir entre 1-%s caracteres", info, string, tamanho));
        }
    }

    private static void validaTamanhoExato(final String string, final int tamanho, final String info) {
        if (string != null && string.length() != tamanho) {
            throw new IllegalStateException(String.format("%s \"%s\" deve possuir %s caracteres", info, string, tamanho));
        }
    }

    private static void intervalo(final String string, final int inicio, final int fim, final String info) {
        if (string != null && (string.length() < inicio || string.length() > fim)) {
            throw new IllegalStateException(String.format("%s \"%s\" deve possuir entre %s-%s caracteres", info, string, inicio, fim));
        }
    }

    public static String validaIntervalo(final String string, final int inicio, final int fim, final String info) {
        return DFStringValidador.validaIntervalo(string, inicio, fim, info, false);
    }

    public static String validaIntervalo(final String string, final int inicio, final int fim, final String info, Boolean isNumeric) {
        if (string != null) {
            isNumeric = ObjectUtils.defaultIfNull(isNumeric, false);
            if (isNumeric) {
                DFStringValidador.apenasNumerico(string, info);
            }
            DFStringValidador.intervalo(string, inicio, fim, info);
        }
        return string;
    }

    /**
     * Valida um numero com N {
     *
     * <pre>
     *  StringValidador.capacidadeNDigitos("10000", "info" , 5)   = "10000"
     *  StringValidador.capacidadeNDigitos("5", "info" , 2)   = "5"
     * </pre>
     *
     * @param capacidade
     * @param info
     * @param digitos
     * @return
     * @throws IllegalStateException se<br>
     * {@code capacidade = "10000" } & {@code digitos = 3}, ou seja , {@code capacidade.length()-1 > digitos
     * }
     */
    public static String capacidadeNDigitos(final String capacidade, final String info, final int digitos) {
        if (capacidade != null) {
            final Matcher matcher = Pattern.compile("^(0|[1-9]{1}[0-9]{0," + digitos + "})$").matcher(capacidade);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("%s fora do padrao (%s)", info, capacidade));
            }
        }
        return capacidade;
    }

    public static void nve(final String nve) {
        if (nve != null) {
            final Matcher matcher = Pattern.compile("^[A-Z]{2}[0-9]{4}$").matcher(nve);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("NVE fora do padrao (%s)", nve));
            }
        }
    }

    public static void itemListaServico(final String itemListaServicos) {
        if (itemListaServicos != null) {
            final Matcher matcher = Pattern.compile("^\\d{2}\\.\\d{2}$").matcher(itemListaServicos);
            if (!matcher.find()) {
                throw new IllegalStateException(String.format("Item Lista de servico fora do padrao (%s)", itemListaServicos));
            }
        }
    }

    public static void exatamente54(final String string, final String info) {
        DFStringValidador.validaTamanhoExato(string, 54, info);
    }

    public static void exatamente55(final String string, final String info) {
        DFStringValidador.validaTamanhoExato(string, 55, info);
    }

    public static void exatamente15N(final String string, final String info) {
        DFStringValidador.validaTamanhoExato(string, 15, info);
        DFStringValidador.apenasNumerico(string, info);
    }

    public static void exatamente11N(final String string, final String info) {
        DFStringValidador.apenasNumerico(string, info);
        DFStringValidador.validaTamanhoExato(string, 11, info);
    }

    public static void modeloDocumentoFiscal(final String modeloDocumentoFiscal) {
        if (!modeloDocumentoFiscal.equals("55") && !modeloDocumentoFiscal.equals("65")) {
            throw new IllegalStateException(String.format("Modelo Fiscal Invalido (%s)", modeloDocumentoFiscal));
        }
    }

    public static void identificador(final String identificador) {
        final Matcher matcher = Pattern.compile("^ID\\d{41}$").matcher(identificador);
        if (!matcher.find()) {
            throw new IllegalStateException(String.format("Identificador fora do padrao (%s)", identificador));
        }
    }

    public static void identificadorCTe(final String identificador) {
        final Matcher matcher = Pattern.compile("^ID\\d{39}$").matcher(identificador);
        if (!matcher.find()) {
            throw new IllegalStateException(String.format("Identificador fora do padrao (%s)", identificador));
        }
    }

    public static void equals(final String test, final String tested) {
        if (!StringUtils.equals(test, tested)) {
            throw new IllegalStateException(String.format("Valor('%s') nao corresponde com o padrao('%s')", tested, test));
        }
    }

    public static void isBase64(final String string, final String info) {
        if (!Base64.isArrayByteBase64(string.getBytes())) {
            throw new IllegalStateException(String.format("A string %s com o valor = '%s' precisa ser codificada em Base64. ", info, string));
        }
    }

    /**
     * Validacao conforme nota tecnica 2019.001 Versao 1.00 – Abril de 2019
     */
    public static void validaCodigoRandomico(final String string, final String info) {
        String[] codigosInvalidos = new String[]{"00000000", "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999", "12345678", "23456789", "34567890", "45678901", "56789012", "67890123", "78901234", "89012345", "90123456", "01234567"};
        if (StringUtils.containsAny(string, codigosInvalidos)) {
            throw new IllegalStateException(String.format("%s \"%s\" inválido", info, string));
        }
    }

    /**
     * Metodo para regra de validacao N18-10 e N18-20, da nota tecnica :
     * 2019.001 Versao 1.00 – Abril de 2019 Utilizasse Java reflection para
     * acessar os metodos necessarios.
     */
    //este metodo esta muito ruim, nao faz nada e ainda estoura um stack trace que nao pode ser capturado!
    //(pq está ruim?, ele faz a validacao da nota tecnica 2019.001 Versao 1.00 descrita no comentario do metodo)
    public static void validaPreenchimentoDeMargemValorAgregado(NFNotaInfoItemImpostoICMS impostoICMS) throws InvocationTargetException, IllegalAccessException {
        if (impostoICMS != null) {
            //seleciona todos os metodos da classe de ICMS
            for (Method method : impostoICMS.getClass().getMethods()) {
                final Class<?> returnType = method.getReturnType();
                Method[] typeMethods = returnType.getMethods();
                //verifica se a classe de ICMS tem o item NFNotaInfoItemModalidadeBCICMSST.
                final boolean present = Arrays.stream(typeMethods).anyMatch(method1 -> method1.getReturnType().equals(NFNotaInfoItemModalidadeBCICMSST.class));
                if (present) {
                    //invoca o metodo para verificar qual classe de ICMS esta preenchida(objectValue!=null)
                    Object objectValue = method.invoke(impostoICMS);
                    if (objectValue != null) {
                        // retorna o metodo necessario para extrair o valor de ModalidadeMVA.
                        Method modalidadeMethod = Arrays.stream(typeMethods).filter(method1 -> method1.getReturnType().equals(NFNotaInfoItemModalidadeBCICMSST.class)).findAny().get();
                        NFNotaInfoItemModalidadeBCICMSST modalidadeBCICMSST = (NFNotaInfoItemModalidadeBCICMSST) modalidadeMethod.invoke(objectValue, new Object[]{});
                        // retorna o metodo necessario para extrair o valor da percentualMargemValorAdicionadoICMSST(pMVAST).
                        Method percentualMethod = Arrays.stream(typeMethods).filter(method1 -> method1.getName().contains("getPercentualMargemValorAdicionadoICMSST")).findAny().orElse(null);
                        String percentualValue = null;
                        if (percentualMethod != null) {
                            percentualValue = (String) percentualMethod.invoke(objectValue, new Object[]{});
                        }
                        //verificacoes conforme a regra de validacao
                        if (modalidadeBCICMSST != null && modalidadeBCICMSST.equals(NFNotaInfoItemModalidadeBCICMSST.MARGEM_VALOR_AGREGADO) && StringUtils.isBlank(percentualValue)) {
                            throw new IllegalStateException("Informada modalidade de determinacao da BC da ST como MVA(modBCST=4)" + " e nao informado o campo pMVAST!");
                        } else if (StringUtils.isNotBlank(percentualValue) && (modalidadeBCICMSST == null || !modalidadeBCICMSST.equals(NFNotaInfoItemModalidadeBCICMSST.MARGEM_VALOR_AGREGADO))) {
                            throw new IllegalStateException(String.format("Informada modalidade de determinacao da BC da ST diferente de MVA(informado[%s]) e informado o campo pMVAST", (modalidadeBCICMSST != null ? modalidadeBCICMSST.toString() : "modBCST<>4")));
                        }
                    }
                }
            }
        }
    }
}
