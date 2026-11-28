package com.fincatto.documentofiscal.nfe400.classes.evento.conciliacaofinanceira;

import java.math.BigDecimal;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFEventoCancelamentoEconfTest {

    private static final String CHAVE = "35261072834992000163550010000001231000000010";

    @Test
    public void naoDevePermitirVersaoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFEventoCancelamentoEconf().setVersao(new BigDecimal("1000.00")));
    }

    @Test
    public void deveObterInfoEventoComoFoiSetado() {
        final NFEventoCancelamentoEconf evento = new NFEventoCancelamentoEconf();
        final NFInfoEventoCancelamentoEconf infoEvento = FabricaDeObjetosFake.getNFInfoEventoCancelamentoEconf();
        evento.setInfoEvento(infoEvento);
        Assertions.assertEquals(infoEvento, evento.getInfoEvento());
    }

    @Test
    public void naoDeveGerarAssinaturaQuandoNaoInformada() {
        Assertions.assertFalse(FabricaDeObjetosFake.getNFEventoCancelamentoEconf().toString().contains("Signature"));
    }

    @Test
    public void deveGerarXMLComTodosOsCamposNaOrdemDoXSD() {
        final String xmlEsperado =
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
                        "</evento>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEventoCancelamentoEconf().toString());
    }

}
