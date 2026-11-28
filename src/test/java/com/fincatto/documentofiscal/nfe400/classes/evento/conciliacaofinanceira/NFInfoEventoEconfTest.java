package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoEventoEconfTest {

    private static final String CHAVE = "35261072834992000163550010000001231000000010";

    @Test
    public void tamanhoExato54CampoId() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setId("a".repeat(53)));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setId("a".repeat(55)));
    }

    @Test
    public void tamanhoExato44CampoChave() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setChave("1".repeat(43)));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setChave("1".repeat(45)));
    }

    @Test
    public void naoDevePermitirCnpjInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setCnpj("123"));
    }

    @Test
    public void naoDevePermitirCpfInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setCpf("123"));
    }

    @Test
    public void naoDevePermitirCodigoEventoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setCodigoEvento("11075"));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setCodigoEvento("1107500"));
    }

    @Test
    public void naoDevePermitirCodigoEventoNaoNumerico() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoEconf().setCodigoEvento("11075A"));
    }

    @Test
    public void naoDevePermitirNumeroSequencialEventoForaDoIntervalo() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFInfoEventoEconf().setNumeroSequencialEvento(0));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFInfoEventoEconf().setNumeroSequencialEvento(100));
    }

    @Test
    public void devePermitirNumeroSequencialEventoNosLimites() {
        final NFInfoEventoEconf infoEvento = new NFInfoEventoEconf();
        infoEvento.setNumeroSequencialEvento(1);
        Assertions.assertEquals(1, infoEvento.getNumeroSequencialEvento());
        infoEvento.setNumeroSequencialEvento(99);
        Assertions.assertEquals(99, infoEvento.getNumeroSequencialEvento());
    }

    @Test
    public void naoDevePermitirVersaoEventoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFInfoEventoEconf().setVersaoEvento(new BigDecimal("1000.00")));
    }

    @Test
    public void naoDeveGerarOsCamposOpcionaisNulosNoXml() {
        final NFInfoEventoEconf infoEvento = FabricaDeObjetosFake.getNFInfoEventoEconf();
        infoEvento.setCnpj(null);
        final String xml = infoEvento.toString();
        Assertions.assertFalse(xml.contains("<CNPJ>"));
        Assertions.assertFalse(xml.contains("<CPF>"));
    }

    @Test
    public void deveGerarXMLComCnpjNaOrdemDoXSD() {
        final String xmlEsperado =
                "<NFInfoEventoEconf Id=\"ID110750" + CHAVE + "01\">" +
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
                        "</NFInfoEventoEconf>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoEventoEconf().toString());
    }

    @Test
    public void deveGerarXMLComCpfNoLugarDoCnpj() {
        final NFInfoEventoEconf infoEvento = FabricaDeObjetosFake.getNFInfoEventoEconf();
        infoEvento.setCnpj(null);
        infoEvento.setCpf("12345678901");
        final String xml = infoEvento.toString();
        Assertions.assertTrue(xml.contains("<tpAmb>2</tpAmb><CPF>12345678901</CPF><chNFe>"));
        Assertions.assertFalse(xml.contains("<CNPJ>"));
    }

}
