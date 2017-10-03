package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoCteTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTTipoCte.NORMAL.getCodigo());
        Assert.assertEquals("1", CTTipoCte.COMPLEMENTO.getCodigo());
        Assert.assertEquals("2", CTTipoCte.ANULACAO.getCodigo());
        Assert.assertEquals("3", CTTipoCte.SUBSTITUTO.getCodigo());
    }

}
