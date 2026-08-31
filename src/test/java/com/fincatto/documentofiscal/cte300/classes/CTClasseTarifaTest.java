package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CTClasseTarifaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTClasseTarifa.valueOfCodigo(null));
        Assertions.assertEquals("M", CTClasseTarifa.MINIMA.getCodigo());
        Assertions.assertEquals("G", CTClasseTarifa.GERAL.getCodigo());
        Assertions.assertEquals("E", CTClasseTarifa.ESPECIFICA.getCodigo());
    }

}
