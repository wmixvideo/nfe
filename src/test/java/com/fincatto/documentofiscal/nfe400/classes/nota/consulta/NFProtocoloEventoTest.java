package com.fincatto.documentofiscal.nfe400.classes.nota.consulta;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFEvento;
import com.fincatto.documentofiscal.nfe400.classes.evento.NFEventoRetorno;
import org.junit.Assert;
import org.junit.Test;

public class NFProtocoloEventoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFProtocoloEvento evento = new NFProtocoloEvento();
        evento.setVersao("4.00");
        Assert.assertEquals("4.00", evento.getVersao());
    }

    @Test
    public void deveObterEventoComoFoiSetado() {
        final NFProtocoloEvento protocoloEvento = new NFProtocoloEvento();
        final NFEvento evento = new NFEvento();
        protocoloEvento.setEvento(evento);
        Assert.assertEquals(evento, protocoloEvento.getEvento());
    }

    @Test
    public void deveObterRetornoEventoComoFoiSetado() {
        final NFProtocoloEvento protocoloEvento = new NFProtocoloEvento();
        final NFEventoRetorno infoEventoRetorno = new NFEventoRetorno();
        protocoloEvento.setEventoRetorno(infoEventoRetorno);
        Assert.assertEquals(infoEventoRetorno, protocoloEvento.getInfoEventoRetorno());
    }
}