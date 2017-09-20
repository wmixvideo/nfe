package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFFormaPagamentoPrazo;

public class NFFormaPagamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFFormaPagamentoPrazo.A_VISTA.getCodigo());
        Assert.assertEquals("1", NFFormaPagamentoPrazo.A_PRAZO.getCodigo());
        Assert.assertEquals("2", NFFormaPagamentoPrazo.OUTROS.getCodigo());
    }
}