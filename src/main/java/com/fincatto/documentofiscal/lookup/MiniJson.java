package com.fincatto.documentofiscal.lookup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Analisador JSON minimalista, suficiente para interpretar as respostas da API
 * cpfcnpj.com.br sem trazer nenhuma dependência nova ao projeto (o projeto usa
 * simple-xml para XML e não possui biblioteca JSON dedicada).
 *
 * <p>Suporta objetos, listas, textos (com escapes padrão e {@code \\uXXXX}), números,
 * booleanos e nulo. Objetos viram {@link Map}, listas viram {@link List}, números
 * inteiros viram {@link Long} e fracionários viram {@link Double}.</p>
 */
final class MiniJson {

    private static final int PROFUNDIDADE_MAXIMA = 64;

    private final String texto;
    private int posicao;
    private int profundidade;

    private MiniJson(final String texto) {
        this.texto = texto;
    }

    static Object parse(final String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("Conteúdo JSON nulo");
        }
        final MiniJson leitor = new MiniJson(texto);
        leitor.ignorarEspacos();
        final Object valor = leitor.lerValor();
        leitor.ignorarEspacos();
        if (leitor.posicao < leitor.texto.length()) {
            throw new IllegalArgumentException("Conteúdo extra após o JSON na posição " + leitor.posicao);
        }
        return valor;
    }

    private Object lerValor() {
        ignorarEspacos();
        final char atual = verChar();
        switch (atual) {
            case '{':
                return lerObjeto();
            case '[':
                return lerLista();
            case '"':
                return lerTexto();
            case 't':
            case 'f':
                return lerBooleano();
            case 'n':
                return lerNulo();
            default:
                return lerNumero();
        }
    }

    private Map<String, Object> lerObjeto() {
        if (++this.profundidade > PROFUNDIDADE_MAXIMA) {
            throw new IllegalArgumentException("Aninhamento JSON acima do limite de " + PROFUNDIDADE_MAXIMA + " níveis");
        }
        final Map<String, Object> objeto = new LinkedHashMap<>();
        this.posicao++;
        ignorarEspacos();
        if (verChar() == '}') {
            this.posicao++;
            this.profundidade--;
            return objeto;
        }
        while (true) {
            ignorarEspacos();
            if (verChar() != '"') {
                throw new IllegalArgumentException("Chave de objeto esperada na posição " + this.posicao);
            }
            final String chave = lerTexto();
            ignorarEspacos();
            if (verChar() != ':') {
                throw new IllegalArgumentException("Esperado ':' na posição " + this.posicao);
            }
            this.posicao++;
            objeto.put(chave, lerValor());
            ignorarEspacos();
            final char separador = verChar();
            if (separador == ',') {
                this.posicao++;
                continue;
            }
            if (separador == '}') {
                this.posicao++;
                break;
            }
            throw new IllegalArgumentException("Esperado ',' ou '}' na posição " + this.posicao);
        }
        this.profundidade--;
        return objeto;
    }

    private List<Object> lerLista() {
        if (++this.profundidade > PROFUNDIDADE_MAXIMA) {
            throw new IllegalArgumentException("Aninhamento JSON acima do limite de " + PROFUNDIDADE_MAXIMA + " níveis");
        }
        final List<Object> lista = new ArrayList<>();
        this.posicao++;
        ignorarEspacos();
        if (verChar() == ']') {
            this.posicao++;
            this.profundidade--;
            return lista;
        }
        while (true) {
            lista.add(lerValor());
            ignorarEspacos();
            final char separador = verChar();
            if (separador == ',') {
                this.posicao++;
                continue;
            }
            if (separador == ']') {
                this.posicao++;
                break;
            }
            throw new IllegalArgumentException("Esperado ',' ou ']' na posição " + this.posicao);
        }
        this.profundidade--;
        return lista;
    }

    private String lerTexto() {
        final StringBuilder construtor = new StringBuilder();
        this.posicao++;
        while (this.posicao < this.texto.length()) {
            final char caractere = this.texto.charAt(this.posicao++);
            if (caractere == '"') {
                return construtor.toString();
            }
            if (caractere == '\\') {
                if (this.posicao >= this.texto.length()) {
                    break;
                }
                final char escape = this.texto.charAt(this.posicao++);
                switch (escape) {
                    case '"':
                        construtor.append('"');
                        break;
                    case '\\':
                        construtor.append('\\');
                        break;
                    case '/':
                        construtor.append('/');
                        break;
                    case 'b':
                        construtor.append('\b');
                        break;
                    case 'f':
                        construtor.append('\f');
                        break;
                    case 'n':
                        construtor.append('\n');
                        break;
                    case 'r':
                        construtor.append('\r');
                        break;
                    case 't':
                        construtor.append('\t');
                        break;
                    case 'u':
                        if (this.posicao + 4 > this.texto.length()) {
                            throw new IllegalArgumentException("Escape unicode incompleto na posição " + this.posicao);
                        }
                        final String hexadecimal = this.texto.substring(this.posicao, this.posicao + 4);
                        construtor.append((char) Integer.parseInt(hexadecimal, 16));
                        this.posicao += 4;
                        break;
                    default:
                        throw new IllegalArgumentException("Escape inválido \\" + escape);
                }
            } else {
                construtor.append(caractere);
            }
        }
        throw new IllegalArgumentException("Texto JSON não terminado");
    }

    private Object lerNumero() {
        final int inicio = this.posicao;
        boolean fracionario = false;
        if (verChar() == '-') {
            this.posicao++;
        }
        while (this.posicao < this.texto.length()) {
            final char caractere = this.texto.charAt(this.posicao);
            if (caractere >= '0' && caractere <= '9') {
                this.posicao++;
            } else if (caractere == '.' || caractere == 'e' || caractere == 'E' || caractere == '+' || caractere == '-') {
                if (caractere == '.' || caractere == 'e' || caractere == 'E') {
                    fracionario = true;
                }
                this.posicao++;
            } else {
                break;
            }
        }
        final String bruto = this.texto.substring(inicio, this.posicao);
        if (bruto.isEmpty() || "-".equals(bruto)) {
            throw new IllegalArgumentException("Número inválido na posição " + inicio);
        }
        if (!fracionario) {
            try {
                return Long.parseLong(bruto);
            } catch (final NumberFormatException e) {
                return Double.parseDouble(bruto);
            }
        }
        return Double.parseDouble(bruto);
    }

    private Boolean lerBooleano() {
        if (this.texto.startsWith("true", this.posicao)) {
            this.posicao += 4;
            return Boolean.TRUE;
        }
        if (this.texto.startsWith("false", this.posicao)) {
            this.posicao += 5;
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException("Booleano inválido na posição " + this.posicao);
    }

    private Object lerNulo() {
        if (this.texto.startsWith("null", this.posicao)) {
            this.posicao += 4;
            return null;
        }
        throw new IllegalArgumentException("Token inválido na posição " + this.posicao);
    }

    private char verChar() {
        if (this.posicao >= this.texto.length()) {
            throw new IllegalArgumentException("Fim inesperado do JSON");
        }
        return this.texto.charAt(this.posicao);
    }

    private void ignorarEspacos() {
        while (this.posicao < this.texto.length()) {
            final char caractere = this.texto.charAt(this.posicao);
            if (caractere == ' ' || caractere == '\t' || caractere == '\n' || caractere == '\r') {
                this.posicao++;
            } else {
                break;
            }
        }
    }
}
