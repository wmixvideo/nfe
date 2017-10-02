package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoEntregaDataTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTTipoEntregaData.SEM_DATA.getCodigo());
        Assert.assertEquals("1", CTTipoEntregaData.NA_DATA.getCodigo());
        Assert.assertEquals("2", CTTipoEntregaData.ATE_DATA.getCodigo());
        Assert.assertEquals("3", CTTipoEntregaData.A_PARTIR_DATA.getCodigo());
        Assert.assertEquals("4", CTTipoEntregaData.NO_PERIODO.getCodigo());
    }
}
