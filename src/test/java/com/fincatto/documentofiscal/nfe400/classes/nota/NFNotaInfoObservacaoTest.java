package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFNotaInfoObservacaoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirConteudoCampoComTamanhoNaoPermitido() {
        try {
            new NFNotaInfoObservacao().setConteudoCampo("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoObservacao().setConteudoCampo("ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo1");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificacaoCampoComTamanhoNaoPermitido() {
        try {
            new NFNotaInfoObservacao().setIdentificacaoCampo("");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            new NFNotaInfoObservacao().setIdentificacaoCampo("kRkrK4FGWOn27RSjYjMB1");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirConteudoCampoNulo() {
        final NFNotaInfoObservacao obsFisco = new NFNotaInfoObservacao();
        obsFisco.setIdentificacaoCampo("kRkrK4FGWOn27RSjYjMB");
        obsFisco.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdentificacaoCampoNulo() {
        final NFNotaInfoObservacao obsFisco = new NFNotaInfoObservacao();
        obsFisco.setConteudoCampo("ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo");
        obsFisco.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoObservacao xCampo=\"kRkrK4FGWOn27RSjYjMB\"><xTexto>ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo</xTexto></NFNotaInfoObservacao>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoObservacao().toString());
    }
}