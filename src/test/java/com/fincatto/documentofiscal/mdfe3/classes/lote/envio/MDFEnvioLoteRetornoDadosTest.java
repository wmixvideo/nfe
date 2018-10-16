package com.fincatto.documentofiscal.mdfe3.classes.lote.envio;

import com.fincatto.documentofiscal.mdfe3.FabricaDeObjetosFakeMDFe;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edivaldo Merlo Stens on 06/10/18.
 */
public class MDFEnvioLoteRetornoDadosTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<MDFEnvioLoteRetornoDados><nRec>845e40545</nRec><tMed>430kfszodkgvre</tMed></MDFEnvioLoteRetornoDados>";
        System.err.println(FabricaDeObjetosFakeMDFe.getMDFEnvioLoteRetornoDados().toString());        
//Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeMDFe.getMDFEnvioLoteRetornoDados().toString());
    }
}
