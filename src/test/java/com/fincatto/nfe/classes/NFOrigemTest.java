package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFOrigemTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFOrigem.NACIONAL.getCodigo());
        Assert.assertEquals("1", NFOrigem.ESTRANGEIRA_IMPORTACAO_DIRETA.getCodigo());
        Assert.assertEquals("2", NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO.getCodigo());
    }
}