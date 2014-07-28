package com.fincatto.nfe.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class NFModalidadeFreteTest {

    @Test
    public void deveRetornarNuloAoPassarCodigoInvalido() {
        Assert.assertNull(NFModalidadeFrete.valueOfCodigo(""));
    }

    @Test
    public void deveRetornarModalidadeFreteAoPassarCodigoValido() {
        Assert.assertNotNull(NFModalidadeFrete.valueOfCodigo(NFModalidadeFrete.POR_CONTA_DE_TERCEIROS.getCodigo()));
    }
}