package com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFInfoCancelamentoTest {

    @Test
    public void deveObterProtocoloAutorizacaoComoFoiSetado() {
        final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
        final String protocoloAutorizacao = "123456789012345";
        infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
        Assertions.assertEquals(protocoloAutorizacao, infoCancelamento.getProtocoloAutorizacao());
    }

    @Test
    public void naoDevePermitirProtocoloAutorizacaoVazio() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
            final String protocoloAutorizacao = "";
            infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
        });
    }

    @Test
    public void naoDevePermitirProtocoloAutorizacaoComLetras() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
            final String protocoloAutorizacao = "123456789A12345";
            infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
        });
    }

    @Test
    public void naoDevePermitirProtocoloAutorizacaoComTamanhoExtrapolado() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
            final String protocoloAutorizacao = "1234567890123456";
            infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
        });
    }

    @Test
    public void naoDevePermitirSetarCondicaoDeUso() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> new NFInfoCancelamento().setCondicaoUso(""));
    }

    @Test
    public void naoDevePermitirSetarTextoCorrecao() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> new NFInfoCancelamento().setTextoCorrecao(""));
    }

    @Test
    public void deveObterJustificativaComoFoiSetado() {
        final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
        final String justificativa = "oHhcRAPtxH7erRCHOgSe3l2qtqwzZDkJZRSYRS5ZW1CH6LifprUDIvMngr49r9Ms0BLl8hlC8maNnVZTNJnmgkUH47rZN9WNQZpD5T4Q1Uc2JTxnHiwAKjlAlwyP5ciZ0xgc2sYaf52ECQlm299JafuEwKiqk7Z2zTyhGwBmeizzo3wX9miZ1M1Cy8B0WclQIIJYI2MgTI0F43ag7qV4p1xfVTvGvMc6W3Urg5AhZZFfgmaOSW4Bx1TYrooGFAC1";
        infoCancelamento.setJustificativa(justificativa);
        Assertions.assertEquals(justificativa, infoCancelamento.getJustificativa());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoCancelamento versao=\"3.10\"><descEvento>Cancelamento</descEvento><nProt>123456789012345</nProt><xJust>Justificativa qualquer coisa</xJust></NFInfoCancelamento>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoCancelamento().toString());
    }
}