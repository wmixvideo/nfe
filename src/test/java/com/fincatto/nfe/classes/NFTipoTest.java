package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFTipo.ENTRADA.getCodigo());
        Assert.assertEquals("1", NFTipo.SAIDA.getCodigo());
    }
}