package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoCupomFiscalReferenciadoTest {

    @Test
    public void naoDevePermitirModeloDocumentoFiscalComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFInfoCupomFiscalReferenciado().setModeloDocumentoFiscal("J");
            } catch (final IllegalStateException e) {
                new NFInfoCupomFiscalReferenciado().setModeloDocumentoFiscal("Je1");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroContadorOrdemOperacaoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFInfoCupomFiscalReferenciado().setNumeroContadorOrdemOperacao("NUQvJ");
            } catch (final IllegalStateException e) {
                new NFInfoCupomFiscalReferenciado().setNumeroContadorOrdemOperacao("NUQvJH1");
            }
        });
    }

    @Test
    public void naoDevePermitirNumeroOrdemSequencialECFComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFInfoCupomFiscalReferenciado().setNumeroOrdemSequencialECF("a7");
            } catch (final IllegalStateException e) {
                new NFInfoCupomFiscalReferenciado().setNumeroOrdemSequencialECF("a712");
            }
        });
    }

    @Test
    public void naoDevePermitirModeloDocumentoFiscalNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoCupomFiscalReferenciado referenciado = new NFInfoCupomFiscalReferenciado();
            referenciado.setNumeroContadorOrdemOperacao("NUQvJH");
            referenciado.setNumeroOrdemSequencialECF("a71");
            referenciado.toString();
        });
    }

    @Test
    public void naoDevePermitirNumeroContadorOrdemOperacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoCupomFiscalReferenciado referenciado = new NFInfoCupomFiscalReferenciado();
            referenciado.setModeloDocumentoFiscal("A2");
            referenciado.setNumeroOrdemSequencialECF("a71");
            referenciado.toString();
        });
    }

    @Test
    public void naoDevePermitirNumeroOrdemSequencialECFNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoCupomFiscalReferenciado referenciado = new NFInfoCupomFiscalReferenciado();
            referenciado.setModeloDocumentoFiscal("A2");
            referenciado.setNumeroContadorOrdemOperacao("NUQvJH");
            referenciado.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoCupomFiscalReferenciado><mod>55</mod><nECF>a71</nECF><nCOO>NUQvJH</nCOO></NFInfoCupomFiscalReferenciado>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoCupomFiscalReferenciado().toString());
    }
}