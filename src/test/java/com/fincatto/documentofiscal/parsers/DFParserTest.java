package com.fincatto.documentofiscal.parsers;

import java.io.File;
import java.net.URI;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.parsers.DFParser;

public class DFParserTest {

    @Test
    public void deveParsearCorretamenteUmXMLDaNota310() {
        final String xmlNota = FabricaDeObjetosFake.getNFNota().toString();
        Assert.assertNotNull(new DFParser().notaParaObjeto(xmlNota));
    }

    @Test
    public void deveParsearCorretamenteArquivoDaNota310() throws Exception {
        Assert.assertNotNull(new DFParser().notaParaObjeto(new File(new URI(DFParserTest.class.getResource("nota.xml").getFile()).getPath())));
    }

    @Test
    public void deveParsearCorretamenteUmXMLDaNotaProcessada310() {
        final String xmlNota = FabricaDeObjetosFake.getNFNotaProcessada().toString();
        Assert.assertNotNull(new DFParser().notaProcessadaParaObjeto(xmlNota));
    }

    @Test
    public void deveParsearCorretamenteArquivoDaNotaProcessada310() throws Exception {
        Assert.assertNotNull(new DFParser().notaProcessadaParaObjeto(new File(new URI(DFParserTest.class.getResource("notaprocessada.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmArquivoInvalidoParaNotaProcessada() {
        new DFParser().notaProcessadaParaObjeto(new File(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmArquivoInvalidoParaNota() {
        new DFParser().notaParaObjeto(new File(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaNotaProcessada() {
        new DFParser().notaProcessadaParaObjeto("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaNota() {
        new DFParser().notaParaObjeto("");
    }

    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCartaCorrecao() {
        final String xmlNFEnviaEventoCartaCorrecao = FabricaDeObjetosFake.getNFEnviaEventoCartaCorrecao().toString();
        Assert.assertNotNull(new DFParser().enviaEventoCartaCorrecaoParaObjeto(xmlNFEnviaEventoCartaCorrecao));
    }

    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCartaCorrecao() throws Exception {
        Assert.assertNotNull(new DFParser().enviaEventoCartaCorrecaoParaObjeto(new File(new URI(DFParserTest.class.getResource("enviaEventoCartaCorrecao.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaEnviaEventoCartaCorrecao() {
        new DFParser().enviaEventoCartaCorrecaoParaObjeto("");
    }

    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoCancelamento() {
        final String xmlNFEnviaEventoCancelamento = FabricaDeObjetosFake.getNFEnviaEventoCancelamento().toString();
        Assert.assertNotNull(new DFParser().enviaEventoCancelamentoParaObjeto(xmlNFEnviaEventoCancelamento));
    }

    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoCancelamento() throws Exception {
        Assert.assertNotNull(new DFParser().enviaEventoCancelamentoParaObjeto(new File(new URI(DFParserTest.class.getResource("enviaEventoCancelamento.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaEnviaEventoCancelamento() {
        new DFParser().enviaEventoCancelamentoParaObjeto("");
    }

    @Test
    public void deveParsearCorretamenteUmXMLDoNFEnviaEventoInutilizacao() {
        final String xmlNFEnviaEventoInutilizacao = FabricaDeObjetosFake.getNFEnviaEventoInutilizacao().toString();
        Assert.assertNotNull(new DFParser().enviaEventoInutilizacaoParaObjeto(xmlNFEnviaEventoInutilizacao));
    }

    @Test
    public void deveParsearCorretamenteArquivoDoNFEnviaEventoInutilizacao() throws Exception {
        Assert.assertNotNull(new DFParser().enviaEventoInutilizacaoParaObjeto(new File(new URI(DFParserTest.class.getResource("enviaEventoInutilizacao.xml").getFile()).getPath())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoCasoRecebaUmaStringInvalidaParaEnviaEventoInutilizacao() {
        new DFParser().enviaEventoInutilizacaoParaObjeto("");
    }
}
