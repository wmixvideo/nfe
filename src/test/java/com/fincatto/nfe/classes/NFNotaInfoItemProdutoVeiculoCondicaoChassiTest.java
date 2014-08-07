package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoVeiculoCondicaoChassiTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("N", NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL.getCodigo());
        Assert.assertEquals("R", NFNotaInfoItemProdutoVeiculoCondicaoChassi.REMARCADO.getCodigo());
    }
}