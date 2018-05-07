package com.fincatto.documentofiscal.nfe310.classes.evento.manifestacaodestinatario;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NFInfoEventoManifestacaoDestinatarioTest {

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final DFAmbiente ambiente = DFAmbiente.PRODUCAO;
        infoEventoManifestacaoDestinatario.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, infoEventoManifestacaoDestinatario.getAmbiente());
    }

    @Test
    public void deveObterInfoCancelamentoComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final NFInfoManifestacaoDestinatario infoManifestacaoDestinatario = FabricaDeObjetosFake.getNFInfoManifestacaoDestinatario();
        infoEventoManifestacaoDestinatario.setManifestacaoDestinatario(infoManifestacaoDestinatario);
        Assert.assertEquals(infoManifestacaoDestinatario, infoEventoManifestacaoDestinatario.getManifestacaoDestinatario());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final String chave = "81568004734874930428983724940883089298523837";
        infoEventoManifestacaoDestinatario.setChave(chave);
        Assert.assertEquals(chave, infoEventoManifestacaoDestinatario.getChave());
    }

    @Test
    public void deveObterCnpjComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final String cnpj = "12345678901234";
        infoEventoManifestacaoDestinatario.setCnpj(cnpj);
        Assert.assertEquals(cnpj, infoEventoManifestacaoDestinatario.getCnpj());
    }

    @Test
    public void deveObterDataHoraEventoComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final ZonedDateTime dataHoraEvento = ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-10 10:10:10")), ZoneId.systemDefault());
        infoEventoManifestacaoDestinatario.setDataHoraEvento(dataHoraEvento);
        Assert.assertEquals(dataHoraEvento, infoEventoManifestacaoDestinatario.getDataHoraEvento());
    }

    @Test
    public void deveObterIdComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final String id = "hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6";
        infoEventoManifestacaoDestinatario.setId(id);
        Assert.assertEquals(id, infoEventoManifestacaoDestinatario.getId());
    }

    @Test
    public void deveObterNumeroSequencialEventoComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final int numeroSequencialEvento = 99;
        infoEventoManifestacaoDestinatario.setNumeroSequencialEvento(numeroSequencialEvento);
        Assert.assertEquals(numeroSequencialEvento, infoEventoManifestacaoDestinatario.getNumeroSequencialEvento());
    }

    @Test
    public void deveObterOrgaoComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.BA;
        infoEventoManifestacaoDestinatario.setOrgao(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, infoEventoManifestacaoDestinatario.getOrgao());
    }

    @Test
    public void deveObterCodigoEventoComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final String codigoEvento = "123546";
        infoEventoManifestacaoDestinatario.setCodigoEvento(codigoEvento);
        Assert.assertEquals(codigoEvento, infoEventoManifestacaoDestinatario.getCodigoEvento());
    }

    @Test
    public void deveObterVersaoEventoComoFoiSetado() {
        final NFInfoEventoManifestacaoDestinatario infoEventoManifestacaoDestinatario = new NFInfoEventoManifestacaoDestinatario();
        final BigDecimal versaoEvento = new BigDecimal("3.99");
        infoEventoManifestacaoDestinatario.setVersaoEvento(versaoEvento);
        Assert.assertEquals(versaoEvento.toString(), infoEventoManifestacaoDestinatario.getVersaoEvento());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoEventoManifestacaoDestinatario Id=\"hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>12345678901234</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>123456</tpEvento><nSeqEvento>2</nSeqEvento><verEvento>2.49</verEvento><detEvento versao=\"3.10\"><descEvento>Operacao nao Realizada</descEvento><xJust>Justificativa qualquer coisa</xJust></detEvento></NFInfoEventoManifestacaoDestinatario>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoEventoManifestacaoDestinatario().toString());
    }
}