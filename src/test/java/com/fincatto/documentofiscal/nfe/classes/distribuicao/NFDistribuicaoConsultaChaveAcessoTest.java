package com.fincatto.documentofiscal.nfe.classes.distribuicao;

import org.junit.Assert;
import org.junit.Test;

public class NFDistribuicaoConsultaChaveAcessoTest {

    @Test
    public void deveSerChaveAcessoCorreta() {
        final NFDistribuicaoConsultaChaveAcesso distribuicaoInt = new NFDistribuicaoConsultaChaveAcesso();
        distribuicaoInt.setChaveAcesso("12345678901234567890123456789012345678901234");
        Assert.assertEquals("12345678901234567890123456789012345678901234", distribuicaoInt.getChaveAcesso());
    }

    @Test
    public void deveGerarXmlCorretamente() {
        final NFDistribuicaoConsultaChaveAcesso distribuicaoInt = new NFDistribuicaoConsultaChaveAcesso();
        distribuicaoInt.setChaveAcesso("12345678901234567890123456789012345678901234");
        final String retorno = "<NFDistribuicaoConsultaChaveAcesso><chNFe>12345678901234567890123456789012345678901234</chNFe></NFDistribuicaoConsultaChaveAcesso>";
        Assert.assertEquals(retorno, distribuicaoInt.toString());
    }

}
