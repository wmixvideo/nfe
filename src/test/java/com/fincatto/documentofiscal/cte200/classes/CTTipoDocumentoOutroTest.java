package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoDocumentoOutroTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("00", CTTipoDocumentoOutro.DECLARACAO.getCodigo());
        Assertions.assertEquals("10", CTTipoDocumentoOutro.DUTOVIARIO.getCodigo());
        Assertions.assertEquals("99", CTTipoDocumentoOutro.OUTROS.getCodigo());
    }

}
