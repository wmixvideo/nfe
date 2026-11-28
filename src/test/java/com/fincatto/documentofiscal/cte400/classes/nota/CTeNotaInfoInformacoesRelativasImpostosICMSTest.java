package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CTeNotaInfoInformacoesRelativasImpostosICMSTest {

    @Test
    public void naoDeveGerarGrupoPrevistoQuandoNulo() {
        Assertions.assertFalse(FabricaDeObjetosFake.getImpostosICMS().toString().contains("gICMSPrevistoPagtoAntecip"));
    }

    @Test
    public void deveGerarXMLSomenteComGrupoPrevisto() {
        final CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip grupo = new CTeNotaInfoInformacoesRelativasImpostosICMSPrevistoPagtoAntecip();
        grupo.setValorICMSPrevisto(new BigDecimal("150.5"));
        final CTeNotaInfoInformacoesRelativasImpostosICMS icms = new CTeNotaInfoInformacoesRelativasImpostosICMS();
        icms.setGrupoIcmsPrevistoPagamentoAntecipado(grupo);
        Assertions.assertSame(grupo, icms.getGrupoIcmsPrevistoPagamentoAntecipado());
        Assertions.assertEquals("<ICMS xmlns=\"http://www.portalfiscal.inf.br/cte\"><gICMSPrevistoPagtoAntecip><vICMSPrevisto>150.50</vICMSPrevisto></gICMSPrevistoPagtoAntecip></ICMS>", icms.toString());
    }
}
