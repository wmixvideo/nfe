package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFProcessoEmissor;

public class NFProcessoEmissorTest {

    @Test
    public void deveObterVeiculoCondicaoApartirDoSeuCodigo() {
        Assert.assertEquals(NFProcessoEmissor.CONTRIBUINTE, NFProcessoEmissor.valueOfCodigo("0"));
        Assert.assertEquals(NFProcessoEmissor.AVULSA_FISCO, NFProcessoEmissor.valueOfCodigo("1"));
        Assert.assertEquals(NFProcessoEmissor.AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO, NFProcessoEmissor.valueOfCodigo("2"));
        Assert.assertEquals(NFProcessoEmissor.CONTRIBUINTE_APLICATIVO_FISCO, NFProcessoEmissor.valueOfCodigo("3"));
        Assert.assertNull(NFProcessoEmissor.valueOfCodigo("4"));
    }

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFProcessoEmissor.CONTRIBUINTE.getCodigo());
        Assert.assertEquals("1", NFProcessoEmissor.AVULSA_FISCO.getCodigo());
        Assert.assertEquals("2", NFProcessoEmissor.AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO.getCodigo());
        Assert.assertEquals("3", NFProcessoEmissor.CONTRIBUINTE_APLICATIVO_FISCO.getCodigo());
    }

    @Test
    public void deveObterStringficadoCorretamente() {
        Assert.assertEquals("1 - Emiss\u00e3o de NF-e avulsa pelo Fisco", NFProcessoEmissor.AVULSA_FISCO.toString());
    }
}