package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoOperacaoGovernamentalTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertNull(CTTipoOperacaoGovernamental.valueOfCodigo(null));
        Assertions.assertNull(CTTipoOperacaoGovernamental.valueOfCodigo("5"));
        Assertions.assertEquals("1", CTTipoOperacaoGovernamental.FORNECIMENTO_PAGAMENTO_POSTERIOR.getCodigo());
        Assertions.assertEquals("2", CTTipoOperacaoGovernamental.RECEBIMENTO_PAGAMENTO_REALIZADO.getCodigo());
        Assertions.assertEquals("3", CTTipoOperacaoGovernamental.FORNECIMENTO_PAGAMENTO_REALIZADO.getCodigo());
        Assertions.assertEquals("4", CTTipoOperacaoGovernamental.RECEBIMENTO_PAGAMENTO_POSTERIOR.getCodigo());
        Assertions.assertEquals(CTTipoOperacaoGovernamental.FORNECIMENTO_PAGAMENTO_REALIZADO, CTTipoOperacaoGovernamental.valueOfCodigo("3"));
    }

    @Test
    public void deveRepresentarToStringCorretamente() {
        Assertions.assertEquals("4 - Recebimento do pagamento com fornecimento posterior", CTTipoOperacaoGovernamental.RECEBIMENTO_PAGAMENTO_POSTERIOR.toString());
    }
}
