package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.nfe400.NFeConfigFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WSNFCeDownloadXMLTest {

    @Test
    public void naoDeveFazerDownloadXMLQuandoUFDaChaveNaoPossuiOServico() {
        // chave emitida em SC, cujo autorizador (SVRS) nao possui o servico
        final WSNFCeDownloadXML ws = new WSNFCeDownloadXML(new NFeConfigFake(), null);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> ws.downloadXML("42260714200166000166650010000000011000000010"));
    }
}
