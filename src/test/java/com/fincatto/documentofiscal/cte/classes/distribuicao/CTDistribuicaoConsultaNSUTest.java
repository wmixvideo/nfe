package com.fincatto.documentofiscal.cte.classes.distribuicao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTDistribuicaoConsultaNSUTest {

    @Test
    public void deveGerarNSU() {
        final CTDistribuicaoConsultaNSU retorno = new CTDistribuicaoConsultaNSU();
        retorno.setNsu("000000000000001");
        Assertions.assertEquals("000000000000001", retorno.getNsu());
    }

    @Test
    public void deveLerXMLDeAcordoComOPadraoEstabelecido() {
        final CTDistribuicaoConsultaNSU retorno = new CTDistribuicaoConsultaNSU();
        retorno.setNsu("000000000000001");
        Assertions.assertEquals("<CTDistribuicaoConsultaNSU><NSU>000000000000001</NSU></CTDistribuicaoConsultaNSU>", retorno.toString());
    }

}