package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NFCeDownloadXMLRetornoProcTest {

    @Test
    public void deveObterNfeProcComoFoiSetado() {
        final NFCeDownloadXMLRetornoProc proc = new NFCeDownloadXMLRetornoProc();
        final NFCeDownloadXMLRetornoNfeProc nfeProc = new NFCeDownloadXMLRetornoNfeProc();
        proc.setNfeProc(nfeProc);
        Assert.assertEquals(nfeProc, proc.getNfeProc());
    }

    @Test
    public void deveObterProcEventoNFeComoFoiSetado() {
        final NFCeDownloadXMLRetornoProc proc = new NFCeDownloadXMLRetornoProc();
        final List<NFCeDownloadXMLRetornoProcEventoNFe> eventos = new ArrayList<>();
        eventos.add(new NFCeDownloadXMLRetornoProcEventoNFe());
        proc.setProcEventoNFe(eventos);
        Assert.assertEquals(eventos, proc.getProcEventoNFe());
    }
}
