package com.fincatto.documentofiscal;

import org.junit.Assert;
import org.junit.Test;

public class DFAmbienteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", DFAmbiente.PRODUCAO.getCodigo());
        Assert.assertEquals("2", DFAmbiente.HOMOLOGACAO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("1 - Produ\u00e7\u00e3o", DFAmbiente.PRODUCAO.toString());
        Assert.assertEquals("2 - Homologa\u00e7\u00e3o", DFAmbiente.HOMOLOGACAO.toString());

    }
}