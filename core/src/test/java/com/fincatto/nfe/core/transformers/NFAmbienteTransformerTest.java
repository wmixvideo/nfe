package com.fincatto.nfe.core.transformers;

import com.fincatto.nfe.core.NFAmbiente;
import org.junit.Assert;
import org.junit.Test;

public class NFAmbienteTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNull(new NFAmbienteTransformer().read(null));
        Assert.assertEquals(NFAmbiente.PRODUCAO, new NFAmbienteTransformer().read("1"));
        Assert.assertEquals(NFAmbiente.HOMOLOGACAO, new NFAmbienteTransformer().read("2"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assert.assertEquals("1", new NFAmbienteTransformer().write(NFAmbiente.PRODUCAO));
        Assert.assertEquals("2", new NFAmbienteTransformer().write(NFAmbiente.HOMOLOGACAO));
    }
}