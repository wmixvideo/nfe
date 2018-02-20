package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

public class NFDistribuicaoNSUTest {

    @Test(expected = IllegalStateException.class)
    public void deveGerarErroAoNaoInformarONSU() {
        new NFDistribuicaoNSU().toString();
    }

    @Test
    public void deveEnviarUltimoNSU() {
        final NFDistribuicaoNSU distribuicaoNSU = new NFDistribuicaoNSU();
        distribuicaoNSU.setUltimoNSU("000000000000012");
        Assert.assertEquals("000000000000012", distribuicaoNSU.getUltimoNSU());
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoNSU distribuicaoNSU = new NFDistribuicaoNSU();
        distribuicaoNSU.setUltimoNSU("000000000000000");
        final String retorno = "<NFDistribuicaoNSU><ultNSU>000000000000000</ultNSU></NFDistribuicaoNSU>";
        Assert.assertEquals(retorno, distribuicaoNSU.toString());
    }

}