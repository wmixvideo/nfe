package com.fincatto.documentofiscal.nfe310.classes.lote.envio;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFLoteEnvioRetornoRecebimentoInfoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFLoteEnvioRetornoRecebimentoInfo><nRec>845e40545</nRec><tMed>430kfszodkgvre</tMed></NFLoteEnvioRetornoRecebimentoInfo>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFLoteEnvioRetornoRecebimentoInfo().toString());
    }
}