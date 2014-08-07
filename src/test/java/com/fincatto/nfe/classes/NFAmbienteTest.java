package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.NFAmbiente;

public class NFAmbienteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFAmbiente.PRODUCAO.getCodigo());
        Assert.assertEquals("2", NFAmbiente.HOMOLOGACAO.getCodigo());
    }
}