package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoAgropecuarioTipoGuiaTest {

    @Test
    public void deveRetornarEnumCorretoParaCodigoValido() {
        Assertions.assertEquals(NFNotaInfoAgropecuarioTipoGuia.GTA, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("1"));
        Assertions.assertEquals(NFNotaInfoAgropecuarioTipoGuia.TTA, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("2"));
        Assertions.assertEquals(NFNotaInfoAgropecuarioTipoGuia.DTA, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("3"));
        Assertions.assertEquals(NFNotaInfoAgropecuarioTipoGuia.ATV, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("4"));
        Assertions.assertEquals(NFNotaInfoAgropecuarioTipoGuia.PTV, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("5"));
        Assertions.assertEquals(NFNotaInfoAgropecuarioTipoGuia.GTV, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("6"));
        Assertions.assertEquals(NFNotaInfoAgropecuarioTipoGuia.GUIA_FLORESTAL, NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("7"));
    }

    @Test
    public void deveRetornarNullParaCodigoInvalidoOuNulo() {
        Assertions.assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("0"));
        Assertions.assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo("8"));
        Assertions.assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo(null));
        Assertions.assertNull(NFNotaInfoAgropecuarioTipoGuia.valueOfCodigo(""));
    }

    @Test
    public void deveRetornarToStringFormatadoCorretamente() {
        Assertions.assertEquals("1 - Guia de Trânsito Animal", NFNotaInfoAgropecuarioTipoGuia.GTA.toString());
        Assertions.assertEquals("7 - Guia Florestal (DOF, SisFlora - PA e MT ou SIAM - MG)", NFNotaInfoAgropecuarioTipoGuia.GUIA_FLORESTAL.toString());
    }
}