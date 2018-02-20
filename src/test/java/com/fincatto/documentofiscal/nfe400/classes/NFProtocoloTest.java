package com.fincatto.documentofiscal.nfe400.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFProtocoloTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFProtocolo protocolo = new NFProtocolo();
        final String versao = "3.10";
        protocolo.setVersao(versao);
        Assert.assertEquals(versao, protocolo.getVersao());
    }

    @Test
    public void deveObterProtocoloInfoComoFoiSetado() {
        final NFProtocolo protocolo = new NFProtocolo();
        final NFProtocoloInfo protocoloInfo = FabricaDeObjetosFake.getNFProtocoloInfo();
        protocolo.setProtocoloInfo(protocoloInfo);
        Assert.assertEquals(protocoloInfo, protocolo.getProtocoloInfo());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<protNFe versao=\"4.00\"><infProt Id=\"ID798456123\"><tpAmb>2</tpAmb><verAplic>4.00</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-06-10T09:00:00-03:00</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></infProt></protNFe>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFProtocolo().toString());
    }
}