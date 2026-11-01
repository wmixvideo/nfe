package com.fincatto.documentofiscal.cte200.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTModalTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("01", CTModal.RODOVIARIO.getCodigo());
        Assertions.assertEquals("02", CTModal.AEREO.getCodigo());
        Assertions.assertEquals("03", CTModal.AQUAVIARIO.getCodigo());
        Assertions.assertEquals("04", CTModal.FERROVIARIO.getCodigo());
        Assertions.assertEquals("05", CTModal.DUTOVIARIO.getCodigo());
        Assertions.assertEquals("06", CTModal.MULTIMODAL.getCodigo());
    }

}
