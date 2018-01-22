package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.cte300.FabricaDeObjetosFake;

public class CTeNotaInfoDadosComplementaresEntregaIntervaloTest {

    @Test
    public void deveGerarXmlCorreto() {
        Assert.assertEquals("<noInter><tpHor>2</tpHor><hIni>10:10:10</hIni><hFim>10:10:10</hFim></noInter>", FabricaDeObjetosFake.getEntregaIntervalo().toString());
    }

}
