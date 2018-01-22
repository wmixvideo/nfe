package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoHoraEntrega;

public class CTeNotaInfoDadosComplementaresEntregaSemHoraDefinidaTest {

    @Test
    public void deveSerTipoPrazoEntregaSemHoraDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida entregaSemHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida();
        entregaSemHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.SEM_HORA_DEFINIDA);
        Assert.assertEquals("0", entregaSemHoraDefinida.getTipoPrazoHoraEntrega().getCodigo());
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida entregaSemHoraDefinida = new CTeNotaInfoDadosComplementaresEntregaSemHoraDefinida();
        entregaSemHoraDefinida.setTipoPrazoHoraEntrega(CTTipoPrazoHoraEntrega.A_PARTIR_DO_HORARIO);
        Assert.assertEquals("<semHora><tpHor>3</tpHor></semHora>", entregaSemHoraDefinida.toString());
    }
}