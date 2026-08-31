package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFFormaPagamentoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFFormaPagamentoPrazo.A_VISTA.getCodigo());
        Assertions.assertEquals("1", NFFormaPagamentoPrazo.A_PRAZO.getCodigo());
        Assertions.assertEquals("2", NFFormaPagamentoPrazo.OUTROS.getCodigo());
    }
}