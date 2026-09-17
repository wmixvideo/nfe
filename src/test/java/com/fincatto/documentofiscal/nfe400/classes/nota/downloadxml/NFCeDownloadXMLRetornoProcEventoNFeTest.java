package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.nfe400.classes.evento.NFEvento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFCeDownloadXMLRetornoProcEventoNFeTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFCeDownloadXMLRetornoProcEventoNFe procEvento = new NFCeDownloadXMLRetornoProcEventoNFe();
        procEvento.setVersao("1.00");
        Assertions.assertEquals("1.00", procEvento.getVersao());
    }

    @Test
    public void deveObterDataHoraInclusaoComoFoiSetado() {
        final NFCeDownloadXMLRetornoProcEventoNFe procEvento = new NFCeDownloadXMLRetornoProcEventoNFe();
        procEvento.setDataHoraInclusao("2026-07-21T15:00:00-03:00");
        Assertions.assertEquals("2026-07-21T15:00:00-03:00", procEvento.getDataHoraInclusao());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final NFCeDownloadXMLRetornoProcEventoNFe procEvento = new NFCeDownloadXMLRetornoProcEventoNFe();
        procEvento.setNumeroProtocolo("135260000000029");
        Assertions.assertEquals("135260000000029", procEvento.getNumeroProtocolo());
    }

    @Test
    public void deveObterEventoComoFoiSetado() {
        final NFCeDownloadXMLRetornoProcEventoNFe procEvento = new NFCeDownloadXMLRetornoProcEventoNFe();
        final NFEvento evento = new NFEvento();
        procEvento.setEvento(evento);
        Assertions.assertEquals(evento, procEvento.getEvento());
    }
}
