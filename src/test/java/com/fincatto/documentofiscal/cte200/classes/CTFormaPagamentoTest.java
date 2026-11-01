package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTFormaPagamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTFormaPagamento.PAGO.getCodigo());
        Assertions.assertEquals("1", CTFormaPagamento.A_PAGAR.getCodigo());
        Assertions.assertEquals("2", CTFormaPagamento.OUTROS.getCodigo());
    }

}
