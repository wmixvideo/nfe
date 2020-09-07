package com.fincatto.documentofiscal.validadores;

import java.util.List;

public abstract class DFListValidador {

    public static <E> void tamanho2(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 2, info);
    }

    public static <E> void tamanho3(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 3, info);
    }

    public static <E> void tamanho10(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 10, info);
    }

    public static <E> void tamanho31Obrigatorio(final List<E> lista, final String info) {
        DFListValidador.validaEstadoDaLista(lista, info);
        DFListValidador.validaTamanho(lista, 31, info);
    }

    public static <E> void tamanho120(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 120, info);
    }

    public static <E> void tamanho990(final List<E> lista, final String info) {
        DFListValidador.validaEstadoDaLista(lista, info);
        DFListValidador.validaTamanho(lista, 990, info);
    }

    public static <E> void tamanho500(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 500, info);
    }

    public static <E> void tamanho5000(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 5000, info);
    }

    public static <E> void tamanho5(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 5000, info);
    }

    public static <E> void tamanho100(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 100, info);
    }

    public static <E> void tamanho50(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 50, info);
    }

    public static <E> void tamanho20(final List<E> lista, final String info) {
        DFListValidador.validaTamanho(lista, 20, info);
    }

    public static <E> List<E> validaListaObrigatoria(final List<E> lista, final String info) {
        validaEstadoDaLista(lista, info);
        return lista;
    }

    public static <E> List<E> validaListaObrigatoria(final List<E> lista, final int tamanho, final String info) {
        validaEstadoDaLista(lista, info);
        validaTamanho(lista, tamanho, info);
        return lista;
    }

    public static <E> List<E> validaListaNaoObrigatoria(final List<E> lista, final int tamanho, final String info) {
        validaTamanho(lista, tamanho, info);
        return lista;
    }

    private static <E> void validaEstadoDaLista(final List<E> lista, final String info) {
        if (lista != null && lista.isEmpty()) {
            throw new IllegalStateException(String.format("Lista %s obrigatoria esta vazia", info));
        }
    }

    private static <E> void validaTamanho(final List<E> lista, final int tamanho, final String info) {
        if (lista != null && lista.size() > tamanho) {
            throw new IllegalStateException(String.format("Lista %s de tamanho %s extrapolou o tamanho maximo de [%s]", info, lista.size(), tamanho));
        }
    }
}