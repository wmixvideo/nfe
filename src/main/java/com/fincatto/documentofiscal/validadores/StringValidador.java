package com.fincatto.documentofiscal.validadores;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class StringValidador {

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
            StringValidador.validaTamanhoMaximo(string, 256, info);
        }
    }

    public static void tamanho9(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 9, info);
        }
    }

    public static void tamanho60(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 60, info);
        }
    }

    public static void tamanho2ate60(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 2, 60, info);
        }
    }

    public static void tamanho2ate40(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 2, 40, info);
        }
    }

    public static void tamanho2ate255(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 2, 255, info);
        }
    }

    public static void tamanho22(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 22, info);
        }
    }

    public static void tamanho21(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 21, info);
        }
    }

    public static void tamanho20(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 20, info);
        }
    }

    public static void tamanho20N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.tamanho20(string, info);
        }
    }

    public static void tamanho2000(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 2000, info);
        }
    }

    public static void tamanho5000(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 5000, info);
        }
    }

    public static void tamanho40(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 40, info);
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
            StringValidador.validaTamanhoExato(string, 3, info);
        }
    }

    public static void exatamente5(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 5, info);
        }
    }

    public static void exatamente9(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 9, info);
        }
    }

    public static void exatamente9N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoExato(string, 9, info);
        }
    }

    public static void exatamente17(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 17, info);
        }
    }

    public static void exatamente4(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 4, info);
        }
    }

    public static void exatamente6(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 6, info);
        }
    }

    public static void exatamente21(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 21, info);
        }
    }

    public static void exatamente1(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 1, info);
        }
    }

    public static void exatamente13(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 13, info);
        }
    }

    public static void tamanho15(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 15, info);
        }
    }

    public static void tamanho12(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 12, info);
        }
    }

    public static void tamanho120(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 120, info);
        }
    }

    public static void tamanho160(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 160, info);
        }
    }

    public static void tamanho10(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 10, info);
        }
    }

    public static void tamanho10N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoMaximo(string, 10, info);
        }
    }

    public static void tamanho100(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 100, info);
        }
    }

    public static void tamanho6(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 6, info);
        }
    }

    public static void tamanho6N(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 6, info);
        }
    }

    public static void tamanho500(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 500, info);
        }
    }

    public static void tamanho3(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 3, info);
        }
    }

    public static void exatamente7(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 7, info);
        }
    }

    public static void exatamente8(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 8, info);
        }
    }

    public static void exatamente8N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoExato(string, 8, info);
        }
    }

    public static void exatamente2(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 2, info);
        }
    }

    public static void exatamente2N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoExato(string, 2, info);
        }
    }

    public static void tamanho8a9(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 8, 9, info);
        }
    }

    public static void tamanho15a256(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 15, 256, info);
        }
    }

    public static void tamanho15a255(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 15, 255, info);
        }
    }

    public static void tamanho5a20(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 5, 20, info);
        }
    }

    public static void tamanho5a14(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 5, 14, info);
        }
    }

    public static void tamanho5a60(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 5, 60, info);
        }
    }

    public static void tamanho2a4(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 2, 4, info);
        }
    }

    public static void tamanho2a9N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.intervalo(string, 2, 9, info);
        }
    }

    public static void tamanho8a9N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.intervalo(string, 8, 9, info);
        }
    }

    public static void tamanho15a1000(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 15, 1000, info);
        }
    }

    public static void tamanho100a600(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 100, 600, info);
        }
    }

    public static void tamanho2a95(final String string, final String info) {
        if (string != null) {
            StringValidador.intervalo(string, 2, 95, info);
        }
    }

    public static void tamanho30(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 30, info);
        }
    }

    public static void exatamente44(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoExato(string, 44, info);
        }
    }

    public static void exatamente7N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.exatamente7(string, info);
        }
    }

    public static void exatamente44N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.exatamente44(string, info);
        }
    }

    public static void exatamente4N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.exatamente4(string, info);
        }
    }

    public static void exatamente6N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.exatamente6(string, info);
        }
    }

    public static void tamanho15N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoMaximo(string, 15, info);
        }
    }

    public static void tamanho14N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoMaximo(string, 14, info);
        }
    }

    public static void tamanho4(final String string, final String info) {
        if (string != null) {
            StringValidador.validaTamanhoMaximo(string, 4, info);
        }
    }

    public static void tamanho4N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoMaximo(string, 4, info);
        }
    }

    public static void tamanho9N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoMaximo(string, 9, info);
        }
    }

    public static void tamanho2ou3N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.intervalo(string, 2, 3, info);
        }
    }

    public static void tamanho3N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoMaximo(string, 3, info);
        }
    }

    public static void tamanho2N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoMaximo(string, 2, info);
        }
    }

    public static void exatamente20N(final String string, final String info) {
        if (string != null) {
            StringValidador.apenasNumerico(string, info);
            StringValidador.validaTamanhoExato(string, 20, info);
        }
    }

    /**
     * Método para validação de Strings.
     * @param paraValidar String a ser validada
     * @param info Informação de retorno caso haja erro.
     * @param tamanho tamanho para validação da {@code String} , pode ser {@code null} :
     * @param exatamente <pre>
     * se false {@code null} a {@code String}
     *                   não precisa ter o tamanho exato do parametro anterior.
     * </pre>
     * @param numerico se true {@code null} a {@code String} precisa ser numérica[0-9].
     * @param paraValidar}.
     * @return retorna a própria {@code String} {
     */
    public static String validador(final String paraValidar, final String info, Integer tamanho, Boolean exatamente, Boolean numerico) {
        tamanho = ObjectUtils.defaultIfNull(tamanho, 1);
        exatamente = ObjectUtils.defaultIfNull(exatamente, false);
        numerico = ObjectUtils.defaultIfNull(numerico, true);
        if (paraValidar != null) {
            if (numerico) {
                StringValidador.apenasNumerico(paraValidar, info);
            }
            if (exatamente) {
                StringValidador.validaTamanhoExato(paraValidar, tamanho, info);
            } else {
                StringValidador.validaTamanhoMaximo(paraValidar, tamanho, info);
            }
        }
        return paraValidar;
    }

    /**
     * @See #validador
     */
    public static String validador(final String paraValidar, final String info, final Integer tamanho, final Boolean exatamente) {
        return StringValidador.validador(paraValidar, info, tamanho, exatamente, null);
    }

    /**
     * @See #validador
     */
    public static String validador(final String paraValidar, final String info, final Integer tamanho) {
        return StringValidador.validador(paraValidar, info, tamanho, null, null);
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

    private static void validaTamanhoMaximo(final String string, final int tamanho, final String info) {
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
        return StringValidador.validaIntervalo(string, inicio, fim, info, false);
    }

    public static String validaIntervalo(final String string, final int inicio, final int fim, final String info, Boolean isNumeric) {
        if (string != null) {
            isNumeric = ObjectUtils.defaultIfNull(isNumeric, false);
            if (isNumeric) {
                StringValidador.apenasNumerico(string, info);
            }
            StringValidador.intervalo(string, inicio, fim, info);
        }
        return string;
    }

    /**
     * Valida um número com N {
     *
     * <pre>
     *  StringValidador.capacidadeNDigitos("10000", "info" , 5)   = "10000"
     *  StringValidador.capacidadeNDigitos("5", "info" , 2)   = "5"
     * </pre>
     * @param capacidade
     * @param info
     * @param digitos
     * @return
     * @throws IllegalStateException se<br>
     * {@code capacidade = "10000" } & {@code digitos = 3}, ou seja , {@code capacidade.length()-1 > digitos }
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
        StringValidador.validaTamanhoExato(string, 54, info);
    }

    public static void exatamente15N(final String string, final String info) {
        StringValidador.validaTamanhoExato(string, 15, info);
        StringValidador.apenasNumerico(string, info);
    }

    public static void exatamente11N(final String string, final String info) {
        StringValidador.apenasNumerico(string, info);
        StringValidador.validaTamanhoExato(string, 11, info);
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

    public static void equals(final String test, final String tested) {
        if (!StringUtils.equals(test, tested)) {
            throw new IllegalStateException(String.format("Valor('%s') nao corresponde com o padrao('%s')", tested, test));
        }
    }
}
