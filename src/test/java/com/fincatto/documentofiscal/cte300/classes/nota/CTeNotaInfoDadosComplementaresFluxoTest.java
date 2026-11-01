package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresFluxoTest {

    @Test
    public void deveTerEntre1e15Caracteres() {
        final CTeNotaInfoDadosComplementaresFluxo fluxo = new CTeNotaInfoDadosComplementaresFluxo();
        fluxo.setDestino("Destino");
        fluxo.setOrigem("Origem");
        fluxo.setRota("Rota");
        Assertions.assertEquals("Destino", fluxo.getDestino());
        Assertions.assertEquals("Origem", fluxo.getOrigem());
        Assertions.assertEquals("Rota", fluxo.getRota());
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresFluxo fluxo = new CTeNotaInfoDadosComplementaresFluxo();
        fluxo.setDestino("Destino");
        fluxo.setOrigem("Origem");
        fluxo.setRota("Rota");

        final String xml = "<fluxo><xOrig>Origem</xOrig><xDest>Destino</xDest><xRota>Rota</xRota></fluxo>";
        Assertions.assertEquals(xml, fluxo.toString());
    }
}
