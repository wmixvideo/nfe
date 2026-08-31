package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFCeDownloadXMLRetornoNfeProcTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFCeDownloadXMLRetornoNfeProc nfeProc = new NFCeDownloadXMLRetornoNfeProc();
        nfeProc.setVersao("4.00");
        Assertions.assertEquals("4.00", nfeProc.getVersao());
    }

    @Test
    public void deveObterDataHoraInclusaoComoFoiSetado() {
        final NFCeDownloadXMLRetornoNfeProc nfeProc = new NFCeDownloadXMLRetornoNfeProc();
        nfeProc.setDataHoraInclusao("2026-07-21T15:00:00-03:00");
        Assertions.assertEquals("2026-07-21T15:00:00-03:00", nfeProc.getDataHoraInclusao());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final NFCeDownloadXMLRetornoNfeProc nfeProc = new NFCeDownloadXMLRetornoNfeProc();
        nfeProc.setNumeroProtocolo("135260000000010");
        Assertions.assertEquals("135260000000010", nfeProc.getNumeroProtocolo());
    }

    @Test
    public void deveObterNotaComoFoiSetado() {
        final NFCeDownloadXMLRetornoNfeProc nfeProc = new NFCeDownloadXMLRetornoNfeProc();
        final NFNota nota = new NFNota();
        nfeProc.setNota(nota);
        Assertions.assertEquals(nota, nfeProc.getNota());
    }
}
