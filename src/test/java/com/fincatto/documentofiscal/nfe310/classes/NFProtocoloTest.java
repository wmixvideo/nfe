package com.fincatto.documentofiscal.nfe310.classes;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFProtocoloTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFProtocolo protocolo = new NFProtocolo();
        final String versao = "3.10";
        protocolo.setVersao(versao);
        Assertions.assertEquals(versao, protocolo.getVersao());
    }

    @Test
    public void deveObterProtocoloInfoComoFoiSetado() {
        final NFProtocolo protocolo = new NFProtocolo();
        final NFProtocoloInfo protocoloInfo = FabricaDeObjetosFake.getNFProtocoloInfo();
        protocolo.setProtocoloInfo(protocoloInfo);
        Assertions.assertEquals(protocoloInfo, protocolo.getProtocoloInfo());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<protNFe versao=\"3.10\"><infProt Id=\"ID798456123\"><tpAmb>2</tpAmb><verAplic>3.10</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-06-10T09:00:00-03:00</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></infProt></protNFe>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFProtocolo().toString());
    }
}