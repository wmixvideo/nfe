package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFRegimeTributarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFRegimeTributario.SIMPLES_NACIONAL.getCodigo());
        Assert.assertEquals("2", NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA.getCodigo());
        Assert.assertEquals("3", NFRegimeTributario.NORMAL.getCodigo());
        Assert.assertEquals("4", NFRegimeTributario.MEI.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assert.assertEquals(NFRegimeTributario.SIMPLES_NACIONAL, NFRegimeTributario.valueOfCodigo("1"));
        Assert.assertEquals(NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA, NFRegimeTributario.valueOfCodigo("2"));
        Assert.assertEquals(NFRegimeTributario.NORMAL, NFRegimeTributario.valueOfCodigo("3"));
        Assert.assertEquals(NFRegimeTributario.MEI, NFRegimeTributario.valueOfCodigo("4"));
    }

    @Test
    public void deveObterNuloCasoNaoExistaCodigo() {
        Assert.assertNull(NFRegimeTributario.valueOfCodigo("5"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assert.assertEquals("1 - Simples nacional", NFRegimeTributario.SIMPLES_NACIONAL.toString());
        Assert.assertEquals("2 - Simples nacional com excesso de sublimite da receita bruta", NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA.toString());
        Assert.assertEquals("3 - Regime normal", NFRegimeTributario.NORMAL.toString());
        Assert.assertEquals("4 - Simples Nacional - Microempreendedor Individual - MEI", NFRegimeTributario.MEI.toString());
    }
}