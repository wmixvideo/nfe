package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoImpressaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", CTTipoImpressao.RETRATO.getCodigo());
        Assertions.assertEquals("2", CTTipoImpressao.PAISAGEM.getCodigo());
    }
}
