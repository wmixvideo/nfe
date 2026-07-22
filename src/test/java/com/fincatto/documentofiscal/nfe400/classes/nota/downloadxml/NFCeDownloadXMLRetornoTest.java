package com.fincatto.documentofiscal.nfe400.classes.nota.downloadxml;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.Assert;
import org.junit.Test;

public class NFCeDownloadXMLRetornoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setVersao("1.00");
        Assert.assertEquals("1.00", retorno.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, retorno.getAmbiente());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setStatus("200");
        Assert.assertEquals("200", retorno.getStatus());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        retorno.setMotivo("Consulta realizada com sucesso");
        Assert.assertEquals("Consulta realizada com sucesso", retorno.getMotivo());
    }

    @Test
    public void deveObterProcComoFoiSetado() {
        final NFCeDownloadXMLRetorno retorno = new NFCeDownloadXMLRetorno();
        final NFCeDownloadXMLRetornoProc proc = new NFCeDownloadXMLRetornoProc();
        retorno.setProc(proc);
        Assert.assertEquals(proc, retorno.getProc());
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

        Assert.assertNotNull(retorno);
        Assert.assertEquals("205", retorno.getStatus());
        Assert.assertEquals("Rejeicao: Chave nao encontrada", retorno.getMotivo());
        Assert.assertNull(retorno.getProc());
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

        Assert.assertNotNull(retorno);
        Assert.assertNotNull(retorno.getProc());
        Assert.assertNotNull(retorno.getProc().getNfeProc());
        Assert.assertEquals("135260000000010", retorno.getProc().getNfeProc().getNumeroProtocolo());
        Assert.assertEquals("2026-07-21T15:00:00-03:00", retorno.getProc().getNfeProc().getDataHoraInclusao());
        Assert.assertNull(retorno.getProc().getNfeProc().getNota());
    }
}
