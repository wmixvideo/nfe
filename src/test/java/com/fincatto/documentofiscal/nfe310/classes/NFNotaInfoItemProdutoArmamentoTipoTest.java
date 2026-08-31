package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemProdutoArmamentoTipoTest {

    @Test
    public void deveObterArmementoTipoDeAcordoComOCodigo() {
        Assertions.assertEquals(NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO, NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo("0"));
        Assertions.assertEquals(NFNotaInfoItemProdutoArmamentoTipo.RESTRITO, NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo("1"));
        Assertions.assertNull(NFNotaInfoItemProdutoArmamentoTipo.valueOfCodigo("2"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFNotaInfoItemProdutoArmamentoTipo.PERMITIDO.getCodigo());
        Assertions.assertEquals("1", NFNotaInfoItemProdutoArmamentoTipo.RESTRITO.getCodigo());
    }
}