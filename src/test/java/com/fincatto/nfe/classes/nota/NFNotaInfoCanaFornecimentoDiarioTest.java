package com.fincatto.nfe.classes.nota;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

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
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = NFNotaInfoCanaFornecimentoDiarioTest.getFake();
        canaFornecimentoDiario.setQuantidade(null);
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalAnteriorNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = NFNotaInfoCanaFornecimentoDiarioTest.getFake();
        canaFornecimentoDiario.setQuantidadeTotalAnterior(null);
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalGeralNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = NFNotaInfoCanaFornecimentoDiarioTest.getFake();
        canaFornecimentoDiario.setQuantidadeTotalGeral(null);
        canaFornecimentoDiario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQtdTotalMesNulo() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = NFNotaInfoCanaFornecimentoDiarioTest.getFake();
        canaFornecimentoDiario.setQuantidadeTotalMes(null);
        canaFornecimentoDiario.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = NFNotaInfoCanaFornecimentoDiarioTest.getFake();
        final String xmlEsperado = "<NFNotaInfoCanaFornecimentoDiario dia=\"15\"><qtde>3</qtde><qTotMes>30</qTotMes><qTotAnt>10</qTotAnt><qTotGer>80</qTotGer></NFNotaInfoCanaFornecimentoDiario>";
        Assert.assertEquals(xmlEsperado, canaFornecimentoDiario.toString());
    }

    public static NFNotaInfoCanaFornecimentoDiario getFake() {
        final NFNotaInfoCanaFornecimentoDiario canaFornecimentoDiario = new NFNotaInfoCanaFornecimentoDiario();
        canaFornecimentoDiario.setDia(15);
        canaFornecimentoDiario.setQuantidade(new BigInteger("3"));
        canaFornecimentoDiario.setQuantidadeTotalAnterior(new BigInteger("10"));
        canaFornecimentoDiario.setQuantidadeTotalGeral(new BigInteger("80"));
        canaFornecimentoDiario.setQuantidadeTotalMes(new BigInteger("30"));
        return canaFornecimentoDiario;
    }
}