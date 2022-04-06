package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFInfoSolicNFFTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorComTamanhoInvalido() {
        final NFInfoSolicitacaoNFF nfInfoSolicNFF = new NFInfoSolicitacaoNFF();
        nfInfoSolicNFF.setSolicitacao("1");
        nfInfoSolicNFF.toString();
    }


    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFInfoSolicitacaoNFF nfInfoSolicNFF = new NFInfoSolicitacaoNFF();
        nfInfoSolicNFF.setSolicitacao("1234567890");

        final String xmlEsperado = "<infSolicNFF><xSolic>1234567890</xSolic></infSolicNFF>";
        Assert.assertEquals(xmlEsperado, nfInfoSolicNFF.toString());
    }
}