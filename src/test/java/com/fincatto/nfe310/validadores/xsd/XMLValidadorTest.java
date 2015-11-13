package com.fincatto.nfe310.validadores.xsd;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;

public class XMLValidadorTest {

    @Test
    public void deveValidarLote() throws Exception {
        Assert.assertTrue(XMLValidador.validaLote(FabricaDeObjetosFake.getNFLoteEnvio().toString()));
    }

    @Test
    public void deveValidarNota() throws Exception {
        Assert.assertTrue(XMLValidador.validaNota(FabricaDeObjetosFake.getNFNota().toString()));
    }
}