package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFProdutoCompoeValorNotaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFProdutoCompoeValorNota.NAO.getCodigo());
        Assert.assertEquals("1", NFProdutoCompoeValorNota.SIM.getCodigo());
    }
}