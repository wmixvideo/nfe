package com.fincatto.documentofiscal.mdfe3.classes.parsers;

import com.fincatto.documentofiscal.DFModelo;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MDFChaveParserTest  {

    @Test
    public void deveRetornarUnidadeFederativaCorreta() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertEquals(DFUnidadeFederativa.SP, parser.getNFUnidadeFederativa());
    }

    @Test
    public void deveRetornarDataEmissaoCorreta() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertEquals(LocalDate.of(2019, 10, 1), parser.getDataEmissao());
    }

    @Test
    public void deveRetornarCnpjEmitenteQuandoValido() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertEquals("12345678000195", parser.getCnpjEmitente());
    }

    @Test
    public void deveRetornarCpfEmitenteQuandoValido() {
        MDFChaveParser parser = new MDFChaveParser("35191012346589017069580010000000012345678901");
        assertEquals("46589017069", parser.getCpfEmitente());
    }

    @Test
    public void deveRetornarModeloCorreto() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertEquals(DFModelo.MDFE, parser.getModelo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoParaChaveComTamanhoInvalido() {
        new MDFChaveParser("123");
    }

    @Test
    public void deveRetornarCodigoNumericoCorreto() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertEquals("34567890", parser.getCodigoNumerico());
    }

    @Test
    public void deveRetornarDVCorreto() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertEquals("1", parser.getDV());
    }

    @Test
    public void deveRetornarChaveFormatadaCorretamente() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertEquals("3519 1012 3456 7800 0195 5800 1000 0000 0123 4567 8901", parser.getFormatado());
    }

    @Test
    public void deveIdentificarEmitentePessoaFisica() {
        MDFChaveParser parser = new MDFChaveParser("35191012346589017069580010000000012345678901");
        assertTrue(parser.isEmitentePessoaFisica());
        assertFalse(parser.isEmitentePessoaJuridica());
    }

    @Test
    public void deveIdentificarEmitentePessoaJuridica() {
        MDFChaveParser parser = new MDFChaveParser("35191012345678000195580010000000012345678901");
        assertTrue(parser.isEmitentePessoaJuridica());
        assertFalse(parser.isEmitentePessoaFisica());
    }
}