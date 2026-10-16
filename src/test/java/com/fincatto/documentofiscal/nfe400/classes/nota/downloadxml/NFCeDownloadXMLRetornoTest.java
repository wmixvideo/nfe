package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFCeDownloadXMLRetornoTest {

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
        Assertions.assertEquals("2026-07-21T15:00:00-03:00", retorno.getProc().getNfeProc().getDataHoraInclusao());
        Assertions.assertNull(retorno.getProc().getNfeProc().getNota());
    }
}
