package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDistribuicaoConsultaNSUTest {


    @Test
    public void deveGerarConsultaComNSU() {
        final NFDistribuicaoConsultaNSU distribuicaoNSU = new NFDistribuicaoConsultaNSU();
        distribuicaoNSU.setNsu("000000000000015");
        Assertions.assertEquals("000000000000015", distribuicaoNSU.getNsu());
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoConsultaNSU distribuicaoNSU = new NFDistribuicaoConsultaNSU();
        distribuicaoNSU.setNsu("000000000000000");
        final String retorno = "<NFDistribuicaoConsultaNSU><NSU>000000000000000</NSU></NFDistribuicaoConsultaNSU>";
        Assertions.assertEquals(retorno, distribuicaoNSU.toString());
    }

}
