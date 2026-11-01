package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemModalidadeBCICMSTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFNotaInfoItemModalidadeBCICMS.MVA.getCodigo());
        Assertions.assertEquals("1", NFNotaInfoItemModalidadeBCICMS.PAUTA.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoItemModalidadeBCICMS.PRECO_TABELADO_MAXIMO.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoItemModalidadeBCICMS.VALOR_OPERACAO.getCodigo());
    }
}