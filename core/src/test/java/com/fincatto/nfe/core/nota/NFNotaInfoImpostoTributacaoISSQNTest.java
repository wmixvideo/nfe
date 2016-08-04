package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.NFNotaInfoImpostoTributacaoISSQN;
import org.junit.Assert;
import org.junit.Test;

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