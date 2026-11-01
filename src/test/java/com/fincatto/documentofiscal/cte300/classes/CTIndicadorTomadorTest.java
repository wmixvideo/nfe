package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTIndicadorTomadorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTIndicadorTomador.valueOfCodigo(null));
    	Assertions.assertEquals("1", CTIndicadorTomador.CONTRIBUINTE_ICMS.getCodigo());
    	Assertions.assertEquals("2", CTIndicadorTomador.CONTRIBUINTE_ISENTO.getCodigo());
        Assertions.assertEquals("9", CTIndicadorTomador.NAO_CONTRIBUINTE.getCodigo());
    }

}
