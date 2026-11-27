package com.fincatto.documentofiscal.cte400.classes.simp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

public class CTeNotaSimpInfoDetTest {

    private static CTeNotaSimpInfoDet getDet() {
        final CTeNotaSimpInfoDet det = new CTeNotaSimpInfoDet();
        det.setNItem("1");
        det.setCMunIni("4205407");
        det.setXMunIni("Floriano");
        det.setCMunFim("4205407");
        det.setXMunFim("Floriano");
        det.setVPrest(new BigDecimal("100"));
        det.setVRec(new BigDecimal("100"));
        final CTeNotaSimpInfoDetInfNFe nfe = new CTeNotaSimpInfoDetInfNFe();
        nfe.setChNFe("12345678901234567890123456789012345678901234");
        det.setInfNFe(Collections.singletonList(nfe));
        return det;
    }

    @Test
    public void naoDeveGerarVPrestLiqNemIBSCBSQuandoNulos() {
        final String xml = getDet().toString();
        Assertions.assertFalse(xml.contains("vPrestLiq"), xml);
        Assertions.assertFalse(xml.contains("IBSCBS"), xml);
    }

    @Test
    public void vPrestLiqNaoDeveExtrapolarTamanho() {
        final CTeNotaSimpInfoDet det = new CTeNotaSimpInfoDet();
        Assertions.assertThrows(NumberFormatException.class, () -> det.setVPrestLiq(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> det.setVPrestLiq(new BigDecimal("1.123")));
    }
}
