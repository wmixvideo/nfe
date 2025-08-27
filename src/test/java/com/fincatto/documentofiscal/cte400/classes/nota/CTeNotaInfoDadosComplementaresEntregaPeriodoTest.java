package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoDataEntrega;
import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresEntregaPeriodoTest {

    @Test
    public void deveSerTipoPrazoEntregaPeriodo() {
        final CTeNotaInfoDadosComplementaresEntregaPeriodo entregaPeriodo = new CTeNotaInfoDadosComplementaresEntregaPeriodo();
        entregaPeriodo.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NO_PERIODO);
        Assert.assertEquals("4", entregaPeriodo.getTipoPrazoDataEntrega().getCodigo());
    }

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<noPeriodo><tpPer>4</tpPer><dIni>2018-01-22</dIni><dFim>2018-01-22</dFim></noPeriodo>", FabricaDeObjetosFake.getEntregaPeriodo().toString());
    }

}
