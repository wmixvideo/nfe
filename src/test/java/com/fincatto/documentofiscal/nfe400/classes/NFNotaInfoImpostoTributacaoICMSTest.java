package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoImpostoTributacaoICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("00", NFNotaInfoImpostoTributacaoICMS.CST_00.getCodigo());
        Assertions.assertEquals("10", NFNotaInfoImpostoTributacaoICMS.CST_10.getCodigo());
        Assertions.assertEquals("20", NFNotaInfoImpostoTributacaoICMS.CST_20.getCodigo());
        Assertions.assertEquals("30", NFNotaInfoImpostoTributacaoICMS.CST_30.getCodigo());
        Assertions.assertEquals("40", NFNotaInfoImpostoTributacaoICMS.CST_40.getCodigo());
        Assertions.assertEquals("41", NFNotaInfoImpostoTributacaoICMS.CST_41.getCodigo());
        Assertions.assertEquals("50", NFNotaInfoImpostoTributacaoICMS.CST_50.getCodigo());
        Assertions.assertEquals("51", NFNotaInfoImpostoTributacaoICMS.CST_51.getCodigo());
        Assertions.assertEquals("60", NFNotaInfoImpostoTributacaoICMS.CST_60.getCodigo());
        Assertions.assertEquals("70", NFNotaInfoImpostoTributacaoICMS.CST_70.getCodigo());
        Assertions.assertEquals("90", NFNotaInfoImpostoTributacaoICMS.CST_90.getCodigo());
    }
    
    @Test
    public void deveObterSituacaoOperacionalSimplesNacionalApartirDoSeuCodigo() {
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_00, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("00"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_10, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("10"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_20, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("20"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_30, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("30"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_40, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("40"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_41, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("41"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_50, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("50"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_60, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("60"));
    	Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_70, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("70"));
        Assertions.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_90, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("90"));
    }
}