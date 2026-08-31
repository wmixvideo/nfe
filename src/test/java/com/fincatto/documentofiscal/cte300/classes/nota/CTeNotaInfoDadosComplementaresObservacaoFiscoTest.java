package com.fincatto.documentofiscal.cte300.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeNotaInfoDadosComplementaresObservacaoFiscoTest {

    @Test
    public void deveSetarCampoCorretamente() {
        final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        Assertions.assertEquals("Observacao", observacao.getCampo());
        Assertions.assertEquals("Texto", observacao.getTexto());
    }

    @Test
    public void deveTerAte20caracteres() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
            observacao.setCampo("Campo deve ter ate 20 caracteres");
        });
    }

    @Test
    public void deveTerAte60caracteres() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
            observacao.setTexto("Campo deve ter ate 60 caracteres. Campo deve ter ate 60 caracteres.");
        });
    }

    @Test
    public void deveGerarXmlCorreto() {
        final CTeNotaInfoDadosComplementaresObservacaoFisco observacao = new CTeNotaInfoDadosComplementaresObservacaoFisco();
        observacao.setCampo("Observacao");
        observacao.setTexto("Texto");
        final String xml = "<ObsFisco xCampo=\"Observacao\"><xTexto>Texto</xTexto></ObsFisco>";
        Assertions.assertEquals(xml, observacao.toString());
    }

}
