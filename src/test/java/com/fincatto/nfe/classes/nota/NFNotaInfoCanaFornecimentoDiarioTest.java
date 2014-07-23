package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;

public class NFNotaInfoCanaFornecimentoDiarioTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDiaAcima31() {
        new NFNotaInfoCanaFornecimentoDiario().setDia(32);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirDiaMenor1() {
        new NFNotaInfoCanaFornecimentoDiario().setDia(0);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setQuantidade(null);
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalAnteriorNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setQuantidadeTotalAnterior(null);
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalGeralNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setQuantidadeTotalGeral(null);
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalMesNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setQuantidadeTotalMes(null);
        canaFornecimentoDiario.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCanaFornecimentoDiario dia=\"15\"><qtde>3</qtde><qTotMes>30</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer></NFNotaInfoCanaFornecimentoDiario>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario().toString());
    }
}