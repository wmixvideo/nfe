package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoSituacaoTributariaPISTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", NFNotaInfoSituacaoTributariaPIS.CST_01.getCodigo());
        Assertions.assertEquals("02", NFNotaInfoSituacaoTributariaPIS.CST_02.getCodigo());
        Assertions.assertEquals("03", NFNotaInfoSituacaoTributariaPIS.CST_03.getCodigo());
        Assertions.assertEquals("04", NFNotaInfoSituacaoTributariaPIS.CST_04.getCodigo());
        Assertions.assertEquals("06", NFNotaInfoSituacaoTributariaPIS.CST_06.getCodigo());
        Assertions.assertEquals("07", NFNotaInfoSituacaoTributariaPIS.CST_07.getCodigo());
        Assertions.assertEquals("08", NFNotaInfoSituacaoTributariaPIS.CST_08.getCodigo());
        Assertions.assertEquals("09", NFNotaInfoSituacaoTributariaPIS.CST_09.getCodigo());
        Assertions.assertEquals("49", NFNotaInfoSituacaoTributariaPIS.CST_49.getCodigo());
        Assertions.assertEquals("50", NFNotaInfoSituacaoTributariaPIS.CST_50.getCodigo());
        Assertions.assertEquals("51", NFNotaInfoSituacaoTributariaPIS.CST_51.getCodigo());
        Assertions.assertEquals("52", NFNotaInfoSituacaoTributariaPIS.CST_52.getCodigo());
        Assertions.assertEquals("53", NFNotaInfoSituacaoTributariaPIS.CST_53.getCodigo());
        Assertions.assertEquals("54", NFNotaInfoSituacaoTributariaPIS.CST_54.getCodigo());
        Assertions.assertEquals("55", NFNotaInfoSituacaoTributariaPIS.CST_55.getCodigo());
        Assertions.assertEquals("56", NFNotaInfoSituacaoTributariaPIS.CST_56.getCodigo());
        Assertions.assertEquals("60", NFNotaInfoSituacaoTributariaPIS.CST_60.getCodigo());
        Assertions.assertEquals("61", NFNotaInfoSituacaoTributariaPIS.CST_61.getCodigo());
        Assertions.assertEquals("62", NFNotaInfoSituacaoTributariaPIS.CST_62.getCodigo());
        Assertions.assertEquals("63", NFNotaInfoSituacaoTributariaPIS.CST_63.getCodigo());
        Assertions.assertEquals("64", NFNotaInfoSituacaoTributariaPIS.CST_64.getCodigo());
        Assertions.assertEquals("65", NFNotaInfoSituacaoTributariaPIS.CST_65.getCodigo());
        Assertions.assertEquals("66", NFNotaInfoSituacaoTributariaPIS.CST_66.getCodigo());
        Assertions.assertEquals("67", NFNotaInfoSituacaoTributariaPIS.CST_67.getCodigo());
        Assertions.assertEquals("70", NFNotaInfoSituacaoTributariaPIS.CST_70.getCodigo());
        Assertions.assertEquals("71", NFNotaInfoSituacaoTributariaPIS.CST_71.getCodigo());
        Assertions.assertEquals("72", NFNotaInfoSituacaoTributariaPIS.CST_72.getCodigo());
        Assertions.assertEquals("73", NFNotaInfoSituacaoTributariaPIS.CST_73.getCodigo());
        Assertions.assertEquals("74", NFNotaInfoSituacaoTributariaPIS.CST_74.getCodigo());
        Assertions.assertEquals("75", NFNotaInfoSituacaoTributariaPIS.CST_75.getCodigo());
        Assertions.assertEquals("98", NFNotaInfoSituacaoTributariaPIS.CST_98.getCodigo());
        Assertions.assertEquals("99", NFNotaInfoSituacaoTributariaPIS.CST_99.getCodigo());
    }
}