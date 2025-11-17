package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFAmbiente;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class MDFeInfoEventoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void devePermitirSetarEObterTodosOsCamposComValoresValidos() {
        MDFeInfoEvento evento = new MDFeInfoEvento();
        ZonedDateTime dataHora = ZonedDateTime.now();

        evento.setId("ID1234567890123456789012345678901234567890123456789012");
        evento.setOrgao("35");
        evento.setAmbiente(DFAmbiente.HOMOLOGACAO);
        evento.setCnpj("12345678000195");
        evento.setCpf("12345678909");
        evento.setChave("12345678901234567890123456789012345678901234");
        evento.setDataHoraEvento(dataHora);
        evento.setCodigoEvento("110111");
        evento.setNumeroSequencialEvento(1);
        evento.setVersaoEvento("1.00");
        MDFeDetalhamentoEvento detalhamento = new MDFeDetalhamentoEvento();
        evento.setDetEvento(detalhamento);

        assertEquals("ID1234567890123456789012345678901234567890123456789012", evento.getId());
        assertEquals("35", evento.getOrgao());
        assertEquals(DFAmbiente.HOMOLOGACAO, evento.getAmbiente());
        assertEquals("12345678000195", evento.getCnpj());
        assertEquals("12345678909", evento.getCpf());
        assertEquals("12345678901234567890123456789012345678901234", evento.getChave());
        assertEquals(dataHora, evento.getDataHoraEvento());
        assertEquals("110111", evento.getCodigoEvento());
        assertEquals(1, evento.getNumeroSequencialEvento());
        assertEquals("1.00", evento.getVersaoEvento());
        assertEquals(detalhamento, evento.getDetEvento());
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoParaIdInvalido() {
        new MDFeInfoEvento().setId("ID_INVALIDO");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoParaChaveInvalida() {
        new MDFeInfoEvento().setChave("CHAVE_INVALIDA");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoParaCodigoEventoInvalido() {
        new MDFeInfoEvento().setCodigoEvento("123");
    }

    @Test(expected = NumberFormatException.class)
    public void deveLancarExcecaoParaNumeroSequencialEventoInvalido() {
        new MDFeInfoEvento().setNumeroSequencialEvento(102030);
    }
}