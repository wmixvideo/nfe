package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDistribuicaoNSUTest {

    @Test
    public void deveGerarErroAoNaoInformarONSU() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDistribuicaoNSU().toString());
    }

    @Test
    public void deveEnviarUltimoNSU() {
        final NFDistribuicaoNSU distribuicaoNSU = new NFDistribuicaoNSU();
        distribuicaoNSU.setUltimoNSU("000000000000012");
        Assertions.assertEquals("000000000000012", distribuicaoNSU.getUltimoNSU());
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoNSU distribuicaoNSU = new NFDistribuicaoNSU();
        distribuicaoNSU.setUltimoNSU("000000000000000");
        final String retorno = "<NFDistribuicaoNSU><ultNSU>000000000000000</ultNSU></NFDistribuicaoNSU>";
        Assertions.assertEquals(retorno, distribuicaoNSU.toString());
    }

}