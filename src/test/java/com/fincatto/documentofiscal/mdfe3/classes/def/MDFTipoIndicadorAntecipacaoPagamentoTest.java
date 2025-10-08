package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MDFTipoIndicadorAntecipacaoPagamentoTest {


    @Test
    public void testValueOfCodigoSim() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("1");
        assertEquals(MDFTipoIndicadorAntecipacaoPagamento.CONCORDANCIA_ANTECIPAR_ADIANTAMENTO, tipo);
        Assert.assertNotNull(tipo);
        assertEquals("1", tipo.getCodigo());
        assertEquals("1 - Concorda em antecipar o adiantamento", tipo.toString());
    }

    @Test
    public void testValueOfCodigoInvalido() {
        MDFTipoIndicadorAntecipacaoPagamento tipo = MDFTipoIndicadorAntecipacaoPagamento.valueOfCodigo("2");
        assertNull(tipo);
    }
}