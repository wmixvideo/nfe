package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFProtocolo;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

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
        nfeProc.setDataHoraInclusao(ZonedDateTime.parse("2026-07-21T15:00:00-03:00"));
        Assertions.assertEquals(ZonedDateTime.parse("2026-07-21T15:00:00-03:00"), nfeProc.getDataHoraInclusao());
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

    @Test
    public void deveObterProtocoloComoFoiSetado() {
        final NFCeDownloadXMLRetornoNfeProc nfeProc = new NFCeDownloadXMLRetornoNfeProc();
        final NFProtocolo valor = FabricaDeObjetosFake.getNFProtocolo();
        nfeProc.setProtocolo(valor);
        Assertions.assertEquals(valor, nfeProc.getProtocolo());
    }
}
