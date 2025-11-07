package com.fincatto.documentofiscal.nfe400.transformers;


import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorEscalaRelevante;

public class NFIndicadorEscalaRelevanteTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assert.assertNull(new NFFinalidadeTransformer().read("0"));
        Assert.assertEquals(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_RELEVANTE, new NFIndicadorEscalaRelevanteTransformer().read("S"));
        Assert.assertEquals(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_NAO_RELEVANTE, new NFIndicadorEscalaRelevanteTransformer().read("N"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assert.assertEquals("S", new NFIndicadorEscalaRelevanteTransformer().write(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_RELEVANTE));
        Assert.assertEquals("N", new NFIndicadorEscalaRelevanteTransformer().write(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_NAO_RELEVANTE));
    }
}