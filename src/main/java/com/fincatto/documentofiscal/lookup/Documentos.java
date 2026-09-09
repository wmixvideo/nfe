package com.fincatto.documentofiscal.lookup;

/**
 * Rotinas de normalização de documentos e textos usadas pelo pacote de consulta.
 */
final class Documentos {

    private Documentos() {
    }

    /**
     * Remove tudo que não for dígito.
     *
     * @param valor texto de entrada, possivelmente nulo.
     * @return apenas os dígitos, ou string vazia quando a entrada é nula.
     */
    static String apenasDigitos(final String valor) {
        if (valor == null) {
            return "";
        }
        return valor.replaceAll("[^0-9]", "");
    }

    /**
     * Normaliza um CNPJ, que pode ser alfanumérico: remove separadores e coloca em
     * maiúsculas, preservando os 12 caracteres alfanuméricos da raiz e os 2 dígitos
     * verificadores.
     *
     * @param valor CNPJ de entrada, com ou sem máscara.
     * @return CNPJ normalizado, ou string vazia quando a entrada é nula.
     */
    static String normalizaCnpj(final String valor) {
        if (valor == null) {
            return "";
        }
        return valor.replaceAll("[^0-9A-Za-z]", "").toUpperCase();
    }

    /**
     * Recorta o texto para o tamanho máximo informado, preservando o conteúdo quando já
     * couber. Espaços nas pontas são removidos antes do recorte.
     *
     * @param valor  texto a ajustar, possivelmente nulo.
     * @param limite tamanho máximo.
     * @return texto ajustado, ou nulo quando a entrada é nula.
     */
    static String limita(final String valor, final int limite) {
        if (valor == null) {
            return null;
        }
        final String ajustado = valor.trim();
        if (ajustado.length() <= limite) {
            return ajustado;
        }
        return ajustado.substring(0, limite).trim();
    }

    /**
     * @return true quando o texto tem algum conteúdo além de espaços.
     */
    static boolean preenchido(final String valor) {
        return valor != null && !valor.trim().isEmpty();
    }
}
