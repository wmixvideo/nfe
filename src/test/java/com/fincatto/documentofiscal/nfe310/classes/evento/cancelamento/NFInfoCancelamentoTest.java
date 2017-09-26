package com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFInfoCancelamento;

public class NFInfoCancelamentoTest {

    @Test
    public void deveObterProtocoloAutorizacaoComoFoiSetado() {
        final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
        final String protocoloAutorizacao = "123456789012345";
        infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
        Assert.assertEquals(protocoloAutorizacao, infoCancelamento.getProtocoloAutorizacao());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirProtocoloAutorizacaoVazio() {
        final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
        final String protocoloAutorizacao = "";
        infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirProtocoloAutorizacaoComLetras() {
        final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
        final String protocoloAutorizacao = "123456789A12345";
        infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirProtocoloAutorizacaoComTamanhoExtrapolado() {
        final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
        final String protocoloAutorizacao = "1234567890123456";
        infoCancelamento.setProtocoloAutorizacao(protocoloAutorizacao);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void naoDevePermitirSetarCondicaoDeUso() {
        new NFInfoCancelamento().setCondicaoUso("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void naoDevePermitirSetarTextoCorrecao() {
        new NFInfoCancelamento().setTextoCorrecao("");
    }

    @Test
    public void deveObterJustificativaComoFoiSetado() {
        final NFInfoCancelamento infoCancelamento = new NFInfoCancelamento();
        final String justificativa = "oHhcRAPtxH7erRCHOgSe3l2qtqwzZDkJZRSYRS5ZW1CH6LifprUDIvMngr49r9Ms0BLl8hlC8maNnVZTNJnmgkUH47rZN9WNQZpD5T4Q1Uc2JTxnHiwAKjlAlwyP5ciZ0xgc2sYaf52ECQlm299JafuEwKiqk7Z2zTyhGwBmeizzo3wX9miZ1M1Cy8B0WclQIIJYI2MgTI0F43ag7qV4p1xfVTvGvMc6W3Urg5AhZZFfgmaOSW4Bx1TYrooGFAC1";
        infoCancelamento.setJustificativa(justificativa);
        Assert.assertEquals(justificativa, infoCancelamento.getJustificativa());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoCancelamento versao=\"3.10\"><descEvento>Cancelamento</descEvento><nProt>123456789012345</nProt><xJust>Justificativa qualquer coisa</xJust></NFInfoCancelamento>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoCancelamento().toString());
    }
}