package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTRetiradaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTRetirada.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTRetirada.SIM.getCodigo());
    	Assertions.assertEquals("1", CTRetirada.NAO.getCodigo());
    }

}
