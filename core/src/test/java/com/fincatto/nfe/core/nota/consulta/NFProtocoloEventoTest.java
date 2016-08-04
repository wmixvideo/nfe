package com.fincatto.nfe.core.nota.consulta;

import com.fincatto.nfe.core.evento.NFEvento;
import com.fincatto.nfe.core.evento.NFEventoRetorno;
import org.junit.Assert;
import org.junit.Test;

public class NFProtocoloEventoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFProtocoloEvento evento = new NFProtocoloEvento();
        final String versao = "3.10";
        evento.setVersao(versao);
        Assert.assertEquals(versao, evento.getVersao());
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