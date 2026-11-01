package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MDFTipoIndicadorAntecipacaoPagamentoTest {

    @Test
    public void testValueOfCodigoNao() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("0");
        Assertions.assertEquals(MDFTipoIndicadorAntecipacaoPagamento.NAO, tipo);
        Assertions.assertNotNull(tipo);
        Assertions.assertEquals("0", tipo.getCodigo());
        Assertions.assertEquals("0 - Não", tipo.toString());
    }

    @Test
    public void testValueOfCodigoSim() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("1");
        Assertions.assertEquals(MDFTipoIndicadorAntecipacaoPagamento.SIM, tipo);
        Assertions.assertNotNull(tipo);
        Assertions.assertEquals("1", tipo.getCodigo());
        Assertions.assertEquals("1 - Sim", tipo.toString());
    }

    @Test
    public void testValueOfCodigoInvalido() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("2");
        Assertions.assertNull(tipo);
    }
}