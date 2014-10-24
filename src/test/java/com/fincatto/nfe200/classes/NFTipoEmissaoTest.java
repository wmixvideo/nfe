package com.fincatto.nfe200.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.classes.NFTipoEmissao;

public class NFTipoEmissaoTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("1", NFTipoEmissao.NORMAL.getCodigo());
        Assert.assertEquals("2", NFTipoEmissao.CONTINGENCIA_FS.getCodigo());
        Assert.assertEquals("3", NFTipoEmissao.CONTINGENCIA_SCAN.getCodigo());
        Assert.assertEquals("4", NFTipoEmissao.CONTINGENCIA_DPEC.getCodigo());
        Assert.assertEquals("5", NFTipoEmissao.CONTINGENCIA_FSDA.getCodigo());
        Assert.assertEquals("6", NFTipoEmissao.CONTINGENCIA_SVCAN.getCodigo());
        Assert.assertEquals("7", NFTipoEmissao.CONTINGENCIA_SVCRS.getCodigo());
    }
}