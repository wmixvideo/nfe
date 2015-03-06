package com.fincatto.nfe310.classes;

import java.text.SimpleDateFormat;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;

public class NFProtocoloInfoTest {

    @Test
    public void deveFormatarDataComOuSemTimeZone() throws Exception {
        final LocalDateTime formatoAntigo = LocalDateTime.parse("2015-01-01T10:20:30", DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss"));
        final LocalDateTime formatoNovo = LocalDateTime.fromDateFields(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse("2015-01-01T10:20:30-05:00"));
        final NFProtocoloInfo protocoloInfo = new NFProtocoloInfo();
        protocoloInfo.setDataRecebimento("2015-01-01T10:20:30");
        Assert.assertEquals(formatoAntigo, protocoloInfo.getDataRecebimento());
        protocoloInfo.setDataRecebimento("2015-01-01T10:20:30-05:00");
        Assert.assertEquals(formatoNovo, protocoloInfo.getDataRecebimento());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFProtocoloInfo Id=\"ID798456123\"><tpAmb>2</tpAmb><verAplic>3.10</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-06-10T09:00:00-03:00</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></NFProtocoloInfo>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFProtocoloInfo().toString());
    }
}