package com.fincatto.nfe.validadores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListValidadorTest {

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoExtrapoleTamanho10() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho10(lista);
    }

    @Test
    public void deveValidarListaCom10Itens() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho10(lista);
    }

    @Test
    public void deveValidarListaCom31ItensObrigatorio() {
        ListValidador.tamanho31Obrigatorio(Arrays.asList(new Object[] { new Object() }));
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho31Obrigatorio(lista);
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo() {
        try {
            ListValidador.tamanho31Obrigatorio(Arrays.asList(new Object[] {}));
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            final List<Object> lista = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                lista.add(new Object());
            }
            ListValidador.tamanho31Obrigatorio(lista);
        }
        Assert.fail("Validacao nao funcionou");
    }
}