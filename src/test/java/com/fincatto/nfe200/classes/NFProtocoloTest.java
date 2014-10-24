package com.fincatto.nfe200.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;

public class NFProtocoloTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFProtocolo versao=\"2.00\"><infProt Id=\"HAIJIEIAe\"><tpAmb>2</tpAmb><verAplic>2.00</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-12-12T10:10:10</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></infProt></NFProtocolo>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFProtocolo().toString());
    }
}