package com.fincatto.documentofiscal.utils;

import java.util.Arrays;
import java.util.List;

public abstract class DFUtils {
    private static final List<String> CPFS_INVALIDOS = Arrays.asList("00000000000", "11111111111", "22222222222",
            "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999",
            "12345678909"
    );

    /**
     * Verifica se o CNPJ informado eh valido. <br>
     * Nao verifica o tamanho e presume que este seja de 14 digidos e somente numeros.
     *
     * @param cnpj CNPJ a ser validado.
     * @return Se o CNPJ informado eh valido ou nao.
     */
    public static boolean isCnpjValido(final String cnpj) {
        if (cnpj == null || !cnpj.matches("^[0-9]{14}$")) {
            return false;
        }

        // verifica por falsos positivos
        if (cnpj.equalsIgnoreCase("00000000000000")) {
            return false;
        }

        String cnpjCalculado = cnpj.substring(0, 12);
        final char[] chrCNPJ = cnpj.toCharArray();

        // primeira parte
        int soma = 0;
        for (int i = 0; i < 4; i++) {
            if (((chrCNPJ[i] - 48) >= 0) && ((chrCNPJ[i] - 48) <= 9)) {
                soma += (chrCNPJ[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (((chrCNPJ[i + 4] - 48) >= 0) && ((chrCNPJ[i + 4] - 48) <= 9)) {
                soma += (chrCNPJ[i + 4] - 48) * (10 - (i + 1));
            }
        }
        int dig = 11 - (soma % 11);
        cnpjCalculado += (dig == 10) || (dig == 11) ? "0" : Integer.toString(dig);

        // segunda parte
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (((chrCNPJ[i] - 48) >= 0) && ((chrCNPJ[i] - 48) <= 9)) {
                soma += (chrCNPJ[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (((chrCNPJ[i + 5] - 48) >= 0) && ((chrCNPJ[i + 5] - 48) <= 9)) {
                soma += (chrCNPJ[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpjCalculado += (dig == 10) || (dig == 11) ? "0" : Integer.toString(dig);
        return cnpj.equals(cnpjCalculado);
    }

    /**
     * Verifica se o CPF informado eh valido. <br>
     * Nao verifica o tamanho e presume que este seja de 11 digidos e somente numeros.
     *
     * @param cpf CPF a ser validado.
     * @return Se o CPF informado eh valido ou nao.
     */
    public static boolean isCpfValido(final String cpf) {
        if (cpf == null || !cpf.matches("^[0-9]{11}$")) {
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
}
