package com.fincatto.documentofiscal.validadores;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFListValidadorTest {

    @Test
    public void deveValidarTamanhoDasListas(){
        DFListValidador.tamanho2(gerarList(2), "");
        DFListValidador.tamanho3(gerarList(3), "");
        DFListValidador.tamanho5(gerarList(5), "");
        DFListValidador.tamanho10(gerarList(10), "");
        DFListValidador.tamanho20(gerarList(20), "");
        DFListValidador.tamanho50(gerarList(50), "");
        DFListValidador.tamanho100(gerarList(100), "");
        DFListValidador.tamanho120(gerarList(120), "");
        DFListValidador.tamanho500(gerarList(500), "");
        DFListValidador.tamanho990(gerarList(990), "");
        DFListValidador.tamanho5000(gerarList(5000), "");
        DFListValidador.tamanho31Obrigatorio(gerarList(31), "");
        DFListValidador.validaListaObrigatoria(gerarList(1), "");
        DFListValidador.validaListaObrigatoria(gerarList(2), 2, "");
        DFListValidador.validaListaNaoObrigatoria(new ArrayList<>(), 2, "");
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
        DFListValidador.tamanho10(lista, "");
    }

    @Test
    public void deveValidarListaCom10Itens() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(new Object());
        }
        DFListValidador.tamanho10(lista, "");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoExtrapoleTamanho120() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 121; i++) {
            lista.add(new Object());
        }
        DFListValidador.tamanho120(lista, "");
    }

    @Test
    public void deveValidarListaCom120Itens() {
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            lista.add(new Object());
        }
        DFListValidador.tamanho120(lista, "");
    }

    @Test
    public void deveValidarListaCom31ItensObrigatorio() {
        DFListValidador.tamanho31Obrigatorio(Collections.singletonList(new Object()), "");
        final List<Object> lista = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            lista.add(new Object());
        }
        DFListValidador.tamanho31Obrigatorio(lista, "");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo() {
        try {
            DFListValidador.tamanho31Obrigatorio(Collections.emptyList(), "");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            final List<Object> lista = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                lista.add(new Object());
            }
            DFListValidador.tamanho31Obrigatorio(lista, "");
        }
        Assert.fail("Validacao nao funcionou");
    }
}
