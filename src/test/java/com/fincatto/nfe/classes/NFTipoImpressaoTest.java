package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoImpressaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFTipoImpressao.RETRATO.getCodigo());
        Assert.assertEquals("2", NFTipoImpressao.PAISAGEM.getCodigo());
    }
}