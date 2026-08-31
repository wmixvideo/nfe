package com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFEnviaEventoManifestacaoDestinatarioTest {

    @Test
    public void deveObterEventosComoFoiSetado() {
        final NFEnviaEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEnviaEventoManifestacaoDestinatario();
        final ArrayList<NFEventoManifestacaoDestinatario> eventosManifestacaoDestinatario = new ArrayList<>();
        eventoManifestacaoDestinatario.setEvento(eventosManifestacaoDestinatario);
        Assertions.assertEquals(eventosManifestacaoDestinatario, eventoManifestacaoDestinatario.getEvento());
    }

    @Test
    public void deveObterIdLoteComoFoiSetado() {
        final NFEnviaEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEnviaEventoManifestacaoDestinatario();
        eventoManifestacaoDestinatario.setIdLote("1");
        Assertions.assertEquals("1", eventoManifestacaoDestinatario.getIdLote());
    }

    @Test
    public void deveObterVersaoStringComoFoiSetado() {
        final NFEnviaEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEnviaEventoManifestacaoDestinatario();
        final BigDecimal versao = new BigDecimal("3.10");
        eventoManifestacaoDestinatario.setVersao(versao);
        Assertions.assertEquals(versao.toString(), eventoManifestacaoDestinatario.getVersao());
    }

    @Test
    public void naoDevePermitirIdLoteInvalidoVazio() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoManifestacaoDestinatario().setIdLote(""));
    }

    @Test
    public void naoDevePermitirIdLoteInvalidoComLetra() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoManifestacaoDestinatario().setIdLote("12345678901234A"));
    }

    @Test
    public void naoDevePermitirIdLoteInvalidoComTamanhoExtrapolado() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoManifestacaoDestinatario().setIdLote("1234567890123456"));
    }

    @Test
    public void naoDevePermitirTamanhoInvalidoDeEventos() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final List<NFEventoManifestacaoDestinatario> eventos = new ArrayList<>();
            for (int i = 0; i < 21; i++) {
                eventos.add(new NFEventoManifestacaoDestinatario());
            }
            new NFEnviaEventoManifestacaoDestinatario().setEvento(eventos);
        });
    }

    @Test
    public void naoDevePermitirEventosNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEnviaEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEnviaEventoManifestacaoDestinatario();
            eventoManifestacaoDestinatario.setIdLote("1");
            eventoManifestacaoDestinatario.setVersao(new BigDecimal("3.10"));
            eventoManifestacaoDestinatario.toString();
        });
    }

    @Test
    public void naoDevePermitirLoteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEnviaEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEnviaEventoManifestacaoDestinatario();
            eventoManifestacaoDestinatario.setEvento(new ArrayList<>());
            eventoManifestacaoDestinatario.setVersao(new BigDecimal("3.10"));
            eventoManifestacaoDestinatario.toString();
        });
    }

    @Test
    public void naoDevePermitirVersaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEnviaEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEnviaEventoManifestacaoDestinatario();
            eventoManifestacaoDestinatario.setEvento(new ArrayList<>());
            eventoManifestacaoDestinatario.setIdLote("1");
            eventoManifestacaoDestinatario.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFEnviaEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEnviaEventoManifestacaoDestinatario();
        eventoManifestacaoDestinatario.setEvento(Collections.singletonList(FabricaDeObjetosFake.getNFEventoManifestacaoDestinatario()));
        eventoManifestacaoDestinatario.setVersao(new BigDecimal("3.10"));
        eventoManifestacaoDestinatario.setIdLote("1");

        final String xmlEsperado = "<envEvento versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><idLote>1</idLote><evento versao=\"3.10\"><infEvento Id=\"hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>12345678901234</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>123456</tpEvento><nSeqEvento>2</nSeqEvento><verEvento>2.49</verEvento><detEvento versao=\"3.10\"><descEvento>Operacao nao Realizada</descEvento><xJust>Justificativa qualquer coisa</xJust></detEvento></infEvento></evento></envEvento>";
        Assertions.assertEquals(xmlEsperado, eventoManifestacaoDestinatario.toString());
    }
}