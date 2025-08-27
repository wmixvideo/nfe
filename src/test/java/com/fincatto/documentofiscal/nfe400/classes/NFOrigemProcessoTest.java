package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFOrigemProcessoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFOrigemProcesso.SEFAZ.getCodigo());
        Assert.assertEquals("1", NFOrigemProcesso.JUSTICA_FEDERAL.getCodigo());
        Assert.assertEquals("2", NFOrigemProcesso.JUSTICA_ESTADUAL.getCodigo());
        Assert.assertEquals("3", NFOrigemProcesso.SECEX_RFB.getCodigo());
        Assert.assertEquals("4", NFOrigemProcesso.CONFAZ.getCodigo());
    }

    @Test
    public void deveRetornarNuloAoPassarCodigoInvalido() {
        Assert.assertNull(NFOrigemProcesso.valueOfCodigo(""));
    }

    @Test
    public void deveRetornarOrigemProcessoAoPassarCodigoValido() {
        Assert.assertNotNull(NFOrigemProcesso.valueOfCodigo(NFOrigemProcesso.JUSTICA_ESTADUAL.getCodigo()));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assert.assertEquals("2 - Justi\u00e7a Estadual", NFOrigemProcesso.JUSTICA_ESTADUAL.toString());
    }
}