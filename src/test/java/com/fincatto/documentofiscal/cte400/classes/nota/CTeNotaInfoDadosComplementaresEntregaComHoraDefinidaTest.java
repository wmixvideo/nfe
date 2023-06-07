package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoHoraEntrega;
import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresEntregaComHoraDefinidaTest {

    @Test
    public void deveSerTipoPrazoEntregaComHoraDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaComHoraDefinida();
        entregaComHoraDefinida.setHoraProgramada(FabricaDeObjetosFake.getLocalTime());
        entregaComHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.NO_HORARIO);
        Assert.assertEquals("1", entregaComHoraDefinida.getTipoPrazoHoraEntrega().getCodigo());
    }

    @Test(expected = IllegalStateException.class)
    public void deveSerTipoPrazoEntregaSemHoraProgramada() {
        final CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaComHoraDefinida();
        entregaComHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.NO_HORARIO);
        entregaComHoraDefinida.toString();
    }

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<comHora><tpHor>1</tpHor><hProg>10:10:10</hProg></comHora>", FabricaDeObjetosFake.getEntregaComHoraDefinida().toString());
    }

}
