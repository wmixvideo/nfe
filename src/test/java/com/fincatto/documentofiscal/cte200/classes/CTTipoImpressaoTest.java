package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoImpressaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", CTTipoImpressao.RETRATO.getCodigo());
        Assert.assertEquals("2", CTTipoImpressao.PAISAGEM.getCodigo());
    }
}
