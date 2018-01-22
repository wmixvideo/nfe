package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;

public class CTeNotaInfoDadosComplementaresEntregaSemDataDefinidaTest {

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<semData><tpPer>3</tpPer></semData>", FabricaDeObjetosFake.getEntregaSemDataDefinida().toString());
    }

}
