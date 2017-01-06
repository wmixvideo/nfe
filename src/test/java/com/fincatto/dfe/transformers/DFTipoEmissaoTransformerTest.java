package com.fincatto.dfe.transformers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFTipoEmissao;

public class DFTipoEmissaoTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNull(new DFTipoEmissaoTransformer().read(null));
        Assert.assertEquals(DFTipoEmissao.EMISSAO_NORMAL, new DFTipoEmissaoTransformer().read("1"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_FS_IA, new DFTipoEmissaoTransformer().read("2"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SCAN, new DFTipoEmissaoTransformer().read("3"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_DPEC, new DFTipoEmissaoTransformer().read("4"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_FSDA, new DFTipoEmissaoTransformer().read("5"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SVCAN, new DFTipoEmissaoTransformer().read("6"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SVCRS, new DFTipoEmissaoTransformer().read("7"));
        Assert.assertEquals(DFTipoEmissao.CONTINGENCIA_SVCSP, new DFTipoEmissaoTransformer().read("8"));
        Assert.assertEquals(DFTipoEmissao.CONTIGENCIA_OFFLINE, new DFTipoEmissaoTransformer().read("9"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assert.assertEquals("1", new DFTipoEmissaoTransformer().write(DFTipoEmissao.EMISSAO_NORMAL));
        Assert.assertEquals("2", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTINGENCIA_FS_IA));
        Assert.assertEquals("3", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTINGENCIA_SCAN));
        Assert.assertEquals("4", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTINGENCIA_DPEC));
        Assert.assertEquals("5", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTINGENCIA_FSDA));
        Assert.assertEquals("6", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTINGENCIA_SVCAN));
        Assert.assertEquals("7", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTINGENCIA_SVCRS));
        Assert.assertEquals("8", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTINGENCIA_SVCSP));
        Assert.assertEquals("9", new DFTipoEmissaoTransformer().write(DFTipoEmissao.CONTIGENCIA_OFFLINE));
    }
}