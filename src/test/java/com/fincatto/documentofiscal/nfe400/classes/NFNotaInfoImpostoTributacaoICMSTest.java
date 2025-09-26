package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoImpostoTributacaoICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("00", NFNotaInfoImpostoTributacaoICMS.CST_00.getCodigo());
        Assert.assertEquals("10", NFNotaInfoImpostoTributacaoICMS.CST_10.getCodigo());
        Assert.assertEquals("20", NFNotaInfoImpostoTributacaoICMS.CST_20.getCodigo());
        Assert.assertEquals("30", NFNotaInfoImpostoTributacaoICMS.CST_30.getCodigo());
        Assert.assertEquals("40", NFNotaInfoImpostoTributacaoICMS.CST_40.getCodigo());
        Assert.assertEquals("41", NFNotaInfoImpostoTributacaoICMS.CST_41.getCodigo());
        Assert.assertEquals("50", NFNotaInfoImpostoTributacaoICMS.CST_50.getCodigo());
        Assert.assertEquals("51", NFNotaInfoImpostoTributacaoICMS.CST_51.getCodigo());
        Assert.assertEquals("60", NFNotaInfoImpostoTributacaoICMS.CST_60.getCodigo());
        Assert.assertEquals("70", NFNotaInfoImpostoTributacaoICMS.CST_70.getCodigo());
        Assert.assertEquals("90", NFNotaInfoImpostoTributacaoICMS.CST_90.getCodigo());
    }
    
    @Test
    public void deveObterSituacaoOperacionalSimplesNacionalApartirDoSeuCodigo() {
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_00, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("00"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_10, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("10"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_20, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("20"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_30, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("30"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_40, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("40"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_41, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("41"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_50, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("50"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_60, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("60"));
    	Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_70, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("70"));
        Assert.assertEquals(NFNotaInfoImpostoTributacaoICMS.CST_90, NFNotaInfoImpostoTributacaoICMS.valueOfCodigo("90"));
    }
}