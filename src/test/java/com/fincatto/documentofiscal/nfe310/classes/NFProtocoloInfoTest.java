package com.fincatto.documentofiscal.nfe310.classes;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

public class NFProtocoloInfoTest {

    @Test
    public void deveObterIdentificadorComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final String identificador = "ID798456123";
        protocoloInfo.setIdentificador(identificador);
        Assert.assertEquals(identificador, protocoloInfo.getIdentificador());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final String versaoAplicacao = "3.10";
        protocoloInfo.setVersaoAplicacao(versaoAplicacao);
        Assert.assertEquals(versaoAplicacao, protocoloInfo.getVersaoAplicacao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        protocoloInfo.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, protocoloInfo.getAmbiente());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final String chave = "27453083767543876731879602388114613152665633";
        protocoloInfo.setChave(chave);
        Assert.assertEquals(chave, protocoloInfo.getChave());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final String motivo = "Autorizado o seu uso";
        protocoloInfo.setMotivo(motivo);
        Assert.assertEquals(motivo, protocoloInfo.getMotivo());
    }

    @Test
    public void deveObterValidadorComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final String validador = "validador";
        protocoloInfo.setValidador(validador);
        Assert.assertEquals(validador, protocoloInfo.getValidador());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final String numeroProtocolo = "123456789";
        protocoloInfo.setNumeroProtocolo(numeroProtocolo);
        Assert.assertEquals(numeroProtocolo, protocoloInfo.getNumeroProtocolo());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        final String status = "100";
        protocoloInfo.setStatus(status);
        Assert.assertEquals(status, protocoloInfo.getStatus());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFProtocoloInfo Id=\"ID798456123\"><tpAmb>2</tpAmb><verAplic>3.10</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-06-10T09:00:00-03:00</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></NFProtocoloInfo>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFProtocoloInfo().toString());
    }
}