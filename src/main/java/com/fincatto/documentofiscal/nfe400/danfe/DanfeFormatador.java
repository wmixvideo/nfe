package com.fincatto.documentofiscal.nfe400.danfe;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Formatacoes de texto do DANFE (CNPJ/CPF, chave de acesso, valores, datas).
 * Todos os metodos aceitam null e devolvem string vazia.
 *
 * @author Marcos Lombardi de Andrade
 */
final class DanfeFormatador {

    private static final DateTimeFormatter DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Classe utilitaria, nao deve ser instanciada.
     */
    private DanfeFormatador() {
    }

    /**
     * Formata CNPJ (00.000.000/0000-00) ou CPF (000.000.000-00); outro valor e devolvido como esta.
     *
     * @param valor somente digitos
     * @return documento formatado
     */
    static String cnpjOuCpf(final String valor) {
        if (valor == null) {
            return "";
        }
        if (valor.matches("\\d{14}")) {
            return valor.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        }
        if (valor.matches("\\d{11}")) {
            return valor.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return valor;
    }

    /**
     * Formata a chave de acesso em grupos de quatro digitos separados por espaco.
     *
     * @param chave chave de acesso com 44 digitos
     * @return chave formatada
     */
    static String chaveAcesso(final String chave) {
        if (chave == null) {
            return "";
        }
        return chave.replaceAll("(.{4})(?=.)", "$1 ");
    }

    /**
     * Formata o numero da nota como "No 000.000.000".
     *
     * @param numero numero da nota
     * @return numero formatado
     */
    static String numeroNota(final String numero) {
        if (numero == null) {
            return "";
        }
        final String preenchido = String.format("%9s", numero).replace(' ', '0');
        return "N\u00ba " + preenchido.replaceAll("(\\d{3})(\\d{3})(\\d{3})", "$1.$2.$3");
    }

    /**
     * Formata a serie com tres digitos.
     *
     * @param serie serie da nota
     * @return serie com zeros a esquerda
     */
    static String serie(final String serie) {
        return serie == null ? "" : String.format("%3s", serie).replace(' ', '0');
    }

    /**
     * Converte o valor do XML (ponto decimal) para o formato brasileiro, mantendo as casas decimais.
     *
     * @param valor valor numerico do XML
     * @return valor com separador de milhar e virgula decimal
     */
    static String valor(final String valor) {
        if (valor == null) {
            return "";
        }
        if (!valor.matches("-?\\d+(\\.\\d+)?")) {
            return valor;
        }
        final boolean negativo = valor.startsWith("-");
        final String semSinal = negativo ? valor.substring(1) : valor;
        final int ponto = semSinal.indexOf('.');
        final String inteiros = ponto < 0 ? semSinal : semSinal.substring(0, ponto);
        final String decimais = ponto < 0 ? "" : "," + semSinal.substring(ponto + 1);
        return (negativo ? "-" : "") + inteiros.replaceAll("(\\d)(?=(\\d{3})+$)", "$1.") + decimais;
    }

    /**
     * Como {@link #valor(String)}, mas completa com zeros ate o minimo de casas decimais (ex.: "50" vira "50,00"); mais casas que o minimo sao mantidas.
     *
     * @param valor valor numerico do XML
     * @param casasMinimas minimo de casas decimais
     * @return valor com separador de milhar e virgula decimal
     */
    static String valor(final String valor, final int casasMinimas) {
        if (valor == null || !valor.matches("-?\\d+(\\.\\d+)?")) {
            return valor(valor);
        }
        final int casas = valor.contains(".") ? valor.length() - valor.indexOf('.') - 1 : 0;
        final StringBuilder completo = new StringBuilder(valor);
        if (casas == 0 && casasMinimas > 0) {
            completo.append('.');
        }
        for (int i = casas; i < casasMinimas; i++) {
            completo.append('0');
        }
        return valor(completo.toString());
    }

    /**
     * Formata a data como dd/MM/yyyy.
     *
     * @param data data e hora
     * @return data formatada
     */
    static String data(final ZonedDateTime data) {
        return data == null ? "" : DATA.format(data);
    }

    /**
     * Formata a hora como HH:mm:ss.
     *
     * @param data data e hora
     * @return hora formatada
     */
    static String hora(final ZonedDateTime data) {
        return data == null ? "" : HORA.format(data);
    }

    /**
     * Formata data e hora como dd/MM/yyyy HH:mm:ss.
     *
     * @param data data e hora
     * @return data e hora formatadas
     */
    static String dataHora(final ZonedDateTime data) {
        return data == null ? "" : data(data) + " " + hora(data);
    }

    /**
     * Formata data e hora sem fuso (usada na data de recebimento do protocolo).
     *
     * @param dataHora data e hora
     * @return data e hora formatadas
     */
    static String dataHoraLocal(final LocalDateTime dataHora) {
        return dataHora == null ? "" : DATA.format(dataHora) + " " + HORA.format(dataHora);
    }

    /**
     * Troca por espaco os caracteres de controle (como quebra de linha e tabulacao), que o PDF nao consegue desenhar.
     *
     * @param texto texto original
     * @return texto sem caracteres de controle
     */
    static String semCaracteresDeControle(final String texto) {
        if (texto == null) {
            return "";
        }
        final StringBuilder resultado = new StringBuilder();
        texto.codePoints().forEach(codigo -> resultado.appendCodePoint(Character.isISOControl(codigo) ? ' ' : codigo));
        return resultado.toString();
    }
}
