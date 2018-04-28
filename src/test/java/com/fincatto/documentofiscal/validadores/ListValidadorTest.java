package com.fincatto.documentofiscal.validadores;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListValidadorTest {

    @Test
    public void deveValidarTamanhoDasListas(){
        ListValidador.tamanho2(gerarList(2), "");
        ListValidador.tamanho3(gerarList(3), "");
        ListValidador.tamanho5(gerarList(5), "");
        ListValidador.tamanho10(gerarList(10), "");
        ListValidador.tamanho20(gerarList(20), "");
        ListValidador.tamanho50(gerarList(50), "");
        ListValidador.tamanho100(gerarList(100), "");
        ListValidador.tamanho120(gerarList(120), "");
        ListValidador.tamanho500(gerarList(500), "");
        ListValidador.tamanho990(gerarList(990), "");
        ListValidador.tamanho5000(gerarList(5000), "");
        ListValidador.tamanho31Obrigatorio(gerarList(31), "");
        ListValidador.validaListaObrigatoria(gerarList(1), "");
        ListValidador.validaListaObrigatoria(gerarList(2), 2, "");
        ListValidador.validaListaNaoObrigatoria(new ArrayList<>(), 2, "");
    }

    private List<Integer> gerarList(int quantidade){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i <quantidade; i++) {
            lista.add(i);
        }
        return lista;
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoExtrapoleTamanho10() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho10(lista, "");
    }

    @Test
    public void deveValidarListaCom10Itens() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho10(lista, "");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoExtrapoleTamanho120() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 121; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho120(lista, "");
    }

    @Test
    public void deveValidarListaCom120Itens() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho120(lista, "");
    }

    @Test
    public void deveValidarListaCom31ItensObrigatorio() {
        ListValidador.tamanho31Obrigatorio(Collections.singletonList(new Object()), "");
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            lista.add(new Object());
        }
        ListValidador.tamanho31Obrigatorio(lista, "");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo() {
        try {
            ListValidador.tamanho31Obrigatorio(Collections.emptyList(), "");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            final List<Object> lista = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                lista.add(new Object());
            }
            ListValidador.tamanho31Obrigatorio(lista, "");
        }
        Assert.fail("Validacao nao funcionou");
    }
}
