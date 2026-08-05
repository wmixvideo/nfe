package com.fincatto.documentofiscal.cte400.classes.envio;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.Assert;
import org.junit.Test;

public class CTeProtocoloInfoTest {

    // --------------------------------- Getters / Setters ---------------------------------

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, info.getAmbiente());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setVersaoAplicacao("4.00");
        Assert.assertEquals("4.00", info.getVersaoAplicacao());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        final String chave = "35260502605000000019657001000000604144867901";
        info.setChave(chave);
        Assert.assertEquals(chave, info.getChave());
    }

    @Test
    public void deveObterDataRecebimentoComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setDataRecebimento("2023-01-01T10:00:00-03:00");
        Assert.assertEquals("2023-01-01T10:00:00-03:00", info.getDataRecebimento());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setNumeroProtocolo("415200000012345");
        Assert.assertEquals("415200000012345", info.getNumeroProtocolo());
    }

    @Test
    public void deveObterValidadorComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setValidador("abc123digest");
        Assert.assertEquals("abc123digest", info.getValidador());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setStatus("100");
        Assert.assertEquals("100", info.getStatus());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setMotivo("Autorizado o uso do CT-e");
        Assert.assertEquals("Autorizado o uso do CT-e", info.getMotivo());
    }

    @Test
    public void deveObterIdComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setId("CTe35260502605000000019657001000000604144867901");
        Assert.assertEquals("CTe35260502605000000019657001000000604144867901", info.getId());
    }

    // --------------------------------- Serialização XML ---------------------------------

    @Test
    public void deveGerarXMLComChaveQuandoChaveEstiverPresente() {
        final CTeProtocoloInfo info = buildProtocoloInfoCompleto();
        final String xml = info.toString();
        Assert.assertTrue("XML deve conter <chCTe>", xml.contains("<chCTe>35260502605000000019657001000000604144867901</chCTe>"));
        Assert.assertTrue("XML deve conter <tpAmb>", xml.contains("<tpAmb>2</tpAmb>"));
        Assert.assertTrue("XML deve conter <verAplic>", xml.contains("<verAplic>4.00</verAplic>"));
        Assert.assertTrue("XML deve conter <cStat>", xml.contains("<cStat>100</cStat>"));
    }

    @Test
    public void deveGerarXMLSemChaveQuandoChaveForNula() {
        final CTeProtocoloInfo info = buildProtocoloInfoSemChave();
        final String xml = info.toString();
        Assert.assertFalse("XML nao deve conter <chCTe> quando chave e nula", xml.contains("<chCTe>"));
        Assert.assertTrue("XML deve conter <tpAmb>", xml.contains("<tpAmb>2</tpAmb>"));
        Assert.assertTrue("XML deve conter <cStat>", xml.contains("<cStat>500</cStat>"));
    }

    // --------------------------------- Desserialização XML ---------------------------------

    @Test
    public void deveDesserializarXMLComChavePresente() throws Exception {
        final DFPersister persister = new DFPersister();
        final String xml = "<infProt xmlns=\"http://www.portalfiscal.inf.br/cte\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>4.00</verAplic>"
                + "<chCTe>35260502605000000019657001000000604144867901</chCTe>"
                + "<dhRecbto>2023-01-01T10:00:00-03:00</dhRecbto>"
                + "<nProt>415200000012345</nProt>"
                + "<digVal>abc123digest</digVal>"
                + "<cStat>100</cStat>"
                + "<xMotivo>Autorizado o uso do CT-e</xMotivo>"
                + "</infProt>";

        final CTeProtocoloInfo result = persister.read(CTeProtocoloInfo.class, xml);

        Assert.assertNotNull(result);
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, result.getAmbiente());
        Assert.assertEquals("4.00", result.getVersaoAplicacao());
        Assert.assertEquals("35260502605000000019657001000000604144867901", result.getChave());
        Assert.assertEquals("2023-01-01T10:00:00-03:00", result.getDataRecebimento());
        Assert.assertEquals("415200000012345", result.getNumeroProtocolo());
        Assert.assertEquals("abc123digest", result.getValidador());
        Assert.assertEquals("100", result.getStatus());
        Assert.assertEquals("Autorizado o uso do CT-e", result.getMotivo());
    }

    /**
     * Teste principal do fix: CT-e rejeitado nao possui chCTe no retorno da SEFAZ.
     * Antes do fix lancava:
     * "Unable to satisfy @Element(name="chCTe", required=true) on field 'chave'..."
     */
    @Test
    public void deveDesserializarXMLSemChaveSemLancarExcecao() throws Exception {
        final DFPersister persister = new DFPersister();
        final String xml = "<infProt xmlns=\"http://www.portalfiscal.inf.br/cte\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>4.00</verAplic>"
                + "<dhRecbto>2023-01-01T10:00:00-03:00</dhRecbto>"
                + "<cStat>500</cStat>"
                + "<xMotivo>Rejeicao: CT-e invalido</xMotivo>"
                + "</infProt>";

        final CTeProtocoloInfo result = persister.read(CTeProtocoloInfo.class, xml);

        Assert.assertNotNull(result);
        Assert.assertNull("Chave deve ser nula quando ausente no XML", result.getChave());
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, result.getAmbiente());
        Assert.assertEquals("500", result.getStatus());
        Assert.assertEquals("Rejeicao: CT-e invalido", result.getMotivo());
    }

    @Test
    public void deveRealizarRoundTripDeSerializacaoComChave() throws Exception {
        final DFPersister persister = new DFPersister();
        final CTeProtocoloInfo original = buildProtocoloInfoCompleto();
        final String xml = original.toString();
        final CTeProtocoloInfo lido = persister.read(CTeProtocoloInfo.class, xml);

        Assert.assertNotNull(lido);
        Assert.assertEquals(original.getAmbiente(), lido.getAmbiente());
        Assert.assertEquals(original.getVersaoAplicacao(), lido.getVersaoAplicacao());
        Assert.assertEquals(original.getChave(), lido.getChave());
        Assert.assertEquals(original.getDataRecebimento(), lido.getDataRecebimento());
        Assert.assertEquals(original.getNumeroProtocolo(), lido.getNumeroProtocolo());
        Assert.assertEquals(original.getValidador(), lido.getValidador());
        Assert.assertEquals(original.getStatus(), lido.getStatus());
        Assert.assertEquals(original.getMotivo(), lido.getMotivo());
    }

    // --------------------------------- Helpers ---------------------------------

    private CTeProtocoloInfo buildProtocoloInfoCompleto() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setAmbiente(DFAmbiente.HOMOLOGACAO);
        info.setVersaoAplicacao("4.00");
        info.setChave("35260502605000000019657001000000604144867901");
        info.setDataRecebimento("2023-01-01T10:00:00-03:00");
        info.setNumeroProtocolo("415200000012345");
        info.setValidador("abc123digest");
        info.setStatus("100");
        info.setMotivo("Autorizado o uso do CT-e");
        return info;
    }

    private CTeProtocoloInfo buildProtocoloInfoSemChave() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setAmbiente(DFAmbiente.HOMOLOGACAO);
        info.setVersaoAplicacao("4.00");
        info.setDataRecebimento("2023-01-01T10:00:00-03:00");
        info.setStatus("500");
        info.setMotivo("Rejeicao: CT-e invalido");
        return info;
    }
}

