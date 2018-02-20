package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoIntegracaoPagamentoTest {

    @Test
    public void deveObterTipoApartirDoSeuCodigo() {
        Assert.assertEquals(NFTipoIntegracaoPagamento.INTEGRADO, NFTipoIntegracaoPagamento.valueOfCodigo("1"));
        Assert.assertEquals(NFTipoIntegracaoPagamento.SEPARADO, NFTipoIntegracaoPagamento.valueOfCodigo("2"));
        Assert.assertNull(NFTipoIntegracaoPagamento.valueOfCodigo("3"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFTipoIntegracaoPagamento.INTEGRADO.getCodigo());
        Assert.assertEquals("2", NFTipoIntegracaoPagamento.SEPARADO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("1 - Integrado", NFTipoIntegracaoPagamento.INTEGRADO.toString());
    }
}