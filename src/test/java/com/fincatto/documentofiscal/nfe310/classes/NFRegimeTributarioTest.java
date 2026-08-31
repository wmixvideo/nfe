package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFRegimeTributarioTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("1", NFRegimeTributario.SIMPLES_NACIONAL.getCodigo());
        Assertions.assertEquals("2", NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA.getCodigo());
        Assertions.assertEquals("3", NFRegimeTributario.NORMAL.getCodigo());
    }

    @Test
    public void deveObterPeloCodigoCorretamente() {
        Assertions.assertEquals(NFRegimeTributario.SIMPLES_NACIONAL, NFRegimeTributario.valueOfCodigo("1"));
        Assertions.assertEquals(NFRegimeTributario.SIMPLES_NACIONAL_EXCESSO_RECEITA, NFRegimeTributario.valueOfCodigo("2"));
        Assertions.assertEquals(NFRegimeTributario.NORMAL, NFRegimeTributario.valueOfCodigo("3"));
    }

    @Test
    public void deveObterNuloCasoNaoExistaCodigo() {
        Assertions.assertNull(NFRegimeTributario.valueOfCodigo("4"));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assertions.assertEquals("1 - Simples nacional", NFRegimeTributario.SIMPLES_NACIONAL.toString());
    }
}