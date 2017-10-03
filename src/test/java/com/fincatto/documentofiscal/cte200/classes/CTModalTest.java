package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTModalTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", CTModal.RODOVIARIO.getCodigo());
        Assert.assertEquals("02", CTModal.AEREO.getCodigo());
        Assert.assertEquals("03", CTModal.AQUAVIARIO.getCodigo());
        Assert.assertEquals("04", CTModal.FERROVIARIO.getCodigo());
        Assert.assertEquals("05", CTModal.DUTOVIARIO.getCodigo());
        Assert.assertEquals("06", CTModal.MULTIMODAL.getCodigo());
    }

}
