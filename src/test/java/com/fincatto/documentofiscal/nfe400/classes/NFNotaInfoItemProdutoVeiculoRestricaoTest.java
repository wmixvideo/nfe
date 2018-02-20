package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoVeiculoRestricaoTest {

    @Test
    public void deveObterProdutoVeiculoRestricaoApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.NAO_HA, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("0"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.ALIENACAO_FIDUCIARIA, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("1"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.ARRENDAMENTO_MERCANTIL, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("2"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.RESERVA_DOMINIO, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("3"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("4"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.OUTRAS, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("9"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemProdutoVeiculoRestricao.NAO_HA.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemProdutoVeiculoRestricao.ALIENACAO_FIDUCIARIA.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemProdutoVeiculoRestricao.ARRENDAMENTO_MERCANTIL.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemProdutoVeiculoRestricao.RESERVA_DOMINIO.getCodigo());
        Assert.assertEquals("4", NFNotaInfoItemProdutoVeiculoRestricao.PENHOR.getCodigo());
        Assert.assertEquals("9", NFNotaInfoItemProdutoVeiculoRestricao.OUTRAS.getCodigo());
    }
}