package com.fincatto.documentofiscal.cte400.classes.nota;

import com.fincatto.documentofiscal.cte400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.cte400.classes.CTTipoPrazoDataEntrega;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresEntregaPeriodoTest {

    @Test
    public void deveSerTipoPrazoEntregaPeriodo() {
        final CTeNotaInfoDadosComplementaresEntregaPeriodo entregaPeriodo = new CTeNotaInfoDadosComplementaresEntregaPeriodo();
        entregaPeriodo.setTipoPrazoDataEntrega(CTTipoPrazoDataEntrega.NO_PERIODO);
        Assertions.assertEquals("4", entregaPeriodo.getTipoPrazoDataEntrega().getCodigo());
    }

    @Test
    public void deveGerarXmlCorreto() {
        Assertions.assertEquals("<noPeriodo><tpPer>4</tpPer><dIni>2018-01-22</dIni><dFim>2018-01-22</dFim></noPeriodo>", FabricaDeObjetosFake.getEntregaPeriodo().toString());
    }

}
