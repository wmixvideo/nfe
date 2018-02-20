package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoVeiculoTipoOperacaoTest {

    @Test
    public void deveObterProdutoVeiculoTipoOperacaoApartirDoSeuCodigo() {
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("0"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_CONCESSIONARIA, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("1"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.FATURAMENTO_DIRETO_CONSUMIDOR_FINAL, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("2"));
        Assert.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_DIRETA_GRANDES_CONSUMIDORES, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("3"));
        Assert.assertNull(NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("4"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_CONCESSIONARIA.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemProdutoVeiculoTipoOperacao.FATURAMENTO_DIRETO_CONSUMIDOR_FINAL.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_DIRETA_GRANDES_CONSUMIDORES.getCodigo());
    }
}