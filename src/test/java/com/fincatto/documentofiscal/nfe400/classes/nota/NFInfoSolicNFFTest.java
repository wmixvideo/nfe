package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class NFInfoSolicNFFTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorComTamanhoInvalido() {
        final NFInfoSolicNFF nfInfoSolicNFF = new NFInfoSolicNFF();
        nfInfoSolicNFF.setXSolic("1");
        nfInfoSolicNFF.toString();
    }


    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFInfoSolicNFF nfInfoSolicNFF = new NFInfoSolicNFF();
        nfInfoSolicNFF.setXSolic("1234567890");

        final String xmlEsperado = "<NFInfoSolicNFF><xSolic>1234567890</xSolic></NFInfoSolicNFF>";
        Assert.assertEquals(xmlEsperado, nfInfoSolicNFF.toString());
    }
}