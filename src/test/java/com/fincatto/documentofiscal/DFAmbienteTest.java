package com.fincatto.documentofiscal;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFAmbienteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", DFAmbiente.PRODUCAO.getCodigo());
        Assertions.assertEquals("2", DFAmbiente.HOMOLOGACAO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("1 - Produ\u00e7\u00e3o", DFAmbiente.PRODUCAO.toString());
        Assertions.assertEquals("2 - Homologa\u00e7\u00e3o", DFAmbiente.HOMOLOGACAO.toString());

    }
}