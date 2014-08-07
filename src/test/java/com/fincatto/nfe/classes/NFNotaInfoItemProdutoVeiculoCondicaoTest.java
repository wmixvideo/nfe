package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoVeiculoCondicaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFNotaInfoItemProdutoVeiculoCondicao.ACABADO.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemProdutoVeiculoCondicao.INACABADO.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemProdutoVeiculoCondicao.SEMI_ACABADO.getCodigo());
    }
}