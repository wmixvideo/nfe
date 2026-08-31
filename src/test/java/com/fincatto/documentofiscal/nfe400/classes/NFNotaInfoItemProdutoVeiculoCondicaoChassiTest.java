package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemProdutoVeiculoCondicaoChassiTest {

    @Test
    public void deveObterVeiculoCondicaoChassiApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL, NFNotaInfoItemProdutoVeiculoCondicaoChassi.valueOfCodigo("N"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoCondicaoChassi.REMARCADO, NFNotaInfoItemProdutoVeiculoCondicaoChassi.valueOfCodigo("R"));
        Assertions.assertNull(NFNotaInfoItemProdutoVeiculoCondicaoChassi.valueOfCodigo("S"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("N", NFNotaInfoItemProdutoVeiculoCondicaoChassi.NORMAL.getCodigo());
        Assertions.assertEquals("R", NFNotaInfoItemProdutoVeiculoCondicaoChassi.REMARCADO.getCodigo());
    }
}