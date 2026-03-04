package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MDFTipoIndicadorAntecipacaoPagamentoTest {

    @Test
    public void testValueOfCodigoNao() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("0");
        assertEquals(MDFTipoIndicadorAntecipacaoPagamento.NAO, tipo);
        Assert.assertNotNull(tipo);
        assertEquals("0", tipo.getCodigo());
        assertEquals("0 - Não", tipo.toString());
    }

    @Test
    public void testValueOfCodigoSim() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("1");
        assertEquals(MDFTipoIndicadorAntecipacaoPagamento.SIM, tipo);
        Assert.assertNotNull(tipo);
        assertEquals("1", tipo.getCodigo());
        assertEquals("1 - Sim", tipo.toString());
    }

    @Test
    public void testValueOfCodigoInvalido() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("2");
        assertNull(tipo);
    }
}