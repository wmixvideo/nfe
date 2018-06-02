package com.fincatto.documentofiscal.cte.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

public class CTDistribuicaoConsultaNSUTest {

    @Test
    public void deveGerarNSU() {
        final CTDistribuicaoConsultaNSU retorno = new CTDistribuicaoConsultaNSU();
        retorno.setNsu("000000000000001");
        Assert.assertEquals("000000000000001", retorno.getNsu());
    }

    @Test
    public void deveLerXMLDeAcordoComOPadraoEstabelecido() {
        final CTDistribuicaoConsultaNSU retorno = new CTDistribuicaoConsultaNSU();
        retorno.setNsu("000000000000001");
        Assert.assertEquals("<CTDistribuicaoConsultaNSU><NSU>000000000000001</NSU></CTDistribuicaoConsultaNSU>", retorno.toString());
    }

}