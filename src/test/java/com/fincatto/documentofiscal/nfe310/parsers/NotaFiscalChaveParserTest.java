package com.fincatto.documentofiscal.nfe310.parsers;

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
    public void naoDevePermitirChaveComLetras() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new NotaFiscalChaveParser("1734119042676883974264088457913359614139959A"));
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
    public void deveObterCNPJEmitenteDaChave() {
        Assertions.assertEquals("03918609000132", new NotaFiscalChaveParser("42151103918609000132640884579133596141399591").getCnpjEmitente());
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
}