package com.fincatto.documentofiscal.transformers;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFAmbienteTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assertions.assertNull(new DFAmbienteTransformer().read(null));
        Assertions.assertEquals(DFAmbiente.PRODUCAO, new DFAmbienteTransformer().read("1"));
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, new DFAmbienteTransformer().read("2"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assertions.assertEquals("1", new DFAmbienteTransformer().write(DFAmbiente.PRODUCAO));
        Assertions.assertEquals("2", new DFAmbienteTransformer().write(DFAmbiente.HOMOLOGACAO));
    }
}