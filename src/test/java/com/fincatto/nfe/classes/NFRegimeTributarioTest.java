package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFRegimeTributarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFRegimeTributario.SIMPLES_NACIONAL.getCodigo());
        Assert.assertEquals("2", NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA.getCodigo());
        Assert.assertEquals("3", NFRegimeTributario.NORMAL.getCodigo());
    }
}