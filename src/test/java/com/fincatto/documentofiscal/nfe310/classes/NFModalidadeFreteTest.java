package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFModalidadeFreteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFModalidadeFrete.POR_CONTA_DO_EMITENTE.getCodigo());
        Assertions.assertEquals("1", NFModalidadeFrete.POR_CONTA_DO_DESTINATARIO_REMETENTE.getCodigo());
        Assertions.assertEquals("2", NFModalidadeFrete.POR_CONTA_DE_TERCEIROS.getCodigo());
        Assertions.assertEquals("9", NFModalidadeFrete.SEM_FRETE.getCodigo());
    }
}
