package com.fincatto.documentofiscal.cte400.classes.envio;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTeProtocoloInfoTest {

    // --------------------------------- Getters / Setters ---------------------------------

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, info.getAmbiente());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setVersaoAplicacao("4.00");
        Assertions.assertEquals("4.00", info.getVersaoAplicacao());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        final String chave = "35260502605000000019657001000000604144867901";
        info.setChave(chave);
        Assertions.assertEquals(chave, info.getChave());
    }

    @Test
    public void deveObterDataRecebimentoComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setDataRecebimento("2023-01-01T10:00:00-03:00");
        Assertions.assertEquals("2023-01-01T10:00:00-03:00", info.getDataRecebimento());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setNumeroProtocolo("415200000012345");
        Assertions.assertEquals("415200000012345", info.getNumeroProtocolo());
    }

    @Test
    public void deveObterValidadorComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setValidador("abc123digest");
        Assertions.assertEquals("abc123digest", info.getValidador());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setStatus("100");
        Assertions.assertEquals("100", info.getStatus());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setMotivo("Autorizado o uso do CT-e");
        Assertions.assertEquals("Autorizado o uso do CT-e", info.getMotivo());
    }

    @Test
    public void deveObterIdComoFoiSetado() {
        final CTeProtocoloInfo info = new CTeProtocoloInfo();
        info.setId("CTe35260502605000000019657001000000604144867901");
        Assertions.assertEquals("CTe35260502605000000019657001000000604144867901", info.getId());
    }

    // --------------------------------- Serialização XML ---------------------------------

    @Test
    public void deveGerarXMLComChaveQuandoChaveEstiverPresente() {
        final CTeProtocoloInfo info = buildProtocoloInfoCompleto();
        final String xml = info.toString();
        Assertions.assertTrue(xml.contains("<chCTe>35260502605000000019657001000000604144867901</chCTe>"));
        Assertions.assertTrue(xml.contains("<tpAmb>2</tpAmb>"));
        Assertions.assertTrue(xml.contains("<verAplic>4.00</verAplic>"));
        Assertions.assertTrue(xml.contains("<cStat>100</cStat>"));
    }

    @Test
    public void deveGerarXMLSemChaveQuandoChaveForNula() {
        final CTeProtocoloInfo info = buildProtocoloInfoSemChave();
        final String xml = info.toString();
        Assertions.assertFalse(xml.contains("<chCTe>"));
        Assertions.assertTrue(xml.contains("<tpAmb>2</tpAmb>"));
        Assertions.assertTrue(xml.contains("<cStat>500</cStat>"));
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

        Assertions.assertNotNull(result);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, result.getAmbiente());
        Assertions.assertEquals("4.00", result.getVersaoAplicacao());
        Assertions.assertEquals("35260502605000000019657001000000604144867901", result.getChave());
        Assertions.assertEquals("2023-01-01T10:00:00-03:00", result.getDataRecebimento());
        Assertions.assertEquals("415200000012345", result.getNumeroProtocolo());
        Assertions.assertEquals("abc123digest", result.getValidador());
        Assertions.assertEquals("100", result.getStatus());
        Assertions.assertEquals("Autorizado o uso do CT-e", result.getMotivo());
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

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getChave());
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, result.getAmbiente());
        Assertions.assertEquals("500", result.getStatus());
        Assertions.assertEquals("Rejeicao: CT-e invalido", result.getMotivo());
    }

    @Test
    public void deveRealizarRoundTripDeSerializacaoComChave() throws Exception {
        final DFPersister persister = new DFPersister();
        final CTeProtocoloInfo original = buildProtocoloInfoCompleto();
        final String xml = original.toString();
        final CTeProtocoloInfo lido = persister.read(CTeProtocoloInfo.class, xml);

        Assertions.assertNotNull(lido);
        Assertions.assertEquals(original.getAmbiente(), lido.getAmbiente());
        Assertions.assertEquals(original.getVersaoAplicacao(), lido.getVersaoAplicacao());
        Assertions.assertEquals(original.getChave(), lido.getChave());
        Assertions.assertEquals(original.getDataRecebimento(), lido.getDataRecebimento());
        Assertions.assertEquals(original.getNumeroProtocolo(), lido.getNumeroProtocolo());
        Assertions.assertEquals(original.getValidador(), lido.getValidador());
        Assertions.assertEquals(original.getStatus(), lido.getStatus());
        Assertions.assertEquals(original.getMotivo(), lido.getMotivo());
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

