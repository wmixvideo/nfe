package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemModalidadeBCICMSSTTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFNotaInfoItemModalidadeBCICMSST.PRECO_TABELADO.getCodigo());
        Assertions.assertEquals("1", NFNotaInfoItemModalidadeBCICMSST.LISTA_NEGATIVA.getCodigo());
        Assertions.assertEquals("2", NFNotaInfoItemModalidadeBCICMSST.LISTA_POSITIVA.getCodigo());
        Assertions.assertEquals("3", NFNotaInfoItemModalidadeBCICMSST.LISTA_NEUTRA.getCodigo());
        Assertions.assertEquals("4", NFNotaInfoItemModalidadeBCICMSST.MARGEM_VALOR_AGREGADO.getCodigo());
        Assertions.assertEquals("5", NFNotaInfoItemModalidadeBCICMSST.PAUTA.getCodigo());
    }
}