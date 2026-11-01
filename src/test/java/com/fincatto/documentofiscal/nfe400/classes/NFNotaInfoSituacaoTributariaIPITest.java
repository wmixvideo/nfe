package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoSituacaoTributariaIPITest {

    @Test
    public void deveObterSituacaoTributariaIPIApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_00, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("00"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_01, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("01"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_02, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("02"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_03, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("03"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_04, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("04"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_05, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("05"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_49, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("49"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_50, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("50"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_51, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("51"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_52, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("52"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_53, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("53"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_54, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("54"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_55, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("55"));
        Assertions.assertEquals(NFNotaInfoSituacaoTributariaIPI.CST_99, NFNotaInfoSituacaoTributariaIPI.valueOfCodigo("99"));
        Assertions.assertNull(NFNotaInfoSituacaoTributariaIPI.valueOfCodigo(""));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("00", NFNotaInfoSituacaoTributariaIPI.CST_00.getCodigo());
        Assertions.assertEquals("01", NFNotaInfoSituacaoTributariaIPI.CST_01.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoSituacaoTributariaIPI.CST_02.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoSituacaoTributariaIPI.CST_03.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoSituacaoTributariaIPI.CST_04.getCodigo());
        Assertions.assertEquals("05", NFNotaInfoSituacaoTributariaIPI.CST_05.getCodigo());
        Assertions.assertEquals("49", NFNotaInfoSituacaoTributariaIPI.CST_49.getCodigo());
        Assertions.assertEquals("50", NFNotaInfoSituacaoTributariaIPI.CST_50.getCodigo());
        Assertions.assertEquals("51", NFNotaInfoSituacaoTributariaIPI.CST_51.getCodigo());
        Assertions.assertEquals("52", NFNotaInfoSituacaoTributariaIPI.CST_52.getCodigo());
        Assertions.assertEquals("53", NFNotaInfoSituacaoTributariaIPI.CST_53.getCodigo());
        Assertions.assertEquals("54", NFNotaInfoSituacaoTributariaIPI.CST_54.getCodigo());
        Assertions.assertEquals("55", NFNotaInfoSituacaoTributariaIPI.CST_55.getCodigo());
        Assertions.assertEquals("99", NFNotaInfoSituacaoTributariaIPI.CST_99.getCodigo());
    }
}