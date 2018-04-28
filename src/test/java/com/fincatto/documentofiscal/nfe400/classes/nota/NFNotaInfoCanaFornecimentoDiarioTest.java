package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

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
        canaFornecimentoDiario.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCanaFornecimentoDiario dia=\"15\"><qtde>3</qtde></NFNotaInfoCanaFornecimentoDiario>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCanaFornecimentoDiario().toString());
    }
}