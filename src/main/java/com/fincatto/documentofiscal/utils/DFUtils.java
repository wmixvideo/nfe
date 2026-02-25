package com.fincatto.documentofiscal.utils;

import java.util.List;
import java.util.regex.Pattern;

public abstract class DFUtils {
    private static final Pattern SOMENTE_NUMEROS = Pattern.compile("\\d+");
    private static final Pattern CNPJ_PATTERN = Pattern.compile("^[0-9A-Z]{12}[0-9]{2}$");
    private static final Pattern CPF_PATTERN = Pattern.compile("^[0-9]{11}$");

    private static final List<String> CPFS_INVALIDOS = List.of("00000000000", "11111111111", "22222222222",
            "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999",
            "12345678909");

    /**
     * Verifica se o CNPJ informado eh valido. <br>
     * Nao verifica o tamanho e presume que este seja de 14 digidos e somente numeros.
     *
     * @param cnpj CNPJ a ser validado.
     * @return Se o CNPJ informado eh valido ou nao.
     */
    public static boolean isCnpjValido(final String cnpj) {
        if (cnpj == null || !CNPJ_PATTERN.matcher(cnpj.toUpperCase()).matches()) {
            return false;
        }

        final String cnpjNormalizado = cnpj.toUpperCase();
        if (cnpjNormalizado.chars().distinct().count() == 1) {
            return false;
        }

        final int primeiroDigito = calcularDigitoVerificadorCnpj(cnpjNormalizado, 12);
        final int segundoDigito = calcularDigitoVerificadorCnpj(cnpjNormalizado, 13);

        return primeiroDigito == Character.getNumericValue(cnpjNormalizado.charAt(12))
                && segundoDigito == Character.getNumericValue(cnpjNormalizado.charAt(13));
    }

    private static int calcularDigitoVerificadorCnpj(final String cnpj, final int quantidadePosicoes) {
        int soma = 0;
        int peso = 2;
        for (int i = quantidadePosicoes - 1; i >= 0; i--) {
            final int valor = cnpj.charAt(i) - 48;
            soma += valor * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }
        final int resto = soma % 11;

        return (resto < 2) ? 0 : 11 - resto;
    }

    /**
     * Verifica se o CPF informado eh valido. <br>
     * Nao verifica o tamanho e presume que este seja de 11 digidos e somente numeros.
     *
     * @param cpf CPF a ser validado.
     * @return Se o CPF informado eh valido ou nao.
     */
    public static boolean isCpfValido(final String cpf) {
        if (cpf == null || !CPF_PATTERN.matcher(cpf).matches()) {
            return false;
        }

        // verifica por falsos positivos
        if (CPFS_INVALIDOS.contains(cpf)) {
            return false;
        }

        int d1 = 0, d2 = 0;
        for (int i = 1; i < 10; i++) {
            final int digitoCPF = Integer.parseInt(cpf.substring(i - 1, i));

            // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante
            d1 += (11 - i) * digitoCPF;

            // para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior
            d2 += (12 - i) * digitoCPF;
        }

        // primeiro resto da divisao por 11
        int resto = d1 % 11;

        // se o resultado for 0 ou 1 o digito eh 0 caso contrario o digito eh 11 menos o resultado anterior
        final int digito1 = resto < 2 ? 0 : 11 - resto;

        // segundo resto da divisao por 11
        resto = (d2 + (2 * digito1)) % 11;
        // se o resultado for 0 ou 1 o digito eh 0 caso contrario o digito eh 11 menos o resultado anterior
        final int digito2 = resto < 2 ? 0 : 11 - resto;

        // digito verificador do CPF que estah sendo validado
        final String nDigVerific = cpf.substring(cpf.length() - 2);

        // concatenando o primeiro resto com o segundo
        final String nDigResult = String.valueOf(digito1) + digito2;

        // comparar o digito verificador do cpf com o primeiro resto + o segundo resto
        return nDigVerific.equals(nDigResult);
    }

    /**
     * Indica se a String informada é formada por somente caracteres numericos.
     * @param str String a ser verificada
     * @return Se a String é numerica.
     */
    public static boolean isNumerico(final String str) {
        return str != null && SOMENTE_NUMEROS.matcher(str).matches();
    }
}
