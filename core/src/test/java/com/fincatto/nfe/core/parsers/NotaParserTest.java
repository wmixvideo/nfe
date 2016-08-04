package com.fincatto.nfe.core.parsers;

import com.fincatto.nfe.core.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;

public class NotaParserTest {

    @Test
    public void deveParsearCorretamenteUmXMLDaNota310() {
        final String xmlNota = FabricaDeObjetosFake.getNFNota().toString();
        Assert.assertNotNull(new NotaParser().notaParaObjeto(xmlNota));
    }

    @Test
    public void deveParsearCorretamenteArquivoDaNota310() throws Exception {
        Assert.assertNotNull(new NotaParser().notaParaObjeto(new File(new URI(NotaParserTest.class.getResource("nota.xml").getFile()).getPath())));
    }

    @Test
    public void deveParsearCorretamenteUmXMLDaNotaProcessada310() {
        final String xmlNota = FabricaDeObjetosFake.getNFNotaProcessada().toString();
        Assert.assertNotNull(new NotaParser().notaProcessadaParaObjeto(xmlNota));
    }

    @Test
    public void deveParsearCorretamenteArquivoDaNotaProcessada310() throws Exception {
        Assert.assertNotNull(new NotaParser().notaProcessadaParaObjeto(new File(new URI(NotaParserTest.class.getResource("notaprocessada.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmArquivoInvalidoParaNotaProcessada() {
        new NotaParser().notaProcessadaParaObjeto(new File(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmArquivoInvalidoParaNota() {
        new NotaParser().notaParaObjeto(new File(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaNotaProcessada() {
        new NotaParser().notaProcessadaParaObjeto("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaNota() {
        new NotaParser().notaParaObjeto("");
    }
}