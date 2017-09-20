package com.fincatto.documentofiscal.nfe310.classes.lote.envio;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;

public class NFLoteEnvioRetornoRecebimentoInfoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFLoteEnvioRetornoRecebimentoInfo><nRec>845e40545</nRec><tMed>430kfszodkgvre</tMed></NFLoteEnvioRetornoRecebimentoInfo>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFLoteEnvioRetornoRecebimentoInfo().toString());
    }
}