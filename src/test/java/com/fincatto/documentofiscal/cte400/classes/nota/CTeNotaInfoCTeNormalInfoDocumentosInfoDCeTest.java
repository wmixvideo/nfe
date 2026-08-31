package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoCTeNormalInfoDocumentosInfoDCeTest {

    @Test
    public void deveGerarXMLCorretamente() {
        final String retorno = "<infDCe xmlns=\"http://www.portalfiscal.inf.br/cte\"><chave>12345678901234567890123456789012345678901234</chave></infDCe>";
        Assertions.assertEquals(retorno, FabricaDeObjetosFake.getInfoDCe().toString());
    }
}

