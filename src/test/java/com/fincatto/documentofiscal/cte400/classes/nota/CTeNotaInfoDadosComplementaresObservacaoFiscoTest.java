package com.fincatto.documentofiscal.cte400.classes.nota;

import org.junit.Assert;
import org.junit.Test;

public class CTeNotaInfoDadosComplementaresObservacaoFiscoTest {

    @Test
    public void deveSetarCampoCorretamente() {
        final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        Assert.assertEquals("Observacao", observacao.getCampo());
        Assert.assertEquals("Texto", observacao.getTexto());
    }

    @Test(expected = IllegalStateException.class)
    public void deveTerAte20caracteres() {
        final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
        observacao.setCampo("Campo deve ter ate 20 caracteres");
    }

    @Test(expected = IllegalStateException.class)
    public void deveTerAte60caracteres() {
        final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
        observacao.setTexto("Campo deve ter ate 60 caracteres. Campo deve ter ate 60 caracteres.");
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        final String xml = "<ObsFisco xCampo=\"Observacao\"><xTexto>Texto</xTexto></ObsFisco>";
        Assert.assertEquals(xml, observacao.toString());
    }

}
