package com.fincatto.documentofiscal.cte400.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTTipoRegimeTributarioTest {


    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertNull(CTTipoRegimeTributario.valueOfCodigo(null));
        Assert.assertEquals("1", CTTipoRegimeTributario.SIMPLES_NACIONAL.getCodigo());
        Assert.assertEquals("2", CTTipoRegimeTributario.SIMPLES_NACIONAL_EXCESSO_SUBLIME_RECEITA_BRUTA.getCodigo());
        Assert.assertEquals("3", CTTipoRegimeTributario.REGIME_NORMAL.getCodigo());
    }

}