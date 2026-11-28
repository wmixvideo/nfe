package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;
import java.util.Collections;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFEnviaEventoCancelamentoEconfTest {

    private static final String CHAVE = "35261072834992000163550010000001231000000010";

    @Test
    public void naoDevePermitirVersaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFEnviaEventoCancelamentoEconf().setVersao(new BigDecimal("1000.00")));
    }

    @Test
    public void naoDevePermitirIdLoteComMaisDe15Digitos() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoCancelamentoEconf().setIdLote("1234567890123456"));
    }

    @Test
    public void naoDevePermitirIdLoteNaoNumerico() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoCancelamentoEconf().setIdLote("12345678901234A"));
    }

    @Test
    public void naoDevePermitirMaisDe20Eventos() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> new NFEnviaEventoCancelamentoEconf().setEvento(Collections.nCopies(21, FabricaDeObjetosFake.getNFEventoCancelamentoEconf())));
    }

    @Test
    public void devePermitirAte20Eventos() {
        final NFEnviaEventoCancelamentoEconf enviaEvento = new NFEnviaEventoCancelamentoEconf();
        enviaEvento.setEvento(Collections.nCopies(20, FabricaDeObjetosFake.getNFEventoCancelamentoEconf()));
        Assertions.assertEquals(20, enviaEvento.getEvento().size());
    }

    @Test
    public void deveGerarXMLComTodosOsCamposNaOrdemDoXSD() {
        final String xmlEsperado =
                "<envEvento versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">" +
                        "<idLote>1793294973410</idLote>" +
                        "<evento versao=\"1.00\">" +
                        "<infEvento Id=\"ID110751" + CHAVE + "01\">" +
                        "<cOrgao>92</cOrgao>" +
                        "<tpAmb>2</tpAmb>" +
                        "<CNPJ>72834992000163</CNPJ>" +
                        "<chNFe>" + CHAVE + "</chNFe>" +
                        "<dhEvento>2026-10-28T10:10:10-03:00</dhEvento>" +
                        "<tpEvento>110751</tpEvento>" +
                        "<nSeqEvento>1</nSeqEvento>" +
                        "<verEvento>1.00</verEvento>" +
                        "<detEvento versao=\"1.00\">" +
                        "<descEvento>Cancelamento Conciliação Financeira</descEvento>" +
                        "<verAplic>1.00</verAplic>" +
                        "<nProtEvento>135260000012345</nProtEvento>" +
                        "</detEvento>" +
                        "</infEvento>" +
                        "</evento>" +
                        "</envEvento>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEnviaEventoCancelamentoEconf().toString());
    }

}
