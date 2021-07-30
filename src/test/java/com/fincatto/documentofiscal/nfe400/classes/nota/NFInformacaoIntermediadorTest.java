package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFInformacaoIntermediadorTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorCnpjNulo() {
        final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
        infIntermed.setIdCadIntTran("123");
        infIntermed.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdCadIntTranNulo() {
        final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
        infIntermed.setCnpj("05064671000130");
        infIntermed.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirIdCadIntTranInvalido() {
    	 final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
         infIntermed.setCnpj("05064671000130");
         infIntermed.setIdCadIntTran("1");
         infIntermed.toString();
    }
    
    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCnpjInvalido() {
    	 final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
    	 infIntermed.setIdCadIntTran("123");
         infIntermed.setCnpj("x");
         infIntermed.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInformacaoIntermediador><CNPJ>12345678901234</CNPJ><idCadIntTran>123456789012345678901234567890123456789012345678901234567890</idCadIntTran></NFInformacaoIntermediador>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInformacaoIntermediador().toString());
    }
}