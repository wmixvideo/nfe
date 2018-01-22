package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;

public class CTeNotaInfoDadosComplementaresEntregaPeriodoTest {

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<noPeriodo><tpPer>4</tpPer><dIni>2018-01-22</dIni><dFim>2018-01-22</dFim></noPeriodo>", FabricaDeObjetosFake.getEntregaPeriodo().toString());
    }

}
