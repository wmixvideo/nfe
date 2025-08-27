package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoDataEntrega;
import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresEntregaComDataDefinidaTest {

    @Test(expected = IllegalStateException.class)
    public void deveDarErroAoNaoInformarData() {
        final CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida = new CTeNotaInfoDadosComplementaresEntregaComDataDefinida();
        entregaComDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NA_DATA);
        entregaComDataDefinida.toString();
    }

    @Test
    public void testa() {
        final CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida = new CTeNotaInfoDadosComplementaresEntregaComDataDefinida();
        entregaComDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NA_DATA);
        entregaComDataDefinida.setDataProgramada(FabricaDeObjetosFake.getLocalDate());
        Assert.assertEquals("1", entregaComDataDefinida.getTipoPrazoDataEntrega().getCodigo());
    }

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<comData><tpPer>1</tpPer><dProg>2018-01-22</dProg></comData>", FabricaDeObjetosFake.getEntregaComDataDefinida().toString());
    }

}
