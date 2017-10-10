package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTUnidadeMedidaTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("00", CTUnidadeMedida.M3.getCodigo());
        Assert.assertEquals("01", CTUnidadeMedida.KG.getCodigo());
        Assert.assertEquals("02", CTUnidadeMedida.TON.getCodigo());
        Assert.assertEquals("03", CTUnidadeMedida.UNIDADE.getCodigo());
        Assert.assertEquals("04", CTUnidadeMedida.LITRO.getCodigo());
        Assert.assertEquals("05", CTUnidadeMedida.MMBTU.getCodigo());
    }

}
