package com.fincatto.documentofiscal.mdfe3.classes.nota;

import com.fincatto.documentofiscal.mdfe3.FabricaDeObjetosFakeMDFe;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Edivaldo Merlo Stens on 04/10/18.
 */
public class MDFInfoSeguroTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<seg xmlns=\"http://www.portalfiscal.inf.br/mdfe\">"
                + "<infResp>"
                + "<respSeg>2</respSeg>"
                + "<CNPJ>12345678901234</CNPJ>"
                + "</infResp>"
                + "<infSeg>"
                + "<xSeg>891726585917544010862180488469</xSeg>"
                + "<CNPJ>12345678901234</CNPJ>"
                + "</infSeg>"
                + "<nApol>12457898653245789865</nApol>"
                + "<nAver>1245789865322154879865325487986532154876</nAver>"
                + "<nAver>1245789865322154879865325487986532154877</nAver>"
                + "</seg>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeMDFe.getMDFInfoSeguro().toString());
    }
}
