package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoEventoCancelamentoEconfTest {

    private static final String CHAVE = "35261072834992000163550010000001231000000010";

    @Test
    public void tamanhoExato54CampoId() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setId("a".repeat(53)));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setId("a".repeat(55)));
    }

    @Test
    public void tamanhoExato44CampoChave() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setChave("1".repeat(43)));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setChave("1".repeat(45)));
    }

    @Test
    public void naoDevePermitirCnpjInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setCnpj("123"));
    }

    @Test
    public void naoDevePermitirCpfInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setCpf("123"));
    }

    @Test
    public void naoDevePermitirCodigoEventoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setCodigoEvento("11075"));
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setCodigoEvento("1107500"));
    }

    @Test
    public void naoDevePermitirCodigoEventoNaoNumerico() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInfoEventoCancelamentoEconf().setCodigoEvento("11075A"));
    }

    @Test
    public void naoDevePermitirNumeroSequencialEventoForaDoIntervalo() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFInfoEventoCancelamentoEconf().setNumeroSequencialEvento(0));
        Assertions.assertThrows(NumberFormatException.class, () -> new NFInfoEventoCancelamentoEconf().setNumeroSequencialEvento(100));
    }

    @Test
    public void devePermitirNumeroSequencialEventoNosLimites() {
        final NFInfoEventoCancelamentoEconf infoEvento = new NFInfoEventoCancelamentoEconf();
        infoEvento.setNumeroSequencialEvento(1);
        Assertions.assertEquals(1, infoEvento.getNumeroSequencialEvento());
        infoEvento.setNumeroSequencialEvento(99);
        Assertions.assertEquals(99, infoEvento.getNumeroSequencialEvento());
    }

    @Test
    public void naoDevePermitirVersaoEventoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFInfoEventoCancelamentoEconf().setVersaoEvento(new BigDecimal("1000.00")));
    }

    @Test
    public void naoDeveGerarOsCamposOpcionaisNulosNoXml() {
        final NFInfoEventoCancelamentoEconf infoEvento = FabricaDeObjetosFake.getNFInfoEventoCancelamentoEconf();
        infoEvento.setCnpj(null);
        final String xml = infoEvento.toString();
        Assertions.assertFalse(xml.contains("<CNPJ>"));
        Assertions.assertFalse(xml.contains("<CPF>"));
    }

    @Test
    public void deveGerarXMLComCnpjNaOrdemDoXSD() {
        final String xmlEsperado =
                "<NFInfoEventoCancelamentoEconf Id=\"ID110751" + CHAVE + "01\">" +
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
                        "</NFInfoEventoCancelamentoEconf>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoEventoCancelamentoEconf().toString());
    }

    @Test
    public void deveGerarXMLComCpfNoLugarDoCnpj() {
        final NFInfoEventoCancelamentoEconf infoEvento = FabricaDeObjetosFake.getNFInfoEventoCancelamentoEconf();
        infoEvento.setCnpj(null);
        infoEvento.setCpf("12345678901");
        final String xml = infoEvento.toString();
        Assertions.assertTrue(xml.contains("<tpAmb>2</tpAmb><CPF>12345678901</CPF><chNFe>"));
        Assertions.assertFalse(xml.contains("<CNPJ>"));
    }

}
