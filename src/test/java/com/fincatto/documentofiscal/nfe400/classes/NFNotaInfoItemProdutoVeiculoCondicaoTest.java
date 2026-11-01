package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemProdutoVeiculoCondicaoTest {

    @Test
    public void deveObterVeiculoCondicaoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoCondicao.ACABADO, NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("1"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoCondicao.INACABADO, NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("2"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoCondicao.SEMI_ACABADO, NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("3"));
        Assertions.assertNull(NFNotaInfoItemProdutoVeiculoCondicao.valueOfCodigo("4"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFNotaInfoItemProdutoVeiculoCondicao.ACABADO.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoItemProdutoVeiculoCondicao.INACABADO.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoItemProdutoVeiculoCondicao.SEMI_ACABADO.getCodigo());
    }
}