package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoDataEntrega;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresEntregaComDataDefinidaTest {

    @Test
    public void deveDarErroAoNaoInformarData() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida = new CTeNotaInfoDadosComplementaresEntregaComDataDefinida();
            entregaComDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NA_DATA);
            entregaComDataDefinida.toString();
        });
    }

    @Test
    public void testa() {
        final CTeNotaInfoDadosComplementaresEntregaComDataDefinida entregaComDataDefinida = new CTeNotaInfoDadosComplementaresEntregaComDataDefinida();
        entregaComDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NA_DATA);
        entregaComDataDefinida.setDataProgramada(FabricaDeObjetosFake.getLocalDate());
        Assertions.assertEquals("1", entregaComDataDefinida.getTipoPrazoDataEntrega().getCodigo());
    }

    @Test
    public void deveGerarXmlCorreto() {
        Assertions.assertEquals("<comData><tpPer>1</tpPer><dProg>2018-01-22</dProg></comData>", FabricaDeObjetosFake.getEntregaComDataDefinida().toString());
    }

}
