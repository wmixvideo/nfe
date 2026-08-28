package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTTipoTrafegoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTTipoTrafego.valueOfCodigo(null));
    	Assertions.assertEquals("0", CTTipoTrafego.PROPRIO.getCodigo());
    	Assertions.assertEquals("1", CTTipoTrafego.MUTUO.getCodigo());
    	Assertions.assertEquals("2", CTTipoTrafego.RODOFERROVIARIO.getCodigo());
    	Assertions.assertEquals("3", CTTipoTrafego.RODOVIARIO.getCodigo());
	}

}
