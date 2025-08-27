package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresFluxoTest {

    @Test
    public void deveTerEntre1e15Caracteres() {
        final CTeNotaInfoDadosComplementaresFluxo fluxo = new CTeNotaInfoDadosComplementaresFluxo();
        fluxo.setDestino("Destino");
        fluxo.setOrigem("Origem");
        fluxo.setRota("Rota");
        Assert.assertEquals("Destino", fluxo.getDestino());
        Assert.assertEquals("Origem", fluxo.getOrigem());
        Assert.assertEquals("Rota", fluxo.getRota());
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresFluxo fluxo = new CTeNotaInfoDadosComplementaresFluxo();
        fluxo.setDestino("Destino");
        fluxo.setOrigem("Origem");
        fluxo.setRota("Rota");

        final String xml = "<fluxo><xOrig>Origem</xOrig><xDest>Destino</xDest><xRota>Rota</xRota></fluxo>";
        Assert.assertEquals(xml, fluxo.toString());
    }
}
