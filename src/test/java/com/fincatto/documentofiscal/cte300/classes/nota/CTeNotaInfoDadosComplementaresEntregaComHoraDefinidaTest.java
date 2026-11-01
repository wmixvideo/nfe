package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoHoraEntrega;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresEntregaComHoraDefinidaTest {

    @Test
    public void deveSerTipoPrazoEntregaComHoraDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaComHoraDefinida();
        entregaComHoraDefinida.setHoraProgramada(FabricaDeObjetosFake.getLocalTime());
        entregaComHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.NO_HORARIO);
        Assertions.assertEquals("1", entregaComHoraDefinida.getTipoPrazoHoraEntrega().getCodigo());
    }

    @Test
    public void deveSerTipoPrazoEntregaSemHoraProgramada() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresEntregaComHoraDefinida entregaComHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaComHoraDefinida();
            entregaComHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.NO_HORARIO);
            entregaComHoraDefinida.toString();
        });
    }

    @Test
    public void deveGerarXmlCorreto() {
        Assertions.assertEquals("<comHora><tpHor>1</tpHor><hProg>10:10:10</hProg></comHora>", FabricaDeObjetosFake.getEntregaComHoraDefinida().toString());
    }

}
