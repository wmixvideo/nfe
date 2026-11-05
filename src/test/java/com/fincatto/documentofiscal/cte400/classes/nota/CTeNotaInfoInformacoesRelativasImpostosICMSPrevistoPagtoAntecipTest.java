package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecipTest {

    @Test
    public void deveFormatarValorComDuasCasas() {
        final CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip grupo = new CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip();
        grupo.setValorICMSPrevisto(new BigDecimal("150.5"));
        Assertions.assertEquals("150.50", grupo.getValorICMSPrevisto());
    }

    @Test
    public void deveGerarXMLCorretamente() {
        final CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip grupo = new CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip();
        grupo.setValorICMSPrevisto(new BigDecimal("150.5"));
        Assertions.assertEquals("<gICMSPrevistoPagtoAntecip><vICMSPrevisto>150.50</vICMSPrevisto></gICMSPrevistoPagtoAntecip>", grupo.toString());
    }

    @Test
    public void valorNaoDeveExtrapolarTamanho() {
        final CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip grupo = new CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip();
        Assertions.assertThrows(NumberFormatException.class, () -> grupo.setValorICMSPrevisto(new BigDecimal("12345678901234")));
        Assertions.assertThrows(NumberFormatException.class, () -> grupo.setValorICMSPrevisto(new BigDecimal("1.123")));
        Assertions.assertThrows(NumberFormatException.class, () -> grupo.setValorICMSPrevisto(new BigDecimal("-1")));
    }
}
