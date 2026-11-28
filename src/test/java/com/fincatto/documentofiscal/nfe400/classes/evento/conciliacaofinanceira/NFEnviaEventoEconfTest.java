package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;
import java.util.Collections;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFEnviaEventoEconfTest {

    private static final String CHAVE = "35261072834992000163550010000001231000000010";

    @Test
    public void naoDevePermitirVersaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFEnviaEventoEconf().setVersao(new BigDecimal("1000.00")));
    }

    @Test
    public void naoDevePermitirIdLoteComMaisDe15Digitos() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoEconf().setIdLote("1234567890123456"));
    }

    @Test
    public void naoDevePermitirIdLoteNaoNumerico() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFEnviaEventoEconf().setIdLote("12345678901234A"));
    }

    @Test
    public void naoDevePermitirMaisDe20Eventos() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> new NFEnviaEventoEconf().setEvento(Collections.nCopies(21, FabricaDeObjetosFake.getNFEventoEconf())));
    }

    @Test
    public void devePermitirAte20Eventos() {
        final NFEnviaEventoEconf enviaEvento = new NFEnviaEventoEconf();
        enviaEvento.setEvento(Collections.nCopies(20, FabricaDeObjetosFake.getNFEventoEconf()));
        Assertions.assertEquals(20, enviaEvento.getEvento().size());
    }

    @Test
    public void deveGerarXMLComTodosOsCamposNaOrdemDoXSD() {
        final String xmlEsperado =
                "<envEvento versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">" +
                        "<idLote>1793294973410</idLote>" +
                        "<evento versao=\"1.00\">" +
                        "<infEvento Id=\"ID110750" + CHAVE + "01\">" +
                        "<cOrgao>92</cOrgao>" +
                        "<tpAmb>2</tpAmb>" +
                        "<CNPJ>72834992000163</CNPJ>" +
                        "<chNFe>" + CHAVE + "</chNFe>" +
                        "<dhEvento>2026-10-28T10:10:10-03:00</dhEvento>" +
                        "<tpEvento>110750</tpEvento>" +
                        "<nSeqEvento>1</nSeqEvento>" +
                        "<verEvento>1.00</verEvento>" +
                        "<detEvento versao=\"1.00\">" +
                        "<descEvento>ECONF</descEvento>" +
                        "<verAplic>1.00</verAplic>" +
                        "<detPag><tPag>17</tPag><vPag>5000.00</vPag><dPag>2026-10-28</dPag></detPag>" +
                        "</detEvento>" +
                        "</infEvento>" +
                        "</evento>" +
                        "</envEvento>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEnviaEventoEconf().toString());
    }

}
