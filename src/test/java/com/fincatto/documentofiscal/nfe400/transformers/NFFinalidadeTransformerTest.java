package com.fincatto.documentofiscal.nfe400.transformers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFFinalidade;
import com.fincatto.documentofiscal.nfe310.transformers.NFFinalidadeTransformer;

public class NFFinalidadeTransformerTest {
    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNull(new NFFinalidadeTransformer().read("0"));
        Assert.assertEquals(NFFinalidade.NORMAL, new NFFinalidadeTransformer().read("1"));
        Assert.assertEquals(NFFinalidade.COMPLEMENTAR, new NFFinalidadeTransformer().read("2"));
        Assert.assertEquals(NFFinalidade.AJUSTE, new NFFinalidadeTransformer().read("3"));
        Assert.assertEquals(NFFinalidade.DEVOLUCAO_OU_RETORNO, new NFFinalidadeTransformer().read("4"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assert.assertEquals("1", new NFFinalidadeTransformer().write(NFFinalidade.NORMAL));
        Assert.assertEquals("2", new NFFinalidadeTransformer().write(NFFinalidade.COMPLEMENTAR));
        Assert.assertEquals("3", new NFFinalidadeTransformer().write(NFFinalidade.AJUSTE));
        Assert.assertEquals("4", new NFFinalidadeTransformer().write(NFFinalidade.DEVOLUCAO_OU_RETORNO));
    }
}