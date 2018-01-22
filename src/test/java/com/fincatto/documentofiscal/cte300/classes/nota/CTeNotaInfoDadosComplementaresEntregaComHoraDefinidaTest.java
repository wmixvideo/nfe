package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;

public class CTeNotaInfoDadosComplementaresEntregaComHoraDefinidaTest {

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<comHora><tpHor>2</tpHor><hProg>10:10:10</hProg></comHora>", FabricaDeObjetosFake.getEntregaComHoraDefinida().toString());
    }

}
