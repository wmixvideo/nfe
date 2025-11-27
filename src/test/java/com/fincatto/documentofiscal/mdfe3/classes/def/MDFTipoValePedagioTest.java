package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MDFTipoValePedagioTest {

    @Test
    public void testGetCodigo() {
        assertEquals("01", MDFTipoValePedagio.TAG.getCodigo());
        assertEquals("02", MDFTipoValePedagio.CUPOM.getCodigo());
        assertEquals("03", MDFTipoValePedagio.CARTAO.getCodigo());
    }

    @Test
    public void testToString() {
        assertEquals("01 - TAG", MDFTipoValePedagio.TAG.toString());
        assertEquals("02 - Cupom", MDFTipoValePedagio.CUPOM.toString());
        assertEquals("03 - Cart\u00E3o", MDFTipoValePedagio.CARTAO.toString());
    }

    @Test
    public void testValueOfCodigo() {
        assertEquals(MDFTipoValePedagio.TAG, MDFTipoValePedagio.valueOfCodigo("01"));
        assertEquals(MDFTipoValePedagio.CUPOM, MDFTipoValePedagio.valueOfCodigo("02"));
        assertEquals(MDFTipoValePedagio.CARTAO, MDFTipoValePedagio.valueOfCodigo("03"));
        assertNull(MDFTipoValePedagio.valueOfCodigo("99"));
        assertNull(MDFTipoValePedagio.valueOfCodigo(null));
    }
}