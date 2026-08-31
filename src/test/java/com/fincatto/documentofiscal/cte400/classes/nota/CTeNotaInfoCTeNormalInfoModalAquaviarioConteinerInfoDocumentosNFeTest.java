package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFeTest {

    @Test
    public void deveGerarXMLCorretamente() {
        final CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe infNFe =
            new CTeNotaInfoCTeNormalInfoModalAquaviarioConteinerInfoDocumentosNFe();
        infNFe.setChave("12345678901234567890123456789012345678901244");
        infNFe.setUnidadeRateada(BigDecimal.ONE);

        final String xml = infNFe.toString();
        Assertions.assertNotNull(xml);
        Assertions.assertTrue(xml.contains("infNFe"));
        Assertions.assertTrue(xml.contains("<chave>"));
    }
}

