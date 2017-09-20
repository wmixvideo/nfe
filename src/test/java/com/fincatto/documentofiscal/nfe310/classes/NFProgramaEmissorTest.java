package com.fincatto.documentofiscal.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.NFProcessoEmissor;

public class NFProgramaEmissorTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", NFProcessoEmissor.CONTRIBUINTE.getCodigo());
        Assert.assertEquals("1", NFProcessoEmissor.AVULSA_FISCO.getCodigo());
        Assert.assertEquals("2", NFProcessoEmissor.AVULSA_CONTRIBUINTE_COM_CERTIFICADO_DIGITAL_FISCO.getCodigo());
        Assert.assertEquals("3", NFProcessoEmissor.CONTRIBUINTE_APLICATIVO_FISCO.getCodigo());
    }
}