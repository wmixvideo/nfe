package com.fincatto.nfe310.validadores;

import java.util.List;

import com.fincatto.nfe310.classes.nota.NFNotaInfoReboque;

public class ListValidador {

    private ListValidador() {
    }

    public static <E> void tamanho10(final List<E> lista, final String info) {
        ListValidador.validaTamanho(lista, 10, info);
    }

    public static <E> void tamanho31Obrigatorio(final List<E> lista, final String info) {
        ListValidador.validaEstadoDaLista(lista, info);
        ListValidador.validaTamanho(lista, 31, info);
    }

    public static <E> void tamanho120(final List<E> lista, final String info) {
        ListValidador.validaTamanho(lista, 120, info);
    }

    public static void tamanho5(final List<NFNotaInfoReboque> lista, final String info) {
        ListValidador.validaTamanho(lista, 5, info);
    }

    public static <E> void tamanho990(final List<E> lista, final String info) {
        ListValidador.validaEstadoDaLista(lista, info);
        ListValidador.validaTamanho(lista, 990, info);
    }

    public static <E> void tamanho500(final List<E> lista, final String info) {
        ListValidador.validaTamanho(lista, 500, info);
    }

    public static <E> void tamanho5000(final List<E> lista, final String info) {
        ListValidador.validaTamanho(lista, 5000, info);
    }

    public static <E> void tamanho100(final List<E> lista, final String info) {
        ListValidador.validaTamanho(lista, 100, info);
    }

    public static <E> void tamanho50(final List<E> lista, final String info) {
        ListValidador.validaTamanho(lista, 50, info);
    }

    public static <E> void tamanho20(final List<E> lista, final String info) {
        ListValidador.validaTamanho(lista, 20, info);
    }

    private static <E> void validaEstadoDaLista(final List<E> lista, final String info) {
        if (lista.isEmpty()) {
            throw new IllegalStateException(String.format("Lista %s obrigatoria esta vazia", info));
        }
    }

    private static <E> void validaTamanho(final List<E> lista, final int tamanho, final String info) {
        if (lista.size() > tamanho) {
            throw new IllegalStateException(String.format("Lista %s de tamanho %s extrapolou o tamanho maximo de [%s]", info, lista.size(), tamanho));
        }
    }

}