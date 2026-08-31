package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemProdutoVeiculoTipoOperacaoTest {

    @Test
    public void deveObterProdutoVeiculoTipoOperacaoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("0"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_CONCESSIONARIA, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("1"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.FATURAMENTO_DIRETO_CONSUMIDOR_FINAL, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("2"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_DIRETA_GRANDES_CONSUMIDORES, NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("3"));
        Assertions.assertNull(NFNotaInfoItemProdutoVeiculoTipoOperacao.valueOfCodigo("4"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFNotaInfoItemProdutoVeiculoTipoOperacao.OUTROS.getCodigo());
        Assertions.assertEquals("1", NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_CONCESSIONARIA.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoItemProdutoVeiculoTipoOperacao.FATURAMENTO_DIRETO_CONSUMIDOR_FINAL.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoItemProdutoVeiculoTipoOperacao.VENDA_DIRETA_GRANDES_CONSUMIDORES.getCodigo());
    }
}