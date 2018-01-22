package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;

public class CTeNotaInfoDadosComplementaresEntregaSemHoraDefinidaTest {

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<semHora><tpHor>3</tpHor></semHora>", FabricaDeObjetosFake.getEntregaSemHoraDefinida().toString());
    }

}
