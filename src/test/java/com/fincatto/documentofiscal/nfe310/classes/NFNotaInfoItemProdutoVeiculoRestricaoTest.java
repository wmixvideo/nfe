package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemProdutoVeiculoRestricaoTest {

    @Test
    public void deveObterProdutoVeiculoRestricaoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.NAO_HA, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("0"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.ALIENACAO_FIDUCIARIA, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("1"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.ARRENDAMENTO_MERCANTIL, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("2"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.RESERVA_DOMINIO, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("3"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.PENHOR, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("4"));
        Assertions.assertEquals(NFNotaInfoItemProdutoVeiculoRestricao.OUTRAS, NFNotaInfoItemProdutoVeiculoRestricao.valueOfCodigo("9"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFNotaInfoItemProdutoVeiculoRestricao.NAO_HA.getCodigo());
        Assertions.assertEquals("1", NFNotaInfoItemProdutoVeiculoRestricao.ALIENACAO_FIDUCIARIA.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoItemProdutoVeiculoRestricao.ARRENDAMENTO_MERCANTIL.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoItemProdutoVeiculoRestricao.RESERVA_DOMINIO.getCodigo());
        Assertions.assertEquals("4", NFNotaInfoItemProdutoVeiculoRestricao.PENHOR.getCodigo());
        Assertions.assertEquals("9", NFNotaInfoItemProdutoVeiculoRestricao.OUTRAS.getCodigo());
    }
}