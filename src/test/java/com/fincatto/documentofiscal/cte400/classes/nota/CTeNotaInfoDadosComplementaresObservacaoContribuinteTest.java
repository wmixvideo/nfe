package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresObservacaoContribuinteTest {

    @Test
    public void deveSetarCampoCorretamente() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        Assert.assertEquals("Observacao", observacao.getCampo());
        Assert.assertEquals("Texto", observacao.getTexto());
    }

    @Test(expected = IllegalStateException.class)
    public void deveTerInformacoes() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacao.setTexto(null);
        observacao.setCampo(null);
        observacao.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void deveTerAte20caracteres() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacao.setTexto(null);
        observacao.setCampo("Campo deve ter ate 20 caracteres");
    }

    @Test(expected = IllegalStateException.class)
    public void deveTerAte160caracteres() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacao.setCampo(null);
        observacao.setTexto("Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres");
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        final String xml = "<ObsCont xCampo=\"Observacao\"><xTexto>Texto</xTexto></ObsCont>";
        Assert.assertEquals(xml, observacao.toString());
    }

}
