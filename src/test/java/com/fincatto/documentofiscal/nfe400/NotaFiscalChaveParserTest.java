package com.fincatto.documentofiscal.nfe400;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe.NFTipoEmissao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class NotaFiscalChaveParserTest {

    @Test
    public void naoDevePermitirChaveNula() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaFiscalChaveParser(null));
    }

    @Test
    public void naoDevePermitirChaveDeTamanhoMenor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaFiscalChaveParser("1734119042676883974264088457913359614139959"));
    }

    @Test
    public void naoDevePermitirChaveDeTamanhoMaior() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaFiscalChaveParser("173411904267688397426408845791335961413995927"));
    }

    @Test
    public void naoDevePermitirChaveDeTamanhoMenorMesmoComEspacos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaFiscalChaveParser("1734119042676883974264088457913359614139959 "));
    }

    @Test
    public void devePermitirChaveAlfanumerica() {
        // CNPJ alfanumérico: posições 6-19 contêm letras (44 chars)
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser("422505AB000000000001550010000000011000000010");
        Assertions.assertNotNull(parser.getChave());
        Assertions.assertEquals(44, parser.getChave().length());
    }

    @Test
    public void deveNormalizarChaveAlfanumericaParaMaiusculas() {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser("422505ab000000000001550010000000011000000010");
        Assertions.assertEquals("422505AB000000000001550010000000011000000010", parser.getChave());
    }

    @Test
    public void deveFormatarChaveAlfanumerica() {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser("422505AB000000000001550010000000011000000010");
        Assertions.assertEquals("4225 05AB 0000 0000 0001 5500 1000 0000 0110 0000 0010", parser.getFormatado());
    }

    @Test
    public void deveObterUFDeChave() {
        Assertions.assertEquals(DFUnidadeFederativa.SC, new NotaFiscalChaveParser("42341190426768839742640884579133596141399591").getNFUnidadeFederativa());
    }

    @Test
    public void deveObterDataDeEmissaoDaChave() {
        Assertions.assertEquals(LocalDate.of(2015, 11, 1), new NotaFiscalChaveParser("42151190426768839742640884579133596141399591").getDataEmissao());
    }

    @Test
    public void deveObterSerieDaChave() {
        Assertions.assertEquals("088", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getSerie());
    }

    @Test
    public void deveObterNumeroDaChave() {
        Assertions.assertEquals("457913359", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getNumero());
    }

    @Test
    public void deveObterFormaEmissaoDaChave() {
        Assertions.assertEquals(NFTipoEmissao.EMISSAO_NORMAL, new NotaFiscalChaveParser("42151103918609000132640884579133591141399591").getFormaEmissao());
    }

    @Test
    public void deveObterCodigoNumericoDaChave() {
        Assertions.assertEquals("14139959", new NotaFiscalChaveParser("42151103918609000132640884579133591141399591").getCodigoNumerico());
    }

    @Test
    public void deveObterDivisorDaChave() {
        Assertions.assertEquals("1", new NotaFiscalChaveParser("42151103918609000132640884579133591141399591").getDV());
    }

    @Test
    public void naoDeveSerNotaEmitidaEmContigencia() {
        Assertions.assertFalse(new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").isEmitidaContingenciaSCAN());
    }

    @Test
    public void deveSerNotaEmitidaEmContigencia() {
        Assertions.assertTrue(new NotaFiscalChaveParser("42151103918609000132649884579133596141399591").isEmitidaContingenciaSCAN());
    }

    @Test
    public void deveFormatarChave() {
        Assertions.assertEquals("4215 1103 9186 0900 0132 6408 8457 9133 5961 4139 9591", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getFormatado());
    }

    @Test
    public void deveObterCnpjEmitenteDaChave() {
        NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser("42151103918609000132640884579133596141399591");
        Assertions.assertTrue(notaFiscalChaveParser.isEmitentePessoaJuridica());
        Assertions.assertEquals("03918609000132", notaFiscalChaveParser.getCnpjEmitente());
        Assertions.assertFalse(notaFiscalChaveParser.isEmitentePessoaFisica());
        Assertions.assertNull(notaFiscalChaveParser.getCpfEmitente());
    }

    @Test
    public void deveObterCpfEmitenteDaChave() {
        NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser("42151100038883975022649694579133596141399591");
        Assertions.assertTrue(notaFiscalChaveParser.isEmitentePessoaFisica());
        Assertions.assertEquals("38883975022", notaFiscalChaveParser.getCpfEmitente());
        Assertions.assertFalse(notaFiscalChaveParser.isEmitentePessoaJuridica());
        Assertions.assertNull(notaFiscalChaveParser.getCnpjEmitente());
    }

    @Test
    public void deveIdentificarSerieReservadaParaPessoaFisica() {
        NotaFiscalChaveParser notaFiscalChaveParser = new NotaFiscalChaveParser("42151100038883975022649694579133596141399591");
        Assertions.assertTrue(notaFiscalChaveParser.isSerieReservadaPessoaFisica());
    }

    @Test
    public void emitentePessoaJuridicaMesmoQuandoCpfValida() {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser("43251047060783000162580010000000071130047529");
        Assertions.assertTrue(parser.isEmitentePessoaJuridica());
        Assertions.assertFalse(parser.isEmitentePessoaFisica());
        Assertions.assertEquals("47060783000162", parser.getCnpjEmitente());
        Assertions.assertNull(parser.getCpfEmitente());
    }

    @Test
    public void naoDeveSerEmitidaContingenciaSCVANOuSCVRSQuandoEmissaoNormal() {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser("421511AB12CD34EF5678550010000000121000000010");
        Assertions.assertFalse(parser.isEmitidaContingenciaSCVAN());
        Assertions.assertFalse(parser.isEmitidaContingenciaSCVRS());
    }

    /**
     * Antes da correcao, isEmitidaContingenciaSCVAN() usava um regex "\\d{34}6\\d{9}" que nunca
     * casava quando havia letras (CNPJ alfanumerico, NT 2026.004) nas posicoes 6-19 da chave.
     */
    @Test
    public void deveSerEmitidaContingenciaSCVANComCnpjAlfanumericoNaChave() {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser("421511AB12CD34EF5678550010000000126000000010");
        Assertions.assertTrue(parser.isEmitidaContingenciaSCVAN());
        Assertions.assertFalse(parser.isEmitidaContingenciaSCVRS());
    }

    @Test
    public void deveSerEmitidaContingenciaSCVRSComCnpjAlfanumericoNaChave() {
        final NotaFiscalChaveParser parser = new NotaFiscalChaveParser("421511AB12CD34EF5678550010000000127000000010");
        Assertions.assertTrue(parser.isEmitidaContingenciaSCVRS());
        Assertions.assertFalse(parser.isEmitidaContingenciaSCVAN());
    }
}