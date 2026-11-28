package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFDetEventoCancelamentoEconfTest {

    @Test
    public void tamanhoMinimo1CampoVersaoAplicativo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFDetEventoCancelamentoEconf().setVersaoAplicativo(""));
    }

    @Test
    public void tamanhoMaximo20CampoVersaoAplicativo() {
        Assertions.assertThrows(IllegalStateException.class, () ->
                new NFDetEventoCancelamentoEconf().setVersaoAplicativo("a".repeat(21)));
    }

    @Test
    public void naoDevePermitirNumeroProtocoloEventoComMenosDe15Digitos() {
        Assertions.assertThrows(IllegalStateException.class, () ->
                new NFDetEventoCancelamentoEconf().setNumeroProtocoloEvento("12345678901234"));
    }

    @Test
    public void naoDevePermitirNumeroProtocoloEventoComMaisDe15Digitos() {
        Assertions.assertThrows(IllegalStateException.class, () ->
                new NFDetEventoCancelamentoEconf().setNumeroProtocoloEvento("1234567890123456"));
    }

    @Test
    public void naoDevePermitirNumeroProtocoloEventoNaoNumerico() {
        Assertions.assertThrows(IllegalStateException.class, () ->
                new NFDetEventoCancelamentoEconf().setNumeroProtocoloEvento("12345678901234A"));
    }

    @Test
    public void devePermitirNumeroProtocoloEventoCom15Digitos() {
        final NFDetEventoCancelamentoEconf detEvento = new NFDetEventoCancelamentoEconf();
        detEvento.setNumeroProtocoloEvento("135260000012345");
        Assertions.assertEquals("135260000012345", detEvento.getNumeroProtocoloEvento());
    }

    @Test
    public void naoDeveGerarXMLSemNumeroProtocoloEvento() {
        final NFDetEventoCancelamentoEconf detEvento = new NFDetEventoCancelamentoEconf();
        detEvento.setDescricaoEvento("Cancelamento Conciliação Financeira");
        detEvento.setVersao(new BigDecimal("1.00"));
        detEvento.setVersaoAplicativo("1.00");
        Assertions.assertThrows(IllegalStateException.class, detEvento::toString);
    }

    @Test
    public void naoDeveGerarXMLSemVersaoAplicativo() {
        final NFDetEventoCancelamentoEconf detEvento = new NFDetEventoCancelamentoEconf();
        detEvento.setDescricaoEvento("Cancelamento Conciliação Financeira");
        detEvento.setVersao(new BigDecimal("1.00"));
        detEvento.setNumeroProtocoloEvento("135260000012345");
        Assertions.assertThrows(IllegalStateException.class, detEvento::toString);
    }

    @Test
    public void deveGerarXMLComTodosOsCamposNaOrdemDoXSD() {
        final String xmlEsperado =
                "<detEvento versao=\"1.00\">" +
                        "<descEvento>Cancelamento Conciliação Financeira</descEvento>" +
                        "<verAplic>1.00</verAplic>" +
                        "<nProtEvento>135260000012345</nProtEvento>" +
                        "</detEvento>";
        final NFDetEventoCancelamentoEconf detEvento = new NFDetEventoCancelamentoEconf();
        detEvento.setDescricaoEvento("Cancelamento Conciliação Financeira");
        detEvento.setVersao(new BigDecimal("1.00"));
        detEvento.setVersaoAplicativo("1.00");
        detEvento.setNumeroProtocoloEvento("135260000012345");

        Assertions.assertEquals(xmlEsperado, detEvento.toString());
    }

}
