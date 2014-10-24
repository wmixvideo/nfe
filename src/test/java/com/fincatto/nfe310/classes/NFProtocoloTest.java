package com.fincatto.nfe310.classes;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;

public class NFProtocoloTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<protNFe versao=\"3.10\"><infProt Id=\"ID798456123\"><tpAmb>2</tpAmb><verAplic>3.10</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-06-10T09:00:00-03:00</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></infProt></protNFe>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFProtocolo().toString());
    }
}