package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoSolicNFFTest {

    @Test
    public void naoDevePermitirValorComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoSolicitacaoNFF nfInfoSolicNFF = new NFInfoSolicitacaoNFF();
            nfInfoSolicNFF.setSolicitacao("1");
            nfInfoSolicNFF.toString();
        });
    }


    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFInfoSolicitacaoNFF nfInfoSolicNFF = new NFInfoSolicitacaoNFF();
        nfInfoSolicNFF.setSolicitacao("1234567890");

        final String xmlEsperado = "<infSolicNFF><xSolic>1234567890</xSolic></infSolicNFF>";
        Assertions.assertEquals(xmlEsperado, nfInfoSolicNFF.toString());
    }
}