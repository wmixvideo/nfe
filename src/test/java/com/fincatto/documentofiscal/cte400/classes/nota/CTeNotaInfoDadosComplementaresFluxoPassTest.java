package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresFluxoPassTest {

    @Test
    public void deveTerEntre1e15Caracteres() {
        final CTeNotaInfoDadosComplementaresFluxoPass pass = new CTeNotaInfoDadosComplementaresFluxoPass();
        pass.setPass("123456789012345");
        Assertions.assertEquals("123456789012345", pass.getPass());
    }

    @Test
    public void naoDeveTerMaisQue15Caracteres() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresFluxoPass pass = new CTeNotaInfoDadosComplementaresFluxoPass();
            pass.setPass("123456789012345678");
        });
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresFluxoPass pass = new CTeNotaInfoDadosComplementaresFluxoPass();
        pass.setPass("123456789012345");
        Assertions.assertEquals("<pass><xPass>123456789012345</xPass></pass>", pass.toString());
    }

}
