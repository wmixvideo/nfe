package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInformacaoIntermediadorTest {

    @Test
    public void naoDevePermitirValorCnpjNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
            infIntermed.setIdCadIntTran("123");
            infIntermed.toString();
        });
    }

    @Test
    public void naoDevePermitirIdCadIntTranNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
            infIntermed.setCnpj("05064671000130");
            infIntermed.toString();
        });
    }

    @Test
    public void naoDevePermitirIdCadIntTranInvalido() {
    	 Assertions.assertThrows(IllegalStateException.class, () -> {
    	 	 final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
    	 	 infIntermed.setCnpj("05064671000130");
    	 	 infIntermed.setIdCadIntTran("1");
    	 	 infIntermed.toString();
    	 });
    }
    
    @Test
    public void naoDevePermitirCnpjInvalido() {
    	 Assertions.assertThrows(IllegalStateException.class, () -> {
    	 	 final NFInformacaoIntermediador infIntermed = new NFInformacaoIntermediador();
    	 	 infIntermed.setIdCadIntTran("123");
    	 	 infIntermed.setCnpj("x");
    	 	 infIntermed.toString();
    	 });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInformacaoIntermediador><CNPJ>12345678901234</CNPJ><idCadIntTran>123456789012345678901234567890123456789012345678901234567890</idCadIntTran></NFInformacaoIntermediador>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInformacaoIntermediador().toString());
    }
}