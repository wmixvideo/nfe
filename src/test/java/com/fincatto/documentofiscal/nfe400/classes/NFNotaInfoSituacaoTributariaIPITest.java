package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoSituacaoTributariaIPITest {

    @Test
    public void deveObterSituacaoTributariaIPIApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_00, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("00"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_01, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("01"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_02, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("02"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_03, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("03"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_04, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("04"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_05, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("05"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_49, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("49"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_50, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("50"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_51, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("51"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_52, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("52"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_53, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("53"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_54, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("54"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_55, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("55"));
        Assert.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_99, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("99"));
        Assert.assertNull(NFNotaInfoSituacaoTributariaIPI.valueOfCodigo(""));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("00", NFNotaInfoSituacaoTributariaIPI.CST_00.getCodigo());
        Assert.assertEquals("01", NFNotaInfoSituacaoTributariaIPI.CST_01.getCodigo());
        Assert.assertEquals("02", NFNotaInfoSituacaoTributariaIPI.CST_02.getCodigo());
        Assert.assertEquals("03", NFNotaInfoSituacaoTributariaIPI.CST_03.getCodigo());
        Assert.assertEquals("04", NFNotaInfoSituacaoTributariaIPI.CST_04.getCodigo());
        Assert.assertEquals("05", NFNotaInfoSituacaoTributariaIPI.CST_05.getCodigo());
        Assert.assertEquals("49", NFNotaInfoSituacaoTributariaIPI.CST_49.getCodigo());
        Assert.assertEquals("50", NFNotaInfoSituacaoTributariaIPI.CST_50.getCodigo());
        Assert.assertEquals("51", NFNotaInfoSituacaoTributariaIPI.CST_51.getCodigo());
        Assert.assertEquals("52", NFNotaInfoSituacaoTributariaIPI.CST_52.getCodigo());
        Assert.assertEquals("53", NFNotaInfoSituacaoTributariaIPI.CST_53.getCodigo());
        Assert.assertEquals("54", NFNotaInfoSituacaoTributariaIPI.CST_54.getCodigo());
        Assert.assertEquals("55", NFNotaInfoSituacaoTributariaIPI.CST_55.getCodigo());
        Assert.assertEquals("99", NFNotaInfoSituacaoTributariaIPI.CST_99.getCodigo());
    }
}