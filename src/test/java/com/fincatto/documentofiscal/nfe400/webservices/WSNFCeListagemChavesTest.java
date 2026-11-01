package com.fincatto.documentofiscal.nfe400.webservices;

import com.fincatto.documentofiscal.nfe400.NFeConfigFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class WSNFCeListagemChavesTest {

    @Test
    public void naoDeveConsultarListagemChavesQuandoUFConfiguradaNaoPossuiOServico() {
        // NFeConfigFake esta configurado para SC, cujo autorizador (SVRS) nao possui o servico
        final WSNFCeListagemChaves ws = new WSNFCeListagemChaves(new NFeConfigFake(), null);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> ws.consultaListagemChaves(LocalDateTime.of(2026, 7, 21, 0, 0), null));
    }
}
