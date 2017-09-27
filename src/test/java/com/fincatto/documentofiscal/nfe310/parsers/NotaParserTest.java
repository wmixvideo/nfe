package com.fincatto.documentofiscal.nfe310.parsers;

import java.io.File;
import java.net.URI;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.parsers.NotaParser;

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

    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCartaCorrecao() {
        final String xmlNFEnviaEventoCartaCorrecao = FabricaDeObjetosFake.getNFEnviaEventoCartaCorrecao().toString();
        Assert.assertNotNull(new NotaParser().enviaEventoCartaCorrecaoParaObjeto(xmlNFEnviaEventoCartaCorrecao));
    }

    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCartaCorrecao() throws Exception {
        Assert.assertNotNull(new NotaParser().enviaEventoCartaCorrecaoParaObjeto(new File(new URI(NotaParserTest.class.getResource("enviaEventoCartaCorrecao.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaEnviaEventoCartaCorrecao() {
        new NotaParser().enviaEventoCartaCorrecaoParaObjeto("");
    }

    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCancelamento() {
        final String xmlNFEnviaEventoCancelamento = FabricaDeObjetosFake.getNFEnviaEventoCancelamento().toString();
        Assert.assertNotNull(new NotaParser().enviaEventoCancelamentoParaObjeto(xmlNFEnviaEventoCancelamento));
    }

    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCancelamento() throws Exception {
        Assert.assertNotNull(new NotaParser().enviaEventoCancelamentoParaObjeto(new File(new URI(NotaParserTest.class.getResource("enviaEventoCancelamento.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaEnviaEventoCancelamento() {
        new NotaParser().enviaEventoCancelamentoParaObjeto("");
    }

    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoInutilizacao() {
        final String xmlNFEnviaEventoInutilizacao = FabricaDeObjetosFake.getNFEnviaEventoInutilizacao().toString();
        Assert.assertNotNull(new NotaParser().enviaEventoInutilizacaoParaObjeto(xmlNFEnviaEventoInutilizacao));
    }

    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoInutilizacao() throws Exception {
        Assert.assertNotNull(new NotaParser().enviaEventoInutilizacaoParaObjeto(new File(new URI(NotaParserTest.class.getResource("enviaEventoInutilizacao.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaEnviaEventoInutilizacao() {
        new NotaParser().enviaEventoInutilizacaoParaObjeto("");
    }
}
