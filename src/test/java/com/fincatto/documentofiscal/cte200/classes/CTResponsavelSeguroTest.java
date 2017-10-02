package com.fincatto.documentofiscal.cte200.classes;

import org.junit.Assert;
import org.junit.Test;

public class CTResponsavelSeguroTest {

    @Test
    public void deveRepresentarOCodigoCorretamente() {
        Assert.assertEquals("0", CTResponsavelSeguro.REMETENTE.getCodigo());
        Assert.assertEquals("1", CTResponsavelSeguro.EXPEDIDOR.getCodigo());
        Assert.assertEquals("2", CTResponsavelSeguro.RECEBEDOR.getCodigo());
        Assert.assertEquals("3", CTResponsavelSeguro.DESTINATARIO.getCodigo());
        Assert.assertEquals("4", CTResponsavelSeguro.EMITENTE.getCodigo());
        Assert.assertEquals("5", CTResponsavelSeguro.TOMADOR.getCodigo());
    }
}
