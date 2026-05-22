package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFeTest {

    @Test
    public void deveGerarXMLCorretamente() {
        final CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe infNFe =
            new CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe();
        infNFe.setChave("12345678901234567890123456789012345678901244");
        infNFe.setUnidadeRateada(BigDecimal.ONE);

        final String xml = infNFe.toString();
        Assert.assertNotNull(xml);
        Assert.assertTrue(xml.contains("infNFe"));
        Assert.assertTrue(xml.contains("<chave>"));
    }
}

