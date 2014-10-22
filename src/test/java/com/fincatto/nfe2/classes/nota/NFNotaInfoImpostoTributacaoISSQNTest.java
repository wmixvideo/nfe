package com.fincatto.nfe2.classes.nota;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe2.classes.NFNotaInfoImpostoTributacaoISSQN;

public class NFNotaInfoImpostoTributacaoISSQNTest {

    @Test
    public void deveRetornarNuloAoPassarCodigoInvalido() {
        Assert.assertNull(NFNotaInfoImpostoTributacaoISSQN.valueOfCodigo(""));
    }

    @Test
    public void deveRetornarTributacaoISSQNaoPassarCodigoValido() {
        Assert.assertNotNull(NFNotaInfoImpostoTributacaoISSQN.valueOfCodigo(NFNotaInfoImpostoTributacaoISSQN.SUBSTITUTA.getCodigo()));
    }
}