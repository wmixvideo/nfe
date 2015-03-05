package com.fincatto.nfe310.validadores;

import java.util.List;

import com.fincatto.nfe310.classes.nota.NFNotaInfoReboque;

public class ListValidador {

    private ListValidador() {
    }

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

    public static void tamanho5(final List<NFNotaInfoReboque> lista) {
        ListValidador.validaTamanho(lista, 5);
    }

    public static <E> void tamanho990(final List<E> lista) {
        ListValidador.validaEstadoDaLista(lista);
        ListValidador.validaTamanho(lista, 990);
    }

    public static <E> void tamanho500(final List<E> lista) {
        ListValidador.validaTamanho(lista, 500);
    }

    public static <E> void tamanho5000(final List<E> lista) {
        ListValidador.validaTamanho(lista, 5000);
    }

    public static <E> void tamanho100(final List<E> lista) {
        ListValidador.validaTamanho(lista, 100);
    }

    public static <E> void tamanho50(final List<E> lista) {
        ListValidador.validaTamanho(lista, 50);
    }

    public static <E> void tamanho20(final List<E> lista) {
        ListValidador.validaTamanho(lista, 20);
    }

    private static <E> void validaEstadoDaLista(final List<E> lista) {
        if (lista.isEmpty()) {
            throw new IllegalStateException("Lista obrigatoria esta vazia");
        }
    }

    private static <E> void validaTamanho(final List<E> lista, final int tamanho) {
        if (lista.size() > tamanho) {
            throw new IllegalStateException(String.format("Lista de tamanho %s extrapolou o tamanho maximo de [%s]", lista.size(), tamanho));
        }
    }

}