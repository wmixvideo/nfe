package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoVeiculoRestricaoTest {

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