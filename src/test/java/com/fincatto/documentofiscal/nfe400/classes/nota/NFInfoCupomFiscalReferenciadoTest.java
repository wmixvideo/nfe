package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFInfoCupomFiscalReferenciadoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalComTamanhoInvalido() {
        try {
            new NFInfoCupomFiscalReferenciado().setModeloDocumentoFiscal("J");
        } catch (final IllegalStateException e) {
            new NFInfoCupomFiscalReferenciado().setModeloDocumentoFiscal("Je1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroContadorOrdemOperacaoComTamanhoInvalido() {
        try {
            new NFInfoCupomFiscalReferenciado().setNumeroContadorOrdemOperacao("NUQvJ");
        } catch (final IllegalStateException e) {
            new NFInfoCupomFiscalReferenciado().setNumeroContadorOrdemOperacao("NUQvJH1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroOrdemSequencialECFComTamanhoInvalido() {
        try {
            new NFInfoCupomFiscalReferenciado().setNumeroOrdemSequencialECF("a7");
        } catch (final IllegalStateException e) {
            new NFInfoCupomFiscalReferenciado().setNumeroOrdemSequencialECF("a712");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirModeloDocumentoFiscalNulo() {
        final NFInfoCupomFiscalReferenciado referenciado = new NFInfoCupomFiscalReferenciado();
        referenciado.setNumeroContadorOrdemOperacao("NUQvJH");
        referenciado.setNumeroOrdemSequencialECF("a71");
        referenciado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroContadorOrdemOperacaoNulo() {
        final NFInfoCupomFiscalReferenciado referenciado = new NFInfoCupomFiscalReferenciado();
        referenciado.setModeloDocumentoFiscal("A2");
        referenciado.setNumeroOrdemSequencialECF("a71");
        referenciado.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNumeroOrdemSequencialECFNulo() {
        final NFInfoCupomFiscalReferenciado referenciado = new NFInfoCupomFiscalReferenciado();
        referenciado.setModeloDocumentoFiscal("A2");
        referenciado.setNumeroContadorOrdemOperacao("NUQvJH");
        referenciado.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoCupomFiscalReferenciado><mod>55</mod><nECF>a71</nECF><nCOO>NUQvJH</nCOO></NFInfoCupomFiscalReferenciado>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoCupomFiscalReferenciado().toString());
    }
}