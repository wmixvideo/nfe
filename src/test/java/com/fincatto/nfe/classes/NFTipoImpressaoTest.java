package com.fincatto.nfe.classes;

import org.junit.Assert;
import org.junit.Test;

public class NFTipoImpressaoTest {

    @Test
    public void deveObterImpressaoApartirDoSeuCodigo() {
        Assert.assertEquals(NFTipoImpressao.RETRATO, NFTipoImpressao.valueOfCodigo("1"));
        Assert.assertEquals(NFTipoImpressao.PAISAGEM, NFTipoImpressao.valueOfCodigo("2"));
        Assert.assertNull(NFTipoImpressao.valueOfCodigo("3"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFTipoImpressao.RETRATO.getCodigo());
        Assert.assertEquals("2", NFTipoImpressao.PAISAGEM.getCodigo());
    }
}