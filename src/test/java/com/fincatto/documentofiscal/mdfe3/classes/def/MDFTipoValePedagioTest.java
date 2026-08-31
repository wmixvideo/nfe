package com.fincatto.documentofiscal.mdfe3.classes.def;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MDFTipoValePedagioTest {

    @Test
    public void testGetCodigo() {
        Assertions.assertEquals("01", MDFTipoValePedagio.TAG.getCodigo());
        Assertions.assertEquals("02", MDFTipoValePedagio.CUPOM.getCodigo());
        Assertions.assertEquals("03", MDFTipoValePedagio.CARTAO.getCodigo());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("01 - TAG", MDFTipoValePedagio.TAG.toString());
        Assertions.assertEquals("02 - Cupom", MDFTipoValePedagio.CUPOM.toString());
        Assertions.assertEquals("03 - Cart\u00E3o", MDFTipoValePedagio.CARTAO.toString());
    }

    @Test
    public void testValueOfCodigo() {
        Assertions.assertEquals(MDFTipoValePedagio.TAG, MDFTipoValePedagio.valueOfCodigo("01"));
        Assertions.assertEquals(MDFTipoValePedagio.CUPOM, MDFTipoValePedagio.valueOfCodigo("02"));
        Assertions.assertEquals(MDFTipoValePedagio.CARTAO, MDFTipoValePedagio.valueOfCodigo("03"));
        Assertions.assertNull(MDFTipoValePedagio.valueOfCodigo("99"));
        Assertions.assertNull(MDFTipoValePedagio.valueOfCodigo(null));
    }
}