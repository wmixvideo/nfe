package com.fincatto.documentofiscal.mdfe3.classes.nota.evento;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.ZonedDateTime;

public class MDFeInfoEventoTest {

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

        Assertions.assertEquals("ID1234567890123456789012345678901234567890123456789012", evento.getId());
        Assertions.assertEquals("35", evento.getOrgao());
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, evento.getAmbiente());
        Assertions.assertEquals("12345678000195", evento.getCnpj());
        Assertions.assertEquals("12345678909", evento.getCpf());
        Assertions.assertEquals("12345678901234567890123456789012345678901234", evento.getChave());
        Assertions.assertEquals(dataHora, evento.getDataHoraEvento());
        Assertions.assertEquals("110111", evento.getCodigoEvento());
        Assertions.assertEquals(1, evento.getNumeroSequencialEvento());
        Assertions.assertEquals("1.00", evento.getVersaoEvento());
        Assertions.assertEquals(detalhamento, evento.getDetEvento());
    }

    @Test
    public void deveLancarExcecaoParaIdInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new MDFeInfoEvento().setId("ID_INVALIDO"));
    }

    @Test
    public void deveLancarExcecaoParaChaveInvalida() {
        Assertions.assertThrows(IllegalStateException.class, () -> new MDFeInfoEvento().setChave("CHAVE_INVALIDA"));
    }

    @Test
    public void deveLancarExcecaoParaCodigoEventoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new MDFeInfoEvento().setCodigoEvento("123"));
    }

    @Test
    public void deveLancarExcecaoParaNumeroSequencialEventoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new MDFeInfoEvento().setNumeroSequencialEvento(102030));
    }
}