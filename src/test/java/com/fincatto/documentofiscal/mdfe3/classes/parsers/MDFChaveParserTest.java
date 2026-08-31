package com.fincatto.documentofiscal.mdfe3.classes.parsers;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MDFChaveParserTest {

    private MDFChaveParser parserPessoaJuridica;
    private MDFChaveParser parserPessoaFisica;

    @BeforeEach
    public void setUp() {
        this.parserPessoaJuridica = new MDFChaveParser("35191012345678000195580010000000012345678901");
        this.parserPessoaFisica = new MDFChaveParser("35191012346589017069589200000000012345678901");
    }

    @Test
    public void deveRetornarUnidadeFederativaCorreta() {
        Assertions.assertEquals(DFUnidadeFederativa.SP, parserPessoaFisica.getNFUnidadeFederativa());
        Assertions.assertEquals(DFUnidadeFederativa.SP, parserPessoaJuridica.getNFUnidadeFederativa());
    }

    @Test
    public void deveRetornarDataEmissaoCorreta() {
        Assertions.assertEquals(LocalDate.of(2019, 10, 1), parserPessoaFisica.getDataEmissao());
        Assertions.assertEquals(LocalDate.of(2019, 10, 1), parserPessoaJuridica.getDataEmissao());
    }

    @Test
    public void deveRetornarCnpjEmitenteQuandoValido() {
        Assertions.assertFalse(parserPessoaJuridica.isEmitentePessoaFisica());
        Assertions.assertTrue(parserPessoaJuridica.isEmitentePessoaJuridica());
        Assertions.assertEquals("12345678000195", parserPessoaJuridica.getCnpjEmitente());
        Assertions.assertNull(parserPessoaJuridica.getCpfEmitente());
    }

    @Test
    public void deveRetornarCpfEmitenteQuandoValido() {
        Assertions.assertTrue(parserPessoaFisica.isEmitentePessoaFisica());
        Assertions.assertFalse(parserPessoaFisica.isEmitentePessoaJuridica());
        Assertions.assertEquals("46589017069", parserPessoaFisica.getCpfEmitente());
        Assertions.assertNull(parserPessoaFisica.getCnpjEmitente());
    }

    @Test
    public void deveRetornarCpfEmitenteQuandoAmbosForemValidos() {
        final MDFChaveParser parserPessoaFisicaJuridica = new MDFChaveParser("51251000000829253050559200000048851205518238");

        //apesar do cnpj ser valido, a chave indica que o emitente é pessoa fisica
        Assertions.assertTrue(parserPessoaFisicaJuridica.isEmitentePessoaFisica());
        Assertions.assertEquals("00829253050", parserPessoaFisicaJuridica.getCpfEmitente());

        //apesar do cnpj ser valido, a chave indica que o emitente é pessoa fisica
        Assertions.assertFalse(parserPessoaFisicaJuridica.isEmitentePessoaJuridica());
        Assertions.assertEquals(null, parserPessoaFisicaJuridica.getCnpjEmitente());
    }

    @Test
    public void deveRetornarModeloCorreto() {
        Assertions.assertEquals(DFModelo.MDFE, parserPessoaFisica.getModelo());
        Assertions.assertEquals(DFModelo.MDFE, parserPessoaJuridica.getModelo());
    }

    @Test
    public void deveRetornarSerieCorreta() {
        Assertions.assertEquals("920", parserPessoaFisica.getSerie());
        Assertions.assertEquals("001", parserPessoaJuridica.getSerie());
    }

    @Test
    public void deveLancarExcecaoParaChaveComTamanhoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MDFChaveParser("123"));
    }

    @Test
    public void deveRetornarCodigoNumericoCorreto() {
        Assertions.assertEquals("34567890", parserPessoaFisica.getCodigoNumerico());
        Assertions.assertEquals("34567890", parserPessoaJuridica.getCodigoNumerico());
    }

    @Test
    public void deveRetornarDVCorreto() {
        Assertions.assertEquals("1", parserPessoaFisica.getDV());
        Assertions.assertEquals("1", parserPessoaJuridica.getDV());
    }

    @Test
    public void deveRetornarChaveFormatadaCorretamente() {
        Assertions.assertEquals("3519 1012 3465 8901 7069 5892 0000 0000 0123 4567 8901", parserPessoaFisica.getFormatado());
        Assertions.assertEquals("3519 1012 3456 7800 0195 5800 1000 0000 0123 4567 8901", parserPessoaJuridica.getFormatado());
    }

    @Test
    public void deveIdentificarEmitentePessoaFisica() {
        Assertions.assertTrue(parserPessoaFisica.isEmitentePessoaFisica());
        Assertions.assertFalse(parserPessoaFisica.isEmitentePessoaJuridica());
    }

    @Test
    public void deveIdentificarEmitentePessoaJuridica() {
        Assertions.assertTrue(parserPessoaJuridica.isEmitentePessoaJuridica());
        Assertions.assertFalse(parserPessoaJuridica.isEmitentePessoaFisica());
    }

    @Test
    public void deveIdentificarFipoEmissaoContingencia() {
        Assertions.assertEquals(MDFTipoEmissao.CONTINGENCIA, parserPessoaFisica.getFormaEmissao());
        Assertions.assertEquals(MDFTipoEmissao.CONTINGENCIA, parserPessoaJuridica.getFormaEmissao());
    }

    @Test
    public void deveIdentificarSerieReservadaParaPessoaFisica() {
        Assertions.assertTrue(parserPessoaFisica.isSerieReservadaPessoaFisica());
        Assertions.assertFalse(parserPessoaJuridica.isSerieReservadaPessoaFisica());
    }

    @Test
    public void emitentePessoaJuridicaMesmoQuandoCpfValida() {
        final MDFChaveParser parser = new MDFChaveParser("43251047060783000162580010000000071130047529");
        Assertions.assertTrue(parser.isEmitentePessoaJuridica());
        Assertions.assertFalse(parser.isEmitentePessoaFisica());
        Assertions.assertEquals("47060783000162", parser.getCnpjEmitente());
        Assertions.assertNull( parser.getCpfEmitente());
    }

    /**
     * A partir do CNPJ alfanumerico (NT 2026.004) a chave do MDFe pode conter letras
     * nas posicoes 6-19 (CNPJ do emitente). Antes da correcao, o construtor removia
     * qualquer letra via replaceAll("\\D", "") e a chave resultante, com menos de 44
     * caracteres, lancava IllegalArgumentException de tamanho invalido.
     */
    @Test
    public void devePermitirChaveComCnpjAlfanumerico() {
        final MDFChaveParser parser = new MDFChaveParser("351910AB12CD34EF5602580010000000121000000015");
        Assertions.assertEquals(44, parser.getChave().length());
        Assertions.assertTrue(parser.isEmitentePessoaJuridica());
        Assertions.assertFalse(parser.isEmitentePessoaFisica());
        Assertions.assertEquals("AB12CD34EF5602", parser.getCnpjEmitente());
        Assertions.assertNull(parser.getCpfEmitente());
    }

    @Test
    public void deveNormalizarChaveComCnpjAlfanumericoParaMaiusculas() {
        final MDFChaveParser parser = new MDFChaveParser("351910ab12cd34ef5602580010000000121000000015");
        Assertions.assertEquals("351910AB12CD34EF5602580010000000121000000015", parser.getChave());
    }

    @Test
    public void deveFormatarChaveComCnpjAlfanumerico() {
        final MDFChaveParser parser = new MDFChaveParser("351910AB12CD34EF5602580010000000121000000015");
        Assertions.assertEquals("3519 10AB 12CD 34EF 5602 5800 1000 0000 1210 0000 0015", parser.getFormatado());
    }
}