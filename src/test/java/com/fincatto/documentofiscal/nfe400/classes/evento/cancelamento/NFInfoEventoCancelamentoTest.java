package com.fincatto.documentofiscal.nfe400.classes.evento.cancelamento;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class NFInfoEventoCancelamentoTest {

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final DFAmbiente ambiente = DFAmbiente.PRODUCAO;
        infoEventoCancelamento.setAmbiente(ambiente);
        Assertions.assertEquals(ambiente, infoEventoCancelamento.getAmbiente());
    }

    @Test
    public void deveObterInfoCancelamentoComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final NFInfoCancelamento infoCancelamento = FabricaDeObjetosFake.getNFInfoCancelamento();
        infoEventoCancelamento.setCancelamento(infoCancelamento);
        Assertions.assertEquals(infoCancelamento, infoEventoCancelamento.getCancelamento());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final String chave = "81568004734874930428983724940883089298523837";
        infoEventoCancelamento.setChave(chave);
        Assertions.assertEquals(chave, infoEventoCancelamento.getChave());
    }

    @Test
    public void deveObterCnpjComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final String cnpj = "12345678901234";
        infoEventoCancelamento.setCnpj(cnpj);
        Assertions.assertEquals(cnpj, infoEventoCancelamento.getCnpj());
    }

    @Test
    public void deveObterDataHoraEventoComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final ZonedDateTime dataHoraEvento = ZonedDateTime.of(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-01-01 10:10:10")), DFConfig.TIMEZONE_SP.toZoneId());
        infoEventoCancelamento.setDataHoraEvento(dataHoraEvento);
        Assertions.assertEquals(dataHoraEvento, infoEventoCancelamento.getDataHoraEvento());
    }

    @Test
    public void deveObterIdComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final String id = "hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6";
        infoEventoCancelamento.setId(id);
        Assertions.assertEquals(id, infoEventoCancelamento.getId());
    }

    @Test
    public void deveObterNumeroSequencialEventoComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final int numeroSequencialEvento = 99;
        infoEventoCancelamento.setNumeroSequencialEvento(numeroSequencialEvento);
        Assertions.assertEquals(numeroSequencialEvento, infoEventoCancelamento.getNumeroSequencialEvento());
    }

    @Test
    public void deveObterOrgaoComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.BA;
        infoEventoCancelamento.setOrgao(unidadeFederativa);
        Assertions.assertEquals(unidadeFederativa, infoEventoCancelamento.getOrgao());
    }

    @Test
    public void deveObterCodigoEventoComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final String codigoEvento = "123546";
        infoEventoCancelamento.setCodigoEvento(codigoEvento);
        Assertions.assertEquals(codigoEvento, infoEventoCancelamento.getCodigoEvento());
    }

    @Test
    public void deveObterVersaoEventoComoFoiSetado() {
        final NFInfoEventoCancelamento infoEventoCancelamento = new NFInfoEventoCancelamento();
        final BigDecimal versaoEvento = new BigDecimal("3.99");
        infoEventoCancelamento.setVersaoEvento(versaoEvento);
        Assertions.assertEquals(versaoEvento.toString(), infoEventoCancelamento.getVersaoEvento());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFInfoEventoCancelamento Id=\"hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>12345678901234</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>2014-01-01T10:10:10-02:00</dhEvento><tpEvento>123456</tpEvento><nSeqEvento>2</nSeqEvento><verEvento>2.49</verEvento><detEvento versao=\"4.00\"><descEvento>Cancelamento</descEvento><nProt>123456789012345</nProt><xJust>Justificativa qualquer coisa</xJust></detEvento></NFInfoEventoCancelamento>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFInfoEventoCancelamento().toString());
    }
}