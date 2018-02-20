package com.fincatto.documentofiscal.nfe;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoEmissaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFTipoEmissao.EMISSAO_NORMAL.getCodigo());
        Assert.assertEquals("2", NFTipoEmissao.CONTINGENCIA_FS_IA.getCodigo());
        Assert.assertEquals("3", NFTipoEmissao.CONTINGENCIA_SCAN.getCodigo());
        Assert.assertEquals("4", NFTipoEmissao.CONTINGENCIA_DPEC.getCodigo());
        Assert.assertEquals("5", NFTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
        Assert.assertEquals("6", NFTipoEmissao.CONTINGENCIA_SVCAN.getCodigo());
        Assert.assertEquals("7", NFTipoEmissao.CONTINGENCIA_SVCRS.getCodigo());
        Assert.assertEquals("9", NFTipoEmissao.CONTIGENCIA_OFFLINE.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assert.assertEquals(NFTipoEmissao.EMISSAO_NORMAL, NFTipoEmissao.valueOfCodigo("1"));
        Assert.assertEquals(NFTipoEmissao.CONTINGENCIA_FS_IA, NFTipoEmissao.valueOfCodigo("2"));
        Assert.assertEquals(NFTipoEmissao.CONTINGENCIA_SCAN, NFTipoEmissao.valueOfCodigo("3"));
        Assert.assertEquals(NFTipoEmissao.CONTINGENCIA_DPEC, NFTipoEmissao.valueOfCodigo("4"));
        Assert.assertEquals(NFTipoEmissao.CONTINGENCIA_FSDA, NFTipoEmissao.valueOfCodigo("5"));
        Assert.assertEquals(NFTipoEmissao.CONTINGENCIA_SVCAN, NFTipoEmissao.valueOfCodigo("6"));
        Assert.assertEquals(NFTipoEmissao.CONTINGENCIA_SVCRS, NFTipoEmissao.valueOfCodigo("7"));
        Assert.assertEquals(NFTipoEmissao.CONTIGENCIA_OFFLINE, NFTipoEmissao.valueOfCodigo("9"));
    }

    @Test
    public void deveRetornarNuloCasoNaoExistaCodigo() {
        Assert.assertNull(NFTipoEmissao.valueOfCodigo("8"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assert.assertEquals("1 - Normal", NFTipoEmissao.EMISSAO_NORMAL.toString());
    }
}