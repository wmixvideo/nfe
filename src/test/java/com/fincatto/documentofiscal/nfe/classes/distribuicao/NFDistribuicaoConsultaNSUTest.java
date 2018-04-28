package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

public class NFDistribuicaoConsultaNSUTest {


    @Test
    public void deveGerarConsultaComNSU() {
        final NFDistribuicaoConsultaNSU distribuicaoNSU = new NFDistribuicaoConsultaNSU();
        distribuicaoNSU.setNsu("000000000000015");
        Assert.assertEquals("000000000000015", distribuicaoNSU.getNsu());
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoConsultaNSU distribuicaoNSU = new NFDistribuicaoConsultaNSU();
        distribuicaoNSU.setNsu("000000000000000");
        final String retorno = "<NFDistribuicaoConsultaNSU><NSU>000000000000000</NSU></NFDistribuicaoConsultaNSU>";
        Assert.assertEquals(retorno, distribuicaoNSU.toString());
    }

}
