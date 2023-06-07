package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoHoraEntrega;
import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresEntregaIntervaloTest {

    @Test
    public void deveSerTipoIntervaloTempo() {
        final CTeNotaInfoDadosComplementaresEntregaIntervalo entregaIntervalo = new CTeNotaInfoDadosComplementaresEntregaIntervalo();
        entregaIntervalo.setHoraInicio(FabricaDeObjetosFake.getLocalTime());
        entregaIntervalo.setHoraFim(FabricaDeObjetosFake.getLocalTime());
        entregaIntervalo.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.NO_INTERVALO_DE_TEMPO);
        Assert.assertEquals("4", entregaIntervalo.getTipoPrazoHoraEntrega().getCodigo());
    }

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<noInter><tpHor>4</tpHor><hIni>10:10:10</hIni><hFim>10:10:10</hFim></noInter>", FabricaDeObjetosFake.getEntregaIntervalo().toString());
    }

}
