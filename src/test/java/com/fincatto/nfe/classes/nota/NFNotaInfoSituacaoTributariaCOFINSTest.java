package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoSituacaoTributariaCOFINSTest {

    @Test
    public void deveRetornarSituacaotributariaCOFINSAoPassarCodigoValido() {
        Assert.assertNotNull(NFNotaInfoSituacaoTributariaCOFINS.valueOfCodigo("01"));
    }

    @Test
    public void deveRetornarNuloCasoPasseValorInvalido() {
        Assert.assertNull(NFNotaInfoSituacaoTributariaCOFINS.valueOfCodigo("00"));
    }
}