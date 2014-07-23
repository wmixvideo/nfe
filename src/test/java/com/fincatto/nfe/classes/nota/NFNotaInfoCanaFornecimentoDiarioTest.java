package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

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

    @Test
    public void devePermitirDiaValido() {
        new NFNotaInfoCanaFornecimentoDiario().setDia(1);
        new NFNotaInfoCanaFornecimentoDiario().setDia(30);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setDia(15);
        canaFornecimentoDiario.setQuantidadeTotalAnterior(new BigDecimal("10"));
        canaFornecimentoDiario.setQuantidadeTotalGeral(new BigDecimal("80"));
        canaFornecimentoDiario.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalAnteriorNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setDia(15);
        canaFornecimentoDiario.setQuantidade(new BigDecimal("3"));
        canaFornecimentoDiario.setQuantidadeTotalGeral(new BigDecimal("80"));
        canaFornecimentoDiario.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalGeralNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setDia(15);
        canaFornecimentoDiario.setQuantidade(new BigDecimal("3"));
        canaFornecimentoDiario.setQuantidadeTotalAnterior(new BigDecimal("10"));
        canaFornecimentoDiario.setQuantidadeTotalMes(new BigDecimal("30.0000001"));
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalMesNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setDia(15);
        canaFornecimentoDiario.setQuantidade(new BigDecimal("3"));
        canaFornecimentoDiario.setQuantidadeTotalAnterior(new BigDecimal("10"));
        canaFornecimentoDiario.setQuantidadeTotalGeral(new BigDecimal("80"));
        canaFornecimentoDiario.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCanaFornecimentoDiario dia=\"15\"><qtde>3</qtde><qTotMes>30.0000001</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer></NFNotaInfoCanaFornecimentoDiario>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario().toString());
    }
}