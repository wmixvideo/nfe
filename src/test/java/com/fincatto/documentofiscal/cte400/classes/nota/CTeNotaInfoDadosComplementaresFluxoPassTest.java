package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresFluxoPassTest {

    @Test
    public void deveTerEntre1e15Caracteres() {
        final CTeNotaInfoDadosComplementaresFluxoPass pass = new CTeNotaInfoDadosComplementaresFluxoPass();
        pass.setPass("123456789012345");
        Assert.assertEquals("123456789012345", pass.getPass());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveTerMaisQue15Caracteres() {
        final CTeNotaInfoDadosComplementaresFluxoPass pass = new CTeNotaInfoDadosComplementaresFluxoPass();
        pass.setPass("123456789012345678");
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresFluxoPass pass = new CTeNotaInfoDadosComplementaresFluxoPass();
        pass.setPass("123456789012345");
        Assert.assertEquals("<pass><xPass>123456789012345</xPass></pass>", pass.toString());
    }

}
