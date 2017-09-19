package com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario.NFEventoManifestacaoDestinatario;

public class NFEventoManifestacaoTest {

    @Test
    public void deveObterAssinaturaComoFoiSetado() {
        final NFEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEventoManifestacaoDestinatario();
        final String assinatura = "assinatura";
        eventoManifestacaoDestinatario.setAssinatura(assinatura);
        Assert.assertEquals(assinatura, eventoManifestacaoDestinatario.getAssinatura());
    }

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEventoManifestacaoDestinatario();
        final BigDecimal versao = new BigDecimal("3.10");
        eventoManifestacaoDestinatario.setVersao(versao);
        Assert.assertEquals(versao.toString(), eventoManifestacaoDestinatario.getVersao());
    }

    @Test
    public void deveObterInfoEventoManifestacaoDestinatarioComoFoiSetado() {
        final NFEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEventoManifestacaoDestinatario();
        eventoManifestacaoDestinatario.setInfoEvento(FabricaDeObjetosFake.getNFInfoEventoManifestacaoDestinatario());
        Assert.assertEquals(FabricaDeObjetosFake.getNFInfoEventoManifestacaoDestinatario().toString(), eventoManifestacaoDestinatario.getInfoEvento().toString());
    }

    @Test
    public void devePermitirAssinaturaNula() {
        final NFEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEventoManifestacaoDestinatario();
        eventoManifestacaoDestinatario.setInfoEvento(FabricaDeObjetosFake.getNFInfoEventoManifestacaoDestinatario());
        eventoManifestacaoDestinatario.setVersao(new BigDecimal("3.10"));
        eventoManifestacaoDestinatario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirInfoEventoNulo() {
        final NFEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEventoManifestacaoDestinatario();
        eventoManifestacaoDestinatario.setAssinatura("assinatura");
        eventoManifestacaoDestinatario.setVersao(new BigDecimal("3.10"));
        eventoManifestacaoDestinatario.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoNulo() {
        final NFEventoManifestacaoDestinatario eventoManifestacaoDestinatario = new NFEventoManifestacaoDestinatario();
        eventoManifestacaoDestinatario.setInfoEvento(FabricaDeObjetosFake.getNFInfoEventoManifestacaoDestinatario());
        eventoManifestacaoDestinatario.setAssinatura("assinatura");
        eventoManifestacaoDestinatario.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFEventoManifestacaoDestinatario versao=\"3.10\"><infEvento Id=\"hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>12345678901234</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>123456</tpEvento><nSeqEvento>2</nSeqEvento><verEvento>2.49</verEvento><detEvento versao=\"3.10\"><descEvento>Operacao nao Realizada</descEvento><xJust>Justificativa qualquer coisa</xJust></detEvento></infEvento></NFEventoManifestacaoDestinatario>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFEventoManifestacaoDestinatario().toString());
    }
}