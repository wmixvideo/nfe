package com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NFEnviaEventoCancelamentoTest {

    @Test
    public void deveObterEventosComoFoiSetado() {
        final NFEnviaEventoCancelamento eventoCancelamento = new NFEnviaEventoCancelamento();
        final ArrayList<NFEventoCancelamento> eventosCancelamento = new ArrayList<>();
        eventoCancelamento.setEvento(eventosCancelamento);
        Assertions.assertEquals(eventosCancelamento, eventoCancelamento.getEvento());
    }

    @Test
    public void deveObterIdLoteComoFoiSetado() {
        final NFEnviaEventoCancelamento eventoCancelamento = new NFEnviaEventoCancelamento();
        eventoCancelamento.setIdLote("1");
        Assertions.assertEquals("1", eventoCancelamento.getIdLote());
    }

    @Test
    public void deveObterVersaoStringComoFoiSetado() {
        final NFEnviaEventoCancelamento eventoCancelamento = new NFEnviaEventoCancelamento();
        final BigDecimal versao = new BigDecimal("3.10");
        eventoCancelamento.setVersao(versao);
        Assertions.assertEquals(versao.toString(), eventoCancelamento.getVersao());
    }

    @Test
    public void naoDevePermitirIdLoteInvalidoVazio() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoCancelamento().setIdLote(""));
    }

    @Test
    public void naoDevePermitirIdLoteInvalidoComLetra() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoCancelamento().setIdLote("12345678901234A"));
    }

    @Test
    public void naoDevePermitirIdLoteInvalidoComTamanhoExtrapolado() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoCancelamento().setIdLote("1234567890123456"));
    }

    @Test
    public void naoDevePermitirTamanhoInvalidoDeEventos() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final List<NFEventoCancelamento> eventos = new ArrayList<>();
            for (int i = 0; i < 21; i++) {
                eventos.add(new NFEventoCancelamento());
            }
            new NFEnviaEventoCancelamento().setEvento(eventos);
        });
    }

    @Test
    public void naoDevePermitirEventosNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEnviaEventoCancelamento eventoCancelamento = new NFEnviaEventoCancelamento();
            eventoCancelamento.setIdLote("1");
            eventoCancelamento.setVersao(new BigDecimal("3.10"));
            eventoCancelamento.toString();
        });
    }

    @Test
    public void naoDevePermitirLoteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEnviaEventoCancelamento eventoCancelamento = new NFEnviaEventoCancelamento();
            eventoCancelamento.setEvento(new ArrayList<>());
            eventoCancelamento.setVersao(new BigDecimal("3.10"));
            eventoCancelamento.toString();
        });
    }

    @Test
    public void naoDevePermitirVersaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFEnviaEventoCancelamento eventoCancelamento = new NFEnviaEventoCancelamento();
            eventoCancelamento.setEvento(new ArrayList<>());
            eventoCancelamento.setIdLote("1");
            eventoCancelamento.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFEnviaEventoCancelamento eventoCancelamento = new NFEnviaEventoCancelamento();
        eventoCancelamento.setEvento(Collections.singletonList(FabricaDeObjetosFake.getNFEventoCancelamento()));
        eventoCancelamento.setVersao(new BigDecimal("3.10"));
        eventoCancelamento.setIdLote("1");

        final String xmlEsperado = "<envEvento versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><idLote>1</idLote><evento versao=\"3.10\"><infEvento Id=\"hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>12345678901234</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>123456</tpEvento><nSeqEvento>2</nSeqEvento><verEvento>2.49</verEvento><detEvento versao=\"3.10\"><descEvento>Cancelamento</descEvento><nProt>123456789012345</nProt><xJust>Justificativa qualquer coisa</xJust></detEvento></infEvento></evento></envEvento>";
        Assertions.assertEquals(xmlEsperado, eventoCancelamento.toString());
    }
}