package com.fincatto.documentofiscal.nfe400.classes.nota.listagemchaves;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.utils.DFPersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NFCeListagemChavesRetornoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFCeListagemChavesRetorno retorno = new NFCeListagemChavesRetorno();
        retorno.setVersao("1.00");
        Assertions.assertEquals("1.00", retorno.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFCeListagemChavesRetorno retorno = new NFCeListagemChavesRetorno();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, retorno.getAmbiente());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final NFCeListagemChavesRetorno retorno = new NFCeListagemChavesRetorno();
        retorno.setStatus("100");
        Assertions.assertEquals("100", retorno.getStatus());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFCeListagemChavesRetorno retorno = new NFCeListagemChavesRetorno();
        retorno.setMotivo("Consulta realizada com sucesso");
        Assertions.assertEquals("Consulta realizada com sucesso", retorno.getMotivo());
    }

    @Test
    public void deveObterChavesComoFoiSetado() {
        final NFCeListagemChavesRetorno retorno = new NFCeListagemChavesRetorno();
        final List<String> chaves = Arrays.asList("35260714200166000166650010000000011000000010", "35260714200166000166650010000000021000000029");
        retorno.setChaves(chaves);
        Assertions.assertEquals(chaves, retorno.getChaves());
    }

    @Test
    public void deveObterDataHoraEmissaoUltimaNFCeComoFoiSetado() {
        final NFCeListagemChavesRetorno retorno = new NFCeListagemChavesRetorno();
        retorno.setDataHoraEmissaoUltimaNFCe("2026-07-21T15:30:00");
        Assertions.assertEquals("2026-07-21T15:30:00", retorno.getDataHoraEmissaoUltimaNFCe());
    }

    @Test
    public void deveFazerParseDoXmlDeRetornoComListaDeChaves() throws Exception {
        final String xml = "<retNfceListagemChaves versao=\"1.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>SP_NFCE_PL001</verAplic>"
                + "<dhReq>2026-07-21T15:30:00</dhReq>"
                + "<cStat>100</cStat>"
                + "<xMotivo>Consulta realizada com sucesso</xMotivo>"
                + "<chNFCe>35260714200166000166650010000000011000000010</chNFCe>"
                + "<chNFCe>35260714200166000166650010000000021000000029</chNFCe>"
                + "<dhEmisUltNfce>2026-07-21T15:00:00</dhEmisUltNfce>"
                + "</retNfceListagemChaves>";

        final NFCeListagemChavesRetorno retorno = new DFPersister().read(NFCeListagemChavesRetorno.class, xml);

        Assertions.assertNotNull(retorno);
        Assertions.assertEquals("100", retorno.getStatus());
        Assertions.assertEquals("Consulta realizada com sucesso", retorno.getMotivo());
        Assertions.assertEquals(2, retorno.getChaves().size());
        Assertions.assertEquals("2026-07-21T15:00:00", retorno.getDataHoraEmissaoUltimaNFCe());
    }

    @Test
    public void deveFazerParseDoXmlDeRetornoSemChaves() throws Exception {
        final String xml = "<retNfceListagemChaves versao=\"1.00\">"
                + "<tpAmb>2</tpAmb>"
                + "<verAplic>SP_NFCE_PL001</verAplic>"
                + "<dhReq>2026-07-21T15:30:00</dhReq>"
                + "<cStat>107</cStat>"
                + "<xMotivo>Consulta realizada com sucesso, mas sem registros</xMotivo>"
                + "</retNfceListagemChaves>";

        final NFCeListagemChavesRetorno retorno = new DFPersister().read(NFCeListagemChavesRetorno.class, xml);

        Assertions.assertNotNull(retorno);
        Assertions.assertEquals("107", retorno.getStatus());
        Assertions.assertNull(retorno.getChaves());
    }
}
