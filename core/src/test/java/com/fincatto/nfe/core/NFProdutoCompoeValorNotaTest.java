package com.fincatto.nfe.core;

import org.junit.Assert;
import org.junit.Test;

public class NFProdutoCompoeValorNotaTest {

    @Test
    public void deveObterProdutoCampoValorNotaApartirDoSeuCodigo() {
        Assert.assertEquals(NFProdutoCompoeValorNota.NAO, NFProdutoCompoeValorNota.valueOfCodigo("0"));
        Assert.assertEquals(NFProdutoCompoeValorNota.SIM, NFProdutoCompoeValorNota.valueOfCodigo("1"));
        Assert.assertNull(NFProdutoCompoeValorNota.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFProdutoCompoeValorNota.NAO.getCodigo());
        Assert.assertEquals("1", NFProdutoCompoeValorNota.SIM.getCodigo());
    }
}