package com.fincatto.nfe310.classes.evento.cancelamento;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.evento.NFEventoRetorno;
import com.fincatto.nfe310.classes.evento.NFInfoEventoRetorno;

public class NFProtocoloEventoCancelamentoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFProtocoloEventoCancelamento procEvento = new NFProtocoloEventoCancelamento();
        procEvento.setVersao("1.00");
        Assert.assertEquals("1.00", procEvento.getVersao());
    }

    @Test
    public void deveObterEventoComoFoiSetado() {
        final NFProtocoloEventoCancelamento procEvento = new NFProtocoloEventoCancelamento();
        procEvento.setEvento(FabricaDeObjetosFake.getNFEventoCancelamento());
        Assert.assertEquals(FabricaDeObjetosFake.getNFEventoCancelamento().getVersao(), procEvento.getEvento().getVersao());
    }

    @Test
    public void deveObterEventoRetornoComoFoiSetado() {
        final NFProtocoloEventoCancelamento procEvento = new NFProtocoloEventoCancelamento();
        final NFEventoRetorno eventoRetorno = new NFEventoRetorno();
        eventoRetorno.setVersao("1.0");
        procEvento.setEventoRetorno(eventoRetorno);
        Assert.assertEquals(eventoRetorno.getVersao(), procEvento.getInfoEventoRetorno().getVersao());
    }

    @Test
    @Ignore
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFProtocoloEventoCancelamento procEvento = new NFProtocoloEventoCancelamento();
        procEvento.setVersao("1.00");

        final NFEventoRetorno eventoRetorno = new NFEventoRetorno();
        eventoRetorno.setVersao("1.0");

        final NFInfoEventoRetorno infoEventoRetorno = new NFInfoEventoRetorno();
        infoEventoRetorno.setAmbiente(NFAmbiente.PRODUCAO);
        infoEventoRetorno.setChave("hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6");
        infoEventoRetorno.setCodigoStatus(1);
        infoEventoRetorno.setCpnj("99999999999999");
        infoEventoRetorno.setDataHoraRegistro(new LocalDateTime(0));
        infoEventoRetorno.setDescricaoEvento("sdskjdkjdsdcklkjdsakndcsakjdckdljsdckjasldnclakjdsalkdcskdjacdsadcsacd");
        infoEventoRetorno.setId("123456789123456789123456789123456789123456789");
        infoEventoRetorno.setMotivo("asdsdsjdslkdjsaldjsldk");
        infoEventoRetorno.setNumeroProtocolo("999999999999999");
        infoEventoRetorno.setOrgao(NFUnidadeFederativa.GO);
        infoEventoRetorno.setTipoEvento("110111");
        infoEventoRetorno.setVersaoAplicativo("SVRS201601161016");

        eventoRetorno.setInfoEventoRetorno(infoEventoRetorno);

        procEvento.setEventoRetorno(eventoRetorno);
        procEvento.setEvento(FabricaDeObjetosFake.getNFEventoCancelamento());
        
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        isoFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        String data = isoFormat.format(infoEventoRetorno.getDataHoraRegistro().toDate());

        String xmlEsperado = "<procEventoNFe versao=\"1.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><evento versao=\"3.10\"><infEvento Id=\"hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6\"><cOrgao>42</cOrgao><tpAmb>2</tpAmb><CNPJ>12345678901234</CNPJ><chNFe>81568004734874930428983724940883089298523837</chNFe><dhEvento>${dhRegEvento}</dhEvento><tpEvento>123456</tpEvento><nSeqEvento>2</nSeqEvento><verEvento>2.49</verEvento><detEvento versao=\"3.10\"><descEvento>Cancelamento</descEvento><nProt>123456789012345</nProt><xJust>Justificativa qualquer coisa</xJust></detEvento></infEvento></evento><retEvento versao=\"1.0\"><infEvento Id=\"123456789123456789123456789123456789123456789\"><tpAmb>1</tpAmb><verAplic>SVRS201601161016</verAplic><cOrgao>52</cOrgao><cStat>1</cStat><xMotivo>asdsdsjdslkdjsaldjsldk</xMotivo><chNFe>hluU2zKt4QK5bEktOiGfpZw64535p2A4Z5m5egLQbMpjnCH48c1aw6</chNFe><tpEvento>110111</tpEvento><xEvento>sdskjdkjdsdcklkjdsakndcsakjdckdljsdckjasldnclakjdsalkdcskdjacdsadcsacd</xEvento><CNPJDest>99999999999999</CNPJDest><dhRegEvento>${dhRegEvento}</dhRegEvento><nProt>999999999999999</nProt></infEvento></retEvento></procEventoNFe>";
        
        xmlEsperado = xmlEsperado.replace("${dhRegEvento}", data); 
        
        Assert.assertEquals(xmlEsperado, procEvento.toString());
    }
}
