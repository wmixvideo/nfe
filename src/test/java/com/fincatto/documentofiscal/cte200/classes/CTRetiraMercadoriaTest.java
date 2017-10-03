package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTRetiraMercadoriaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTRetiraMercadoria.SIM.getCodigo());
        Assert.assertEquals("1", CTRetiraMercadoria.NAO.getCodigo());
    }

}
