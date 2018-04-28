package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoVeiculoCondicaoTest {

    @Test
    public void deveObterVeiculoCondicaoApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO, NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("1"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoCondicao.INACABADO, NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("2"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoCondicao.SEMI_ACABADO, NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("3"));
        Assert.assertNull(NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("4"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFNotaInfoItemProdutoVeiculoCondicao.ACABADO.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemProdutoVeiculoCondicao.INACABADO.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemProdutoVeiculoCondicao.SEMI_ACABADO.getCodigo());
    }
}