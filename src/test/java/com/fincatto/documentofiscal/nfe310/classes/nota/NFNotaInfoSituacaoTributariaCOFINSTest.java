package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaCOFINS;

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