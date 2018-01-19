package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoArmamentoTipoTest {

    @Test
    public void deveObterArmementoTipoDeAcordoComOCodigo() {
        Assert.assertEquals(NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO, NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo("0"));
        Assert.assertEquals(NFNotaInfoItemProdutoArmamentoTipo.RESTRITO, NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo("1"));
        Assert.assertNull(NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO.getCodigo());
        Assert.assertEquals("1", NFNotaInfoItemProdutoArmamentoTipo.RESTRITO.getCodigo());
    }
}