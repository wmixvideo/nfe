package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoISSQN;

public class NFNotaInfoImpostoTributacaoISSQNTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("I", NFNotaInfoImpostoTributacaoISSQN.ISENTA.getCodigo());
        Assert.assertEquals("S", NFNotaInfoImpostoTributacaoISSQN.SUBSTITUTA.getCodigo());
        Assert.assertEquals("N", NFNotaInfoImpostoTributacaoISSQN.NORMAL.getCodigo());
        Assert.assertEquals("R", NFNotaInfoImpostoTributacaoISSQN.RETIDA.getCodigo());
    }
}