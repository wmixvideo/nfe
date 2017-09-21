package com.fincatto.documentofiscal.transformers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.transformers.DFAmbienteTransformer;

public class DFAmbienteTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNull(new DFAmbienteTransformer().read(null));
        Assert.assertEquals(DFAmbiente.PRODUCAO, new DFAmbienteTransformer().read("1"));
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, new DFAmbienteTransformer().read("2"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assert.assertEquals("1", new DFAmbienteTransformer().write(DFAmbiente.PRODUCAO));
        Assert.assertEquals("2", new DFAmbienteTransformer().write(DFAmbiente.HOMOLOGACAO));
    }
}