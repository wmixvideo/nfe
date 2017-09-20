package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFRegimeTributario;

public class NFRegimeTributarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFRegimeTributario.SIMPLES_NACIONAL.getCodigo());
        Assert.assertEquals("2", NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA.getCodigo());
        Assert.assertEquals("3", NFRegimeTributario.NORMAL.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assert.assertEquals(NFRegimeTributario.SIMPLES_NACIONAL, NFRegimeTributario.valueOfCodigo("1"));
        Assert.assertEquals(NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA, NFRegimeTributario.valueOfCodigo("2"));
        Assert.assertEquals(NFRegimeTributario.NORMAL, NFRegimeTributario.valueOfCodigo("3"));
    }

    @Test
    public void deveObterNuloCasoNaoExistaCodigo() {
        Assert.assertNull(NFRegimeTributario.valueOfCodigo("4"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assert.assertEquals("1 - Simples nacional", NFRegimeTributario.SIMPLES_NACIONAL.toString());
    }
}