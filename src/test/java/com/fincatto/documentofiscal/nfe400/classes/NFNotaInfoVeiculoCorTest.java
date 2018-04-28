package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoVeiculoCorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("01", NFNotaInfoVeiculoCor.AMARELA.getCodigo());
        Assert.assertEquals("02", NFNotaInfoVeiculoCor.AZUL.getCodigo());
        Assert.assertEquals("03", NFNotaInfoVeiculoCor.BEGE.getCodigo());
        Assert.assertEquals("04", NFNotaInfoVeiculoCor.BRANCA.getCodigo());
        Assert.assertEquals("05", NFNotaInfoVeiculoCor.CINZA.getCodigo());
        Assert.assertEquals("06", NFNotaInfoVeiculoCor.DOURADA.getCodigo());
        Assert.assertEquals("07", NFNotaInfoVeiculoCor.GRENA.getCodigo());
        Assert.assertEquals("08", NFNotaInfoVeiculoCor.LARANJA.getCodigo());
        Assert.assertEquals("09", NFNotaInfoVeiculoCor.MARROM.getCodigo());
        Assert.assertEquals("10", NFNotaInfoVeiculoCor.PRATA.getCodigo());
        Assert.assertEquals("11", NFNotaInfoVeiculoCor.PRETA.getCodigo());
        Assert.assertEquals("12", NFNotaInfoVeiculoCor.ROSA.getCodigo());
        Assert.assertEquals("13", NFNotaInfoVeiculoCor.ROXA.getCodigo());
        Assert.assertEquals("14", NFNotaInfoVeiculoCor.VERDE.getCodigo());
        Assert.assertEquals("15", NFNotaInfoVeiculoCor.VERMELHA.getCodigo());
        Assert.assertEquals("16", NFNotaInfoVeiculoCor.FANTASIA.getCodigo());
    }
}