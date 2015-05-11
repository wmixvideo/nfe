package com.fincatto.nfe310.parsers;

import java.io.File;

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
    public void deveParsearCorretamenteArquivoDaNota310() {
        Assert.assertNotNull(new NotaParser().notaParaObjeto(new File(NotaParserTest.class.getResource("nota.xml").getFile())));
    }

    @Test
    public void deveParsearCorretamenteUmXMLDaNotaProcessada310() {
        final String xmlNota = FabricaDeObjetosFake.getNFNotaProcessada().toString();
        Assert.assertNotNull(new NotaParser().notaProcessadaParaObjeto(xmlNota));
    }

    @Test
    public void deveParsearCorretamenteArquivoDaNotaProcessada310() {
        Assert.assertNotNull(new NotaParser().notaProcessadaParaObjeto(new File(NotaParserTest.class.getResource("notaprocessada.xml").getFile())));
    }
}