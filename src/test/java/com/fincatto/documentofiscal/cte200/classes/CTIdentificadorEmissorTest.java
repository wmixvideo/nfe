package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTIdentificadorEmissorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTIdentificadorEmissor.CONTRIBUINTE_APLICATIVO.getCodigo());
        Assert.assertEquals("1", CTIdentificadorEmissor.FISCO_AVULSA.getCodigo());
        Assert.assertEquals("2", CTIdentificadorEmissor.CONTRIBUINTE_AVULSA.getCodigo());
        Assert.assertEquals("3", CTIdentificadorEmissor.FISCO_APLICATIVO.getCodigo());
    }
}
