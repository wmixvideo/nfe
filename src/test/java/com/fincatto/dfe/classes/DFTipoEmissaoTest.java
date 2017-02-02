package com.fincatto.dfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class DFTipoEmissaoTest {

	@Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", DFTipoEmissao.EMISSAO_NORMAL.getCodigo());
        Assert.assertEquals("2", DFTipoEmissao.CONTINGENCIA_FS_IA.getCodigo());
        Assert.assertEquals("3", DFTipoEmissao.CONTINGENCIA_SCAN.getCodigo());
        Assert.assertEquals("4", DFTipoEmissao.CONTINGENCIA_DPEC.getCodigo());
        Assert.assertEquals("5", DFTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
        Assert.assertEquals("6", DFTipoEmissao.CONTINGENCIA_SVCAN.getCodigo());
        Assert.assertEquals("7", DFTipoEmissao.CONTINGENCIA_SVCRS.getCodigo());
        Assert.assertEquals("8", DFTipoEmissao.CONTINGENCIA_SVCSP.getCodigo());
        Assert.assertEquals("9", DFTipoEmissao.CONTIGENCIA_OFFLINE.getCodigo());
    }

    @Test
    public void deveRepresentarADescricaoCorretamente() {
        Assert.assertEquals("Normal", DFTipoEmissao.EMISSAO_NORMAL.getDescricao());
        Assert.assertEquals("Conting\u00eancia FS", DFTipoEmissao.CONTINGENCIA_FS_IA.getDescricao());
        Assert.assertEquals("Conting\u00eancia SCAN", DFTipoEmissao.CONTINGENCIA_SCAN.getDescricao());
        Assert.assertEquals("Conting\u00eancia DPEC", DFTipoEmissao.CONTINGENCIA_DPEC.getDescricao());
        Assert.assertEquals("Conting\u00eancia FSDA", DFTipoEmissao.CONTINGENCIA_FSDA.getDescricao());
        Assert.assertEquals("Conting\u00eancia SVCAN", DFTipoEmissao.CONTINGENCIA_SVCAN.getDescricao());
        Assert.assertEquals("Conting\u00eancia SVCRS", DFTipoEmissao.CONTINGENCIA_SVCRS.getDescricao());
        Assert.assertEquals("Conting\u00eancia SVCSP", DFTipoEmissao.CONTINGENCIA_SVCSP.getDescricao());
        Assert.assertEquals("Contig\u00eancia offline NFC-e", DFTipoEmissao.CONTIGENCIA_OFFLINE.getDescricao());
    }

    @Test
    public void deveObterAtravesDoCodigo() {
        Assert.assertEquals(DFTipoEmissao.EMISSAO_NORMAL, DFTipoEmissao.valueOfCodigo("1"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_FS_IA, DFTipoEmissao.valueOfCodigo("2"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SCAN, DFTipoEmissao.valueOfCodigo("3"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_DPEC, DFTipoEmissao.valueOfCodigo("4"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_FSDA, DFTipoEmissao.valueOfCodigo("5"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SVCAN, DFTipoEmissao.valueOfCodigo("6"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SVCRS, DFTipoEmissao.valueOfCodigo("7"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SVCSP, DFTipoEmissao.valueOfCodigo("8"));
        Assert.assertEquals(DFTipoEmissao.CONTIGENCIA_OFFLINE, DFTipoEmissao.valueOfCodigo("9"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assert.assertNull(DFTipoEmissao.valueOfCodigo("10"));
    }

    @Test
    public void deveRetornarToStringCorretamente() {
    	Assert.assertEquals("1 - Normal", DFTipoEmissao.EMISSAO_NORMAL.toString());
        Assert.assertEquals("2 - Conting\u00eancia FS", DFTipoEmissao.CONTINGENCIA_FS_IA.toString());
        Assert.assertEquals("3 - Conting\u00eancia SCAN", DFTipoEmissao.CONTINGENCIA_SCAN.toString());
        Assert.assertEquals("4 - Conting\u00eancia DPEC", DFTipoEmissao.CONTINGENCIA_DPEC.toString());
        Assert.assertEquals("5 - Conting\u00eancia FSDA", DFTipoEmissao.CONTINGENCIA_FSDA.toString());
        Assert.assertEquals("6 - Conting\u00eancia SVCAN", DFTipoEmissao.CONTINGENCIA_SVCAN.toString());
        Assert.assertEquals("7 - Conting\u00eancia SVCRS", DFTipoEmissao.CONTINGENCIA_SVCRS.toString());
        Assert.assertEquals("8 - Conting\u00eancia SVCSP", DFTipoEmissao.CONTINGENCIA_SVCSP.toString());
        Assert.assertEquals("9 - Contig\u00eancia offline NFC-e", DFTipoEmissao.CONTIGENCIA_OFFLINE.toString());
    }
}