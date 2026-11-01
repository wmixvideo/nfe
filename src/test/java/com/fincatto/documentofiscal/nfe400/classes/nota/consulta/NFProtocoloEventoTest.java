package com.fincatto.documentofiscal.nfe400.classes.nota.consulta;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoRetorno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFProtocoloEventoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFProtocoloEvento evento = new NFProtocoloEvento();
        evento.setVersao("4.00");
        Assertions.assertEquals("4.00", evento.getVersao());
    }

    @Test
    public void deveObterEventoComoFoiSetado() {
        final NFProtocoloEvento protocoloEvento = new NFProtocoloEvento();
        final NFEvento evento = new NFEvento();
        protocoloEvento.setEvento(evento);
        Assertions.assertEquals(evento, protocoloEvento.getEvento());
    }

    @Test
    public void deveObterRetornoEventoComoFoiSetado() {
        final NFProtocoloEvento protocoloEvento = new NFProtocoloEvento();
        final NFEventoRetorno infoEventoRetorno = new NFEventoRetorno();
        protocoloEvento.setEventoRetorno(infoEventoRetorno);
        Assertions.assertEquals(infoEventoRetorno, protocoloEvento.getInfoEventoRetorno());
    }
}