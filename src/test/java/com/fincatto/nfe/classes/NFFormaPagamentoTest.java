package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFFormaPagamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFFormaPagamento.A_VISTA.getCodigo());
        Assert.assertEquals("1", NFFormaPagamento.A_PRAZO.getCodigo());
        Assert.assertEquals("2", NFFormaPagamento.OUTROS.getCodigo());
    }
}