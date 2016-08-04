package com.fincatto.nfe.core.lote.envio;

import com.fincatto.nfe.core.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class NFLoteEnvioRetornoRecebimentoInfoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFLoteEnvioRetornoRecebimentoInfo><nRec>845e40545</nRec><tMed>430kfszodkgvre</tMed></NFLoteEnvioRetornoRecebimentoInfo>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFLoteEnvioRetornoRecebimentoInfo().toString());
    }
}