package com.fincatto.documentofiscal.cte300.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTModalTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
    	Assertions.assertNull(CTModal.valueOfCodigo(null));
    	Assertions.assertEquals("01", CTModal.RODOVIARIO.getCodigo());
    	Assertions.assertEquals("02", CTModal.AEREO.getCodigo());
    	Assertions.assertEquals("03", CTModal.AQUATICO.getCodigo());
    	Assertions.assertEquals("04", CTModal.FERROVIARIO.getCodigo());
    	Assertions.assertEquals("05", CTModal.DUTOVIARIO.getCodigo());
    	Assertions.assertEquals("06", CTModal.MULTIMODAL.getCodigo());
    }
}
