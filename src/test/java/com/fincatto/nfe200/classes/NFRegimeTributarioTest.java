package com.fincatto.nfe200.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFRegimeTributario;

public class NFRegimeTributarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFRegimeTributario.SIMPLES_NACIONAL.getCodigo());
        Assert.assertEquals("2", NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA.getCodigo());
        Assert.assertEquals("3", NFRegimeTributario.NORMAL.getCodigo());
    }
}