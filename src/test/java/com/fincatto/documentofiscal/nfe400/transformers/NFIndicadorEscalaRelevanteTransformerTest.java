package com.fincatto.documentofiscal.nfe400.transformers;


import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorEscalaRelevante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFIndicadorEscalaRelevanteTransformerTest {

    @Test
    public void deveTestarLeitura() throws Exception {
        Assertions.assertNull(new NFFinalidadeTransformer().read("0"));
        Assertions.assertEquals(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_RELEVANTE, new NFIndicadorEscalaRelevanteTransformer().read("S"));
        Assertions.assertEquals(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_NAO_RELEVANTE, new NFIndicadorEscalaRelevanteTransformer().read("N"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assertions.assertEquals("S", new NFIndicadorEscalaRelevanteTransformer().write(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_RELEVANTE));
        Assertions.assertEquals("N", new NFIndicadorEscalaRelevanteTransformer().write(NFIndicadorEscalaRelevante.PRODUZIDO_EM_ESCALA_NAO_RELEVANTE));
    }
}