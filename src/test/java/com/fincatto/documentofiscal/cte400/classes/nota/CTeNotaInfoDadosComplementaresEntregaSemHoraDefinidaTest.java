package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoHoraEntrega;
import org.junit.Assert;
import org.junit.Test;

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