package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTIndicadoNegociavelTest {


    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assert.assertNull(CTIndicadoNegociavel.valueOfCodigo(null));
    	Assert.assertEquals("0", CTIndicadoNegociavel.NAO_NEGOCIAVEL.getCodigo());
    	Assert.assertEquals("1", CTIndicadoNegociavel.NEGOCIAVEL.getCodigo());
    }

}
