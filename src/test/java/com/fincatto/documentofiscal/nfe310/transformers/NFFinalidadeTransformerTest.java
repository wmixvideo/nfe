package com.fincatto.documentofiscal.nfe310.transformers;

import com.fincatto.documentofiscal.nfe310.classes.NFFinalidade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFFinalidadeTransformerTest {
    @Test
    public void deveTestarLeitura() throws Exception {
        Assertions.assertNull(new NFFinalidadeTransformer().read("0"));
        Assertions.assertEquals(NFFinalidade.NORMAL, new NFFinalidadeTransformer().read("1"));
        Assertions.assertEquals(NFFinalidade.COMPLEMENTAR, new NFFinalidadeTransformer().read("2"));
        Assertions.assertEquals(NFFinalidade.AJUSTE, new NFFinalidadeTransformer().read("3"));
        Assertions.assertEquals(NFFinalidade.DEVOLUCAO_OU_RETORNO, new NFFinalidadeTransformer().read("4"));
    }

    @Test
    public void deveTestarEscrita() throws Exception {
        Assertions.assertEquals("1", new NFFinalidadeTransformer().write(NFFinalidade.NORMAL));
        Assertions.assertEquals("2", new NFFinalidadeTransformer().write(NFFinalidade.COMPLEMENTAR));
        Assertions.assertEquals("3", new NFFinalidadeTransformer().write(NFFinalidade.AJUSTE));
        Assertions.assertEquals("4", new NFFinalidadeTransformer().write(NFFinalidade.DEVOLUCAO_OU_RETORNO));
    }
}