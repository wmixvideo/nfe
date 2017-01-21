package com.fincatto.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFAmbienteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFAmbiente.PRODUCAO.getCodigo());
        Assert.assertEquals("2", NFAmbiente.HOMOLOGACAO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("1 - Produ\u00e7\u00e3o", NFAmbiente.PRODUCAO.toString());
    }
}