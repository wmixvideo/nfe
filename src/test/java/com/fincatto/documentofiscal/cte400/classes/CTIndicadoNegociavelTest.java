package com.fincatto.documentofiscal.cte400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTIndicadoNegociavelTest {


    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTIndicadoNegociavel.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTIndicadoNegociavel.NAO_NEGOCIAVEL.getCodigo());
    	Assertions.assertEquals("1", CTIndicadoNegociavel.NEGOCIAVEL.getCodigo());
    }

}
