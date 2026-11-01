package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTRetiraMercadoriaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", CTRetiraMercadoria.SIM.getCodigo());
        Assertions.assertEquals("1", CTRetiraMercadoria.NAO.getCodigo());
    }

}
