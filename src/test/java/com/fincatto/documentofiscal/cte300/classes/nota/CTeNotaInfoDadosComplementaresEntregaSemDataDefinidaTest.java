package com.fincatto.documentofiscal.cte300.classes.nota;

import com.fincatto.documentofiscal.cte300.classes.CTTipoPrazoDataEntrega;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresEntregaSemDataDefinidaTest {

    @Test
    public void deveSerTipoPrazoEntregaSemDataDefinida() {
        final CTeNotaInfoDadosComplementaresEntregaSemDataDefinida entregaSemDataDefinida = new CTeNotaInfoDadosComplementaresEntregaSemDataDefinida();
        entregaSemDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.SEM_DATA_DEFINIDA);
        Assertions.assertEquals("0", entregaSemDataDefinida.getTipoPrazoDataEntrega().getCodigo());
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresEntregaSemDataDefinida entregaSemDataDefinida = new CTeNotaInfoDadosComplementaresEntregaSemDataDefinida();
        entregaSemDataDefinida.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.SEM_DATA_DEFINIDA);
        Assertions.assertEquals("<semData><tpPer>0</tpPer></semData>", entregaSemDataDefinida.toString());
    }

}
