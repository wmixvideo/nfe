package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.classes.NFNotaInfoItemProdutoArmamentoTipo;

public class NFNotaInfoItemProdutoArmamentoTipoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemProdutoArmamentoTipo.RESTRITO.getCodigo());
    }
}