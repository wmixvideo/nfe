package com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento.NFEventoCancelamento;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;

public class NFEventoCancelamentoTest {

    @Test
    public void deveObterAssinaturaComoFoiSetado() {
        final NFEventoCancelamento eventoCancelamento = new NFEventoCancelamento();
        final NFSignature assinatura = new NFSignature();
        final String signatureValue = "signature";
        assinatura.setSignatureValue(signatureValue);
        eventoCancelamento.setAssinatura(assinatura);
        Assert.assertEquals(assinatura, eventoCancelamento.getAssinatura());
    }

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFEventoCancelamento eventoCancelamento = new NFEventoCancelamento();
        final BigDecimal versao = new BigDecimal("3.10");
        eventoCancelamento.setVersao(versao);
        Assert.assertEquals(versao.toString(), eventoCancelamento.getVersao());
    }

    @Test
    public void deveObterInfoEventoCancelamentoComoFoiSetado() {
        final NFEventoCancelamento eventoCancelamento = new NFEventoCancelamento();
        eventoCancelamento.setInfoEvento(FabricaDeObjetosFake.getNFInfoEventoCancelamento());
        Assert.assertEquals(FabricaDeObjetosFake.getNFInfoEventoCancelamento().toString(), eventoCancelamento.getInfoEvento().toString());
    }

    @Test
    public void devePermitirAssinaturaNula() {
        final NFEventoCancelamento eventoCancelamento = new NFEventoCancelamento();
        eventoCancelamento.setInfoEvento(FabricaDeObjetosFake.getNFInfoEventoCancelamento());
        eventoCancelamento.setVersao(new BigDecimal("3.10"));
        eventoCancelamento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirInfoEventoNulo() {
        final NFEventoCancelamento eventoCancelamento = new NFEventoCancelamento();
        final NFSignature assinatura = new NFSignature();
        final String signatureValue = "signature";
        assinatura.setSignatureValue(signatureValue);
        eventoCancelamento.setAssinatura(assinatura);
        eventoCancelamento.setVersao(new BigDecimal("3.10"));
        eventoCancelamento.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoNulo() {
        final NFEventoCancelamento eventoCancelamento = new NFEventoCancelamento();
        eventoCancelamento.setInfoEvento(FabricaDeObjetosFake.getNFInfoEventoCancelamento());
        final NFSignature assinatura = new NFSignature();
        final String signatureValue = "signature";
        assinatura.setSignatureValue(signatureValue);
        eventoCancelamento.setAssinatura(assinatura);
        eventoCancelamento.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<evento versao=\"3.10\"><infEvento Id=\"hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>12345678901234</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>123456</tpEvento><nSeqEvento>2</nSeqEvento><verEvento>2.49</verEvento><detEvento versao=\"3.10\"><descEvento>Cancelamento</descEvento><nProt>123456789012345</nProt><xJust>Justificativa qualquer coisa</xJust></detEvento></infEvento></evento>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEventoCancelamento().toString());
    }
}
