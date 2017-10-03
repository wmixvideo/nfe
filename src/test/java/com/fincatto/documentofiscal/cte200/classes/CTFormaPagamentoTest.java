package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTFormaPagamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTFormaPagamento.PAGO.getCodigo());
        Assert.assertEquals("1", CTFormaPagamento.A_PAGAR.getCodigo());
        Assert.assertEquals("2", CTFormaPagamento.OUTROS.getCodigo());
    }

}
