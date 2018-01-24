package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;

public class CTeNotaInfoCTeNormalInfoDocumentosInfoNFeTest {

    @Test
    public void deveGerarXMLCorretamente() {
        final String retorno = "<infNFe xmlns=\"http://www.portalfiscal.inf.br/cte\"><chave>12345678901234567890123456789012345678901234</chave><dPrev>2018-01-22</dPrev><infUnidCarga><tpUnidCarga>3</tpUnidCarga><idUnidCarga>IDE</idUnidCarga><qtdRat>1.00</qtdRat></infUnidCarga></infNFe>";
        Assert.assertEquals(retorno, FabricaDeObjetosFake.getInfoNFe().toString());
    }
}