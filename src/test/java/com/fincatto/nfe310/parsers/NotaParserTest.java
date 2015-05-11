package com.fincatto.nfe310.parsers;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;

public class NotaParserTest {

    @Test
    public void deveParsearCorretamenteUmXMLDaNota310() {
        final String xmlNota = FabricaDeObjetosFake.getNFNota().toString();
        Assert.assertNotNull(new NotaParser().notaParaObjeto(xmlNota));
    }

    @Test
    public void deveParsearCorretamenteUmXMLDaNotaProcessada310() {
        final String xmlNota = FabricaDeObjetosFake.getNFNotaProcessada().toString();
        Assert.assertNotNull(new NotaParser().notaProcessadaParaObjeto(xmlNota));
    }
}