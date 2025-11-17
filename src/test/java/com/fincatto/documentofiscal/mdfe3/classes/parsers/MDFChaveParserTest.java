package com.fincatto.documentofiscal.mdfe3.classes.parsers;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.mdfe3.classes.def.MDFTipoEmissao;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MDFChaveParserTest {

    private MDFChaveParser parserPessoaJuridica;
    private MDFChaveParser parserPessoaFisica;

    @Before
    public void setUp() {
        this.parserPessoaJuridica = new MDFChaveParser("35191012345678000195580010000000012345678901");
        this.parserPessoaFisica = new MDFChaveParser("35191012346589017069589200000000012345678901");
    }

    @Test
    public void deveRetornarUnidadeFederativaCorreta() {
        assertEquals(DFUnidadeFederativa.SP, parserPessoaFisica.getNFUnidadeFederativa());
        assertEquals(DFUnidadeFederativa.SP, parserPessoaJuridica.getNFUnidadeFederativa());
    }

    @Test
    public void deveRetornarDataEmissaoCorreta() {
        assertEquals(LocalDate.of(2019, 10, 1), parserPessoaFisica.getDataEmissao());
        assertEquals(LocalDate.of(2019, 10, 1), parserPessoaJuridica.getDataEmissao());
    }

    @Test
    public void deveRetornarCnpjEmitenteQuandoValido() {
        assertFalse(parserPessoaJuridica.isEmitentePessoaFisica());
        assertTrue(parserPessoaJuridica.isEmitentePessoaJuridica());
        assertEquals("12345678000195", parserPessoaJuridica.getCnpjEmitente());
        assertNull(parserPessoaJuridica.getCpfEmitente());
    }

    @Test
    public void deveRetornarCpfEmitenteQuandoValido() {
        assertTrue(parserPessoaFisica.isEmitentePessoaFisica());
        assertFalse(parserPessoaFisica.isEmitentePessoaJuridica());
        assertEquals("46589017069", parserPessoaFisica.getCpfEmitente());
        assertNull(parserPessoaFisica.getCnpjEmitente());
    }

    @Test
    public void deveRetornarCpfEmitenteQuandoAmbosForemValidos() {
        final MDFChaveParser parserPessoaFisicaJuridica = new MDFChaveParser("51251000000829253050559200000048851205518238");

        //apesar do cnpj ser valido, a chave indica que o emitente é pessoa fisica
        assertTrue(parserPessoaFisicaJuridica.isEmitentePessoaFisica());
        assertEquals("00829253050", parserPessoaFisicaJuridica.getCpfEmitente());

        //apesar do cnpj ser valido, a chave indica que o emitente é pessoa fisica
        assertFalse(parserPessoaFisicaJuridica.isEmitentePessoaJuridica());
        assertEquals(null, parserPessoaFisicaJuridica.getCnpjEmitente());
    }

    @Test
    public void deveRetornarModeloCorreto() {
        assertEquals(DFModelo.MDFE, parserPessoaFisica.getModelo());
        assertEquals(DFModelo.MDFE, parserPessoaJuridica.getModelo());
    }

    @Test
    public void deveRetornarSerieCorreta() {
        assertEquals("920", parserPessoaFisica.getSerie());
        assertEquals("001", parserPessoaJuridica.getSerie());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoParaChaveComTamanhoInvalido() {
        new MDFChaveParser("123");
    }

    @Test
    public void deveRetornarCodigoNumericoCorreto() {
        assertEquals("34567890", parserPessoaFisica.getCodigoNumerico());
        assertEquals("34567890", parserPessoaJuridica.getCodigoNumerico());
    }

    @Test
    public void deveRetornarDVCorreto() {
        assertEquals("1", parserPessoaFisica.getDV());
        assertEquals("1", parserPessoaJuridica.getDV());
    }

    @Test
    public void deveRetornarChaveFormatadaCorretamente() {
        assertEquals("3519 1012 3465 8901 7069 5892 0000 0000 0123 4567 8901", parserPessoaFisica.getFormatado());
        assertEquals("3519 1012 3456 7800 0195 5800 1000 0000 0123 4567 8901", parserPessoaJuridica.getFormatado());
    }

    @Test
    public void deveIdentificarEmitentePessoaFisica() {
        assertTrue(parserPessoaFisica.isEmitentePessoaFisica());
        assertFalse(parserPessoaFisica.isEmitentePessoaJuridica());
    }

    @Test
    public void deveIdentificarEmitentePessoaJuridica() {
        assertTrue(parserPessoaJuridica.isEmitentePessoaJuridica());
        assertFalse(parserPessoaJuridica.isEmitentePessoaFisica());
    }

    @Test
    public void deveIdentificarFipoEmissaoContingencia() {
        assertEquals(MDFTipoEmissao.CONTINGENCIA, parserPessoaFisica.getFormaEmissao());
        assertEquals(MDFTipoEmissao.CONTINGENCIA, parserPessoaJuridica.getFormaEmissao());
    }

    @Test
    public void deveIdentificarSerieReservadaParaPessoaFisica() {
        assertTrue(parserPessoaFisica.isSerieReservadaPessoaFisica());
        assertFalse(parserPessoaJuridica.isSerieReservadaPessoaFisica());
    }

    @Test
    public void emitentePessoaJuridicaMesmoQuandoCpfValida() {
        final MDFChaveParser parser = new MDFChaveParser("43251047060783000162580010000000071130047529");
        assertTrue(parser.isEmitentePessoaJuridica());
        assertFalse(parser.isEmitentePessoaFisica());
        assertEquals("47060783000162", parser.getCnpjEmitente());
        assertNull( parser.getCpfEmitente());
    }
}