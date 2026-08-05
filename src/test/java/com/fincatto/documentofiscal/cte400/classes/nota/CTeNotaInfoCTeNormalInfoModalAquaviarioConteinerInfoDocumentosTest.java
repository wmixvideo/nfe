package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosTest {

    @Test
    public void deveGerarXMLCorretamente() {
        final CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos infDoc = 
            new CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentos();
        
        final CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe infNFe =
            new CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe();
        infNFe.setChave("12345678901234567890123456789012345678901244");
        
        infDoc.setInfoDocumentosNFe(Collections.singletonList(infNFe));
        
        final String xml = infDoc.toString();
        Assert.assertNotNull(xml);
        Assert.assertTrue(xml.contains("infNFe"));
        Assert.assertTrue(xml.contains("<chave>"));
    }
}

