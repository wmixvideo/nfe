package com.fincatto.documentofiscal.nfe310.parsers;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class NotaFiscalChaveParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveNula() {
        new NotaFiscalChaveParser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveDeTamanhoMenor() {
        new NotaFiscalChaveParser("1734119042676883974264088457913359614139959");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveDeTamanhoMaior() {
        new NotaFiscalChaveParser("173411904267688397426408845791335961413995927");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveDeTamanhoMenorMesmoComEspacos() {
        new NotaFiscalChaveParser("1734119042676883974264088457913359614139959 ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirChaveComLetras() {
        new NotaFiscalChaveParser("1734119042676883974264088457913359614139959A");
    }

    @Test
    public void deveObterUFDeChave() {
        Assert.assertEquals(DFUnidadeFederativa.SC, new NotaFiscalChaveParser("42341190426768839742640884579133596141399591").getNFUnidadeFederativa());
    }

    @Test
    public void deveObterDataDeEmissaoDaChave() {
        Assert.assertEquals(LocalDate.of(2015, 11, 1), new NotaFiscalChaveParser("42151190426768839742640884579133596141399591").getDataEmissao());
    }

    @Test
    public void deveObterCNPJEmitenteDaChave() {
        Assert.assertEquals("03918609000132", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getCnpjEmitente());
    }

    @Test
    public void deveObterSerieDaChave() {
        Assert.assertEquals("088", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getSerie());
    }

    @Test
    public void deveObterNumeroDaChave() {
        Assert.assertEquals("457913359", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getNumero());
    }

    @Test
    public void deveObterFormaEmissaoDaChave() {
        Assert.assertEquals(NFTipoEmissao.EMISSAO_NORMAL, new NotaFiscalChaveParser("42151103918609000132640884579133591141399591").getFormaEmissao());
    }

    @Test
    public void deveObterCodigoNumericoDaChave() {
        Assert.assertEquals("14139959", new NotaFiscalChaveParser("42151103918609000132640884579133591141399591").getCodigoNumerico());
    }

    @Test
    public void deveObterDivisorDaChave() {
        Assert.assertEquals("1", new NotaFiscalChaveParser("42151103918609000132640884579133591141399591").getDV());
    }

    @Test
    public void naoDeveSerNotaEmitidaEmContigencia() {
        Assert.assertFalse(new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").isEmitidaContingenciaSCAN());
    }

    @Test
    public void deveSerNotaEmitidaEmContigencia() {
        Assert.assertTrue(new NotaFiscalChaveParser("42151103918609000132649884579133596141399591").isEmitidaContingenciaSCAN());
    }

    @Test
    public void deveFormatarChave() {
        Assert.assertEquals("4215 1103 9186 0900 0132 6408 8457 9133 5961 4139 9591", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getFormatado());
    }
}