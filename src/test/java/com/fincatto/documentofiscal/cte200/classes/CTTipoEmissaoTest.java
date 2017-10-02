package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoEmissaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", CTTipoEmissao.NORMAL.getCodigo());
        Assert.assertEquals("4", CTTipoEmissao.EPEC_SVC.getCodigo());
        Assert.assertEquals("5", CTTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
        Assert.assertEquals("7", CTTipoEmissao.AUTORIZACAO_SVCRS.getCodigo());
        Assert.assertEquals("8", CTTipoEmissao.AUTORIZACAO_SVCSP.getCodigo());
    }

}
