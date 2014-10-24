package com.fincatto.nfe200.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFFormaPagamento;

public class NFFormaPagamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFFormaPagamento.A_VISTA.getCodigo());
        Assert.assertEquals("1", NFFormaPagamento.A_PRAZO.getCodigo());
        Assert.assertEquals("2", NFFormaPagamento.OUTROS.getCodigo());
    }
}