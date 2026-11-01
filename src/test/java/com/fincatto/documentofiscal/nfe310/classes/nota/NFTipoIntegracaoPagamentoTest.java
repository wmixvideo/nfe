package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFTipoIntegracaoPagamentoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assertions.assertEquals(NFTipoIntegracaoPagamento.INTEGRADO, NFTipoIntegracaoPagamento.valueOfCodigo("1"));
        Assertions.assertEquals(NFTipoIntegracaoPagamento.SEPARADO, NFTipoIntegracaoPagamento.valueOfCodigo("2"));
        Assertions.assertNull(NFTipoIntegracaoPagamento.valueOfCodigo("3"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFTipoIntegracaoPagamento.INTEGRADO.getCodigo());
        Assertions.assertEquals("2", NFTipoIntegracaoPagamento.SEPARADO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assertions.assertEquals("1 - Integrado", NFTipoIntegracaoPagamento.INTEGRADO.toString());
    }
}