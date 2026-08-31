package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoObservacaoTest {

    @Test
    public void naoDevePermitirConteudoCampoComTamanhoNaoPermitido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoObservacao().setConteudoCampo("");
                Assertions.fail("Validacao nao funcionou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoObservacao().setConteudoCampo("ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo1");
            }
            Assertions.fail("Validacao nao funcionou");
        });
    }

    @Test
    public void naoDevePermitirIdentificacaoCampoComTamanhoNaoPermitido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoObservacao().setIdentificacaoCampo("");
                Assertions.fail("Validacao nao funcionou");
            } catch (final IllegalStateException e) {
                new NFNotaInfoObservacao().setIdentificacaoCampo("kRkrK4FGWOn27RSjYjMB1");
            }
            Assertions.fail("Validacao nao funcionou");
        });
    }

    @Test
    public void naoDevePermitirConteudoCampoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoObservacao obsFisco = new NFNotaInfoObservacao();
            obsFisco.setIdentificacaoCampo("kRkrK4FGWOn27RSjYjMB");
            obsFisco.toString();
        });
    }

    @Test
    public void naoDevePermitirIdentificacaoCampoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoObservacao obsFisco = new NFNotaInfoObservacao();
            obsFisco.setConteudoCampo("ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo");
            obsFisco.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoObservacao xCampo=\"kRkrK4FGWOn27RSjYjMB\"><xTexto>ML73tIXUvsLEMijwgwjHVRfpP6upxiuipvEcQcSp8fpV402GXe3nXEHXJKJo</xTexto></NFNotaInfoObservacao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoObservacao().toString());
    }
}