package com.fincatto.nfe200.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFTipoImpressao;

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