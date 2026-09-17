package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFCeDownloadXMLTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFCeDownloadXML downloadXML = new NFCeDownloadXML();
        downloadXML.setVersao(new BigDecimal("1.00"));
        Assertions.assertEquals("1.00", downloadXML.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFCeDownloadXML downloadXML = new NFCeDownloadXML();
        downloadXML.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, downloadXML.getAmbiente());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFCeDownloadXML downloadXML = new NFCeDownloadXML();
        final String chave = "35260714200166000166650010000000011000000010";
        downloadXML.setChave(chave);
        Assertions.assertEquals(chave, downloadXML.getChave());
    }

    @Test
    public void naoDevePermitirChaveComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFCeDownloadXML().setChave("123"));
    }
}
