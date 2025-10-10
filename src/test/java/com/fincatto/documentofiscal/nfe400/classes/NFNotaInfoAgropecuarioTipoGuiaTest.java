package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NFNotaInfoAgropecuarioTipoGuiaTest {

    @Test
    public void deveRetornarEnumCorretoParaCodigoValido() {
        assertEquals(NFNotaInfoAgropecuarioTipoGuia.GTA, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("1"));
        assertEquals(NFNotaInfoAgropecuarioTipoGuia.TTA, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("2"));
        assertEquals(NFNotaInfoAgropecuarioTipoGuia.DTA, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("3"));
        assertEquals(NFNotaInfoAgropecuarioTipoGuia.ATV, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("4"));
        assertEquals(NFNotaInfoAgropecuarioTipoGuia.PTV, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("5"));
        assertEquals(NFNotaInfoAgropecuarioTipoGuia.GTV, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("6"));
        assertEquals(NFNotaInfoAgropecuarioTipoGuia.GUIA_FLORESTAL, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("7"));
    }

    @Test
    public void deveRetornarNullParaCodigoInvalidoOuNulo() {
        assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("0"));
        assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("8"));
        assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo(null));
        assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo(""));
    }

    @Test
    public void deveRetornarToStringFormatadoCorretamente() {
        assertEquals("1 - Guia de Trânsito Animal", NFNotaInfoAgropecuarioTipoGuia.GTA.toString());
        assertEquals("7 - Guia Florestal (DOF, SisFlora - PA e MT ou SIAM - MG)", NFNotaInfoAgropecuarioTipoGuia.GUIA_FLORESTAL.toString());
    }
}