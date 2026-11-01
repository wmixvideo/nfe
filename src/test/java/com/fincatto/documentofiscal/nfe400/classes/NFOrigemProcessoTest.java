package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFOrigemProcessoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assertions.assertEquals("0", NFOrigemProcesso.SEFAZ.getCodigo());
        Assertions.assertEquals("1", NFOrigemProcesso.JUSTICA_FEDERAL.getCodigo());
        Assertions.assertEquals("2", NFOrigemProcesso.JUSTICA_ESTADUAL.getCodigo());
        Assertions.assertEquals("3", NFOrigemProcesso.SECEX_RFB.getCodigo());
        Assertions.assertEquals("4", NFOrigemProcesso.CONFAZ.getCodigo());
    }

    @Test
    public void deveRetornarNuloAoPassarCodigoInvalido() {
        Assertions.assertNull(NFOrigemProcesso.valueOfCodigo(""));
    }

    @Test
    public void deveRetornarOrigemProcessoAoPassarCodigoValido() {
        Assertions.assertNotNull(NFOrigemProcesso.valueOfCodigo(NFOrigemProcesso.JUSTICA_ESTADUAL.getCodigo()));
    }

    @Test
    public void deveRetornarStringficadoCorretamente() {
        Assertions.assertEquals("2 - Justi\u00e7a Estadual", NFOrigemProcesso.JUSTICA_ESTADUAL.toString());
    }
}