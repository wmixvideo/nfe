package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresObservacaoContribuinteTest {

    @Test
    public void deveSetarCampoCorretamente() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        Assertions.assertEquals("Observacao", observacao.getCampo());
        Assertions.assertEquals("Texto", observacao.getTexto());
    }

    @Test
    public void deveTerInformacoes() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
            observacao.setTexto(null);
            observacao.setCampo(null);
            observacao.toString();
        });
    }

    @Test
    public void deveTerAte20caracteres() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
            observacao.setTexto(null);
            observacao.setCampo("Campo deve ter ate 20 caracteres");
        });
    }

    @Test
    public void deveTerAte160caracteres() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
            observacao.setCampo(null);
            observacao.setTexto("Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres. Campo deve ter ate 160 caracteres");
        });
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresObservacaoContribuinte observacao = new CTeNotaInfoDadosComplementaresObservacaoContribuinte();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        final String xml = "<ObsCont xCampo=\"Observacao\"><xTexto>Texto</xTexto></ObsCont>";
        Assertions.assertEquals(xml, observacao.toString());
    }

}
