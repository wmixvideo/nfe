package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class NFCeDownloadXMLRetornoTest {

    private static final String EVENTO = "<evento versao=\"1.00\"><infEvento Id=\"ID1101113526071420016600016665001000000001100000001001\"><cOrgao>35</cOrgao><tpAmb>2</tpAmb><CNPJ>14200166000166</CNPJ><chNFe>35260714200166000166650010000000011000000010</chNFe><dhEvento>2026-07-22T09:59:00-03:00</dhEvento><tpEvento>110111</tpEvento><nSeqEvento>1</nSeqEvento><verEvento>1.00</verEvento><detEvento versao=\"1.00\"><descEvento>Cancelamento</descEvento><nProt>135260000000010</nProt><xJust>Justificativa de cancelamento de teste</xJust></detEvento></infEvento></evento>";

    private static final String RET_EVENTO = "<retEvento versao=\"1.00\"><infEvento><tpAmb>2</tpAmb><verAplic>SP_NFCE_PL001</verAplic><cOrgao>35</cOrgao><cStat>135</cStat><xMotivo>Evento registrado e vinculado a NFC-e</xMotivo><chNFe>35260714200166000166650010000000011000000010</chNFe><tpEvento>110111</tpEvento><nSeqEvento>1</nSeqEvento><dhRegEvento>2026-07-22T10:00:00-03:00</dhRegEvento><nProt>999999999999999</nProt></infEvento></retEvento>";

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setVersao("1.00");
        Assertions.assertEquals("1.00", retorno.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, retorno.getAmbiente());
    }

    @Test
    public void deveObterDataHoraRequisicaoComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setDataHoraRequisicao(LocalDateTime.of(2026, 7, 21, 15, 30));
        Assertions.assertEquals(LocalDateTime.of(2026, 7, 21, 15, 30), retorno.getDataHoraRequisicao());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setStatus("200");
        Assertions.assertEquals("200", retorno.getStatus());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setMotivo("Consulta realizada com sucesso");
        Assertions.assertEquals("Consulta realizada com sucesso", retorno.getMotivo());
    }

    @Test
    public void deveObterProcComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        final NFCeDownloadXMLRetornoProc proc = new NFCeDownloadXMLRetornoProc();
        retorno.setProc(proc);
        Assertions.assertEquals(proc, retorno.getProc());
    }

    @Test
    public void deveFazerParseDoXmlDeRetornoSemProc() throws Exception {
        final String xml = "<retNfceDownloadXML versao=\"1.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>SP_NFCE_PL001</verAplic>"
                + "<dhReq>2026-07-21T15:30:00</dhReq>"
                + "<cStat>205</cStat>"
                + "<xMotivo>Rejeicao: Chave nao encontrada</xMotivo>"
                + "</retNfceDownloadXML>";

        final NFCeDownloadXMLRetorno retorno = new DFPersister().read(NFCeDownloadXMLRetorno.class, xml);

        Assertions.assertNotNull(retorno);
        Assertions.assertEquals("205", retorno.getStatus());
        Assertions.assertEquals("Rejeicao: Chave nao encontrada", retorno.getMotivo());
        Assertions.assertNull(retorno.getProc());
    }

    @Test
    public void deveFazerParseDoXmlDeRetornoComProcENfeProcSemDetalhes() throws Exception {
        final String xml = "<retNfceDownloadXML versao=\"1.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>SP_NFCE_PL001</verAplic>"
                + "<dhReq>2026-07-21T15:30:00</dhReq>"
                + "<cStat>200</cStat>"
                + "<xMotivo>Consulta realizada com sucesso</xMotivo>"
                + "<proc>"
                + "<nfeProc versao=\"1.00\">"
                + "<dhInc>2026-07-21T15:00:00-03:00</dhInc>"
                + "<nProt>135260000000010</nProt>"
                + "</nfeProc>"
                + "</proc>"
                + "</retNfceDownloadXML>";

        final NFCeDownloadXMLRetorno retorno = new DFPersister().read(NFCeDownloadXMLRetorno.class, xml);

        Assertions.assertNotNull(retorno);
        Assertions.assertNotNull(retorno.getProc());
        Assertions.assertNotNull(retorno.getProc().getNfeProc());
        Assertions.assertEquals("135260000000010", retorno.getProc().getNfeProc().getNumeroProtocolo());
        Assertions.assertEquals(ZonedDateTime.parse("2026-07-21T15:00:00-03:00"), retorno.getProc().getNfeProc().getDataHoraInclusao());
        Assertions.assertEquals(LocalDateTime.of(2026, 7, 21, 15, 30), retorno.getDataHoraRequisicao());
        Assertions.assertNull(retorno.getProc().getNfeProc().getNota());
        Assertions.assertNull(retorno.getProc().getNfeProc().getProtocolo());
    }

    @Test
    public void deveFazerParseDoXmlDeRetornoComNotaProtocoloEEventos() throws Exception {
        final String xml = "<retNfceDownloadXML versao=\"1.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>SP_NFCE_PL001</verAplic>"
                + "<dhReq>2026-07-21T15:30:00</dhReq>"
                + "<cStat>200</cStat>"
                + "<xMotivo>Consulta realizada com sucesso</xMotivo>"
                + "<proc>"
                + "<nfeProc versao=\"1.00\">"
                + "<dhInc>2026-07-21T15:00:00-03:00</dhInc>"
                + "<nProt>135260000000010</nProt>"
                + FabricaDeObjetosFake.getNFNota().toString()
                + FabricaDeObjetosFake.getNFProtocolo().toString()
                + "</nfeProc>"
                + "<procEventoNFe versao=\"1.00\">"
                + "<dhInc>2026-07-22T10:00:00-03:00</dhInc>"
                + "<nProt>135260000000029</nProt>"
                + EVENTO
                + RET_EVENTO
                + "</procEventoNFe>"
                + "</proc>"
                + "</retNfceDownloadXML>";

        final NFCeDownloadXMLRetorno retorno = new DFPersister().read(NFCeDownloadXMLRetorno.class, xml);

        final NFCeDownloadXMLRetornoNfeProc nfeProc = retorno.getProc().getNfeProc();
        Assertions.assertEquals(FabricaDeObjetosFake.getNFNota().toString(), nfeProc.getNota().toString());
        Assertions.assertEquals(FabricaDeObjetosFake.getNFProtocolo().toString(), nfeProc.getProtocolo().toString());

        Assertions.assertEquals(1, retorno.getProc().getProcEventoNFe().size());
        final NFCeDownloadXMLRetornoProcEventoNFe procEvento = retorno.getProc().getProcEventoNFe().get(0);
        Assertions.assertEquals(ZonedDateTime.parse("2026-07-22T10:00:00-03:00"), procEvento.getDataHoraInclusao());
        Assertions.assertEquals("135260000000029", procEvento.getNumeroProtocolo());
        Assertions.assertEquals("ID1101113526071420016600016665001000000001100000001001", procEvento.getEvento().getInfoEvento().getId());
        Assertions.assertEquals("999999999999999", procEvento.getEventoRetorno().getInfoEventoRetorno().getNumeroProtocolo());
    }

    @Test
    public void deveIgnorarElementosDesconhecidosDentroDoNfeProc() throws Exception {
        final String xml = "<retNfceDownloadXML versao=\"1.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>SP_NFCE_PL001</verAplic>"
                + "<dhReq>2026-07-21T15:30:00</dhReq>"
                + "<cStat>200</cStat>"
                + "<xMotivo>Consulta realizada com sucesso</xMotivo>"
                + "<proc>"
                + "<nfeProc versao=\"1.00\">"
                + "<dhInc>2026-07-21T15:00:00-03:00</dhInc>"
                + "<nProt>135260000000010</nProt>"
                + "<elementoNaoMapeado>valor</elementoNaoMapeado>"
                + "</nfeProc>"
                + "</proc>"
                + "</retNfceDownloadXML>";

        final NFCeDownloadXMLRetorno retorno = new DFPersister().read(NFCeDownloadXMLRetorno.class, xml);

        Assertions.assertEquals("135260000000010", retorno.getProc().getNfeProc().getNumeroProtocolo());
    }
}
