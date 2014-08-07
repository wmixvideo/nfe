package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoVeiculoTipoOperacaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_CONCESSIONARIA.getCodigo());
        Assert.assertEquals("2", NFNotaInfoItemProdutoVeiculoTipoOperacao.FATURAMENTO_DIRETO_CONSUMIDOR_FINAL.getCodigo());
        Assert.assertEquals("3", NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_DIRETA_GRANDES_CONSUMIDORES.getCodigo());
    }
}