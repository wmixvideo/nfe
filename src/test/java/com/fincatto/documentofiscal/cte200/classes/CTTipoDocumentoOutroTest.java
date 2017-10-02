package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoDocumentoOutroTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("00", CTTipoDocumentoOutro.DECLARACAO.getCodigo());
        Assert.assertEquals("10", CTTipoDocumentoOutro.DUTOVIARIO.getCodigo());
        Assert.assertEquals("99", CTTipoDocumentoOutro.OUTROS.getCodigo());
    }

}
