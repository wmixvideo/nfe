package com.fincatto.nfe.validadores;

import java.text.MessageFormat;
import java.util.List;

public class ListValidador {

    public static <E> void tamanho10(final List<E> lista) {
        ListValidador.validaTamanho(lista, 10);
    }

    public static <E> void tamanho31Obrigatorio(final List<E> lista) {
        ListValidador.validaEstadoDaLista(lista);
        ListValidador.validaTamanho(lista, 31);
    }

    public static <E> void tamanho120(final List<E> lista) {
        ListValidador.validaTamanho(lista, 120);
    }

    private static <E> void validaEstadoDaLista(final List<E> lista) {
        if (lista.isEmpty()) {
            throw new IllegalStateException("Lista obrigatoria esta vazia");
        }
    }

    private static <E> void validaTamanho(final List<E> lista, final int tamanho) {
        if (lista.size() > tamanho) {
            throw new IllegalStateException(MessageFormat.format("Lista extrapolou o tamanho [{0}]", tamanho));
        }
    }
}