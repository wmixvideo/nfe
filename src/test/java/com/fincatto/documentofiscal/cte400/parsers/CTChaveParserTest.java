package com.fincatto.documentofiscal.cte400.parsers;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.cte.CTTipoEmissao;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CTChaveParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveNula() {
        new CTChaveParser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveDeTamanhoMenor() {
        new CTChaveParser("3526050X0J92JY00019657001000000604144867901");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveDeTamanhoMaior() {
        new CTChaveParser("3526050X0J92JY000196570010000006041448679011999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveDeTamanhoMenorMesmoComEspacos() {
        new CTChaveParser("3526050X0J92JY00019657001000000604144867901 ");
    }

    @Test
    public void devePermitirChaveComLetrasENumeros() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        assertNotNull(parser.getChave());
        assertEquals(44, parser.getChave().length());
    }

    @Test
    public void deveUniformizarParaMAIUSCULAS() {
        final CTChaveParser parser = new CTChaveParser("3526050x0j92jy000196570010000006041448679011");
        assertEquals("3526050X0J92JY000196570010000006041448679011", parser.getChave());
    }

    @Test
    public void deveRemoverEspacosECaracteresEspeciais() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY 0001 96570010000006041448679011");
        assertEquals("3526050X0J92JY000196570010000006041448679011", parser.getChave());
    }

    @Test
    public void deveRemoverEspacosDeChaveNumericaNormal() {
        final CTChaveParser parser = new CTChaveParser("3526 0502 6050 0000 0019 6570 0100 0000 6041 4486 7901");
        assertEquals(44, parser.getChave().length());
    }

    @Test
    public void deveObterUFDeChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals(DFUnidadeFederativa.SP, parser.getNFUnidadeFederativa());
    }

    @Test
    public void deveObterUFDeChaveNumericaNormal() {
        final CTChaveParser parser = new CTChaveParser("35260502605000000019657001000000604144867901");
        Assert.assertEquals(DFUnidadeFederativa.SP, parser.getNFUnidadeFederativa());
    }

    @Test
    public void deveObterDataDeEmissaoDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals(LocalDate.of(2026, 5, 1), parser.getDataEmissao());
    }

    @Test
    public void deveObterSerieDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals("001", parser.getSerie());
    }

    @Test
    public void deveObterNumeroDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals("000000604", parser.getNumero());
    }

    @Test
    public void deveObterCnpjEmitenteDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals("0X0J92JY000196", parser.getCnpjEmitente());
    }

    @Test
    public void deveObterCnpjEmitenteDeChavedeSomenteNumeros() {
        final CTChaveParser parser = new CTChaveParser("35260502605000000019657001000000604144867901");
        Assert.assertEquals("02605000000019", parser.getCnpjEmitente());
    }

    @Test
    public void deveObterModeloDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals(DFModelo.CTE, parser.getModelo());
    }

    @Test
    public void deveObterFormaEmissaoDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals(CTTipoEmissao.EMISSAO_NORMAL, parser.getFormaEmissao());
    }

    @Test
    public void deveObterCodigoNumericoDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals("44867901", parser.getCodigoNumerico());
    }

    @Test
    public void deveObterDVDaChave() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals("1", parser.getDV());
    }

    @Test
    public void deveFormatarChaveAlfanumerica() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertEquals("3526 050X 0J92 JY00 0196 5700 1000 0006 0414 4867 9011", parser.getFormatado());
    }

    @Test
    public void deveFormatarChaveNumerica() {
        final CTChaveParser parser = new CTChaveParser("35260502605000000019657001000000604144867901");
        Assert.assertEquals("3526 0502 6050 0000 0019 6570 0100 0000 6041 4486 7901", parser.getFormatado());
    }

    @Test
    public void naoDeveSerEmitidaContingenciaSCVSP() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertFalse(parser.isEmitidaContingenciaSCVSP());
    }

    @Test
    public void naoDeveSerEmitidaContingenciaSCVRS() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        Assert.assertFalse(parser.isEmitidaContingenciaSCVRS());
    }

    @Test
    public void deveSerEmitidaContingenciaSCVSP() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006048448679011");
        Assert.assertTrue(parser.isEmitidaContingenciaSCVSP());
    }

    @Test
    public void deveSerEmitidaContingenciaSCVRS() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006047448679011");
        Assert.assertTrue(parser.isEmitidaContingenciaSCVRS());
    }

    @Test
    public void deveRetornarChaevFormatada() {
        final CTChaveParser parser = new CTChaveParser("3526050X0J92JY000196570010000006041448679011");
        assertNotNull(parser.getFormatado());
        assertTrue(parser.getFormatado().contains(" "));
    }

}

