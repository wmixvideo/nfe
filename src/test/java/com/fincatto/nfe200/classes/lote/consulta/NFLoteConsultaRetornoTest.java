package com.fincatto.nfe200.classes.lote.consulta;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.NFAmbiente;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;
import com.fincatto.nfe200.classes.lote.consulta.NFLoteConsultaRetorno;

public class NFLoteConsultaRetornoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFLoteConsultaRetorno retorno = new NFLoteConsultaRetorno();
        retorno.setAmbiente(NFAmbiente.HOMOLOGACAO);
        retorno.setMotivo("8CwtnC5gWwUncMBYAZl9p4fvVx8RkCH2EKx2mtUNVA5tLoJsjNWL5CJ6DXNUHTWKpPl6fMKKxA0aXBu6IfmJLIHlPxtF0oZkKrNsGyGpwKqWxvDZ9HQGqscmhtTrp5NbNzk9TOsCJaMU59tF8kOxu0EUZAMLF8bGJteg86T4hQ6ej5Zi0n1Tin0vFAtN1ue68NWrfQWM11VPpqvSXRlaa8qIw1Qal8tWCFGJA0wZpl7eV98bAYL18pt3e71yKcX");
        retorno.setNumeroRecibo("123456789012345");
        retorno.setProtocolos(Arrays.asList(FabricaDeObjetosFake.getNFProtocolo()));
        retorno.setStatus("eeowo");
        retorno.setUf(NFUnidadeFederativa.SC);
        retorno.setVersao("2.00");
        retorno.setVersaoAplicacao("2.00");
        retorno.setCodigoMessage("dfksfod");
        retorno.setMensagem("sfjoijegiojariogjreiogjseriogjioesrjgoigresij");

        final String xmlEsperado = "<retConsReciNFe versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><verAplic>2.00</verAplic><nRec>123456789012345</nRec><cStat>eeowo</cStat><xMotivo>8CwtnC5gWwUncMBYAZl9p4fvVx8RkCH2EKx2mtUNVA5tLoJsjNWL5CJ6DXNUHTWKpPl6fMKKxA0aXBu6IfmJLIHlPxtF0oZkKrNsGyGpwKqWxvDZ9HQGqscmhtTrp5NbNzk9TOsCJaMU59tF8kOxu0EUZAMLF8bGJteg86T4hQ6ej5Zi0n1Tin0vFAtN1ue68NWrfQWM11VPpqvSXRlaa8qIw1Qal8tWCFGJA0wZpl7eV98bAYL18pt3e71yKcX</xMotivo><cUF>42</cUF><cMsg>dfksfod</cMsg><xMsg>sfjoijegiojariogjreiogjseriogjioesrjgoigresij</xMsg><protNFe versao=\"2.00\"><infProt Id=\"HAIJIEIAe\"><tpAmb>2</tpAmb><verAplic>2.00</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-12-12T10:10:10</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></infProt></protNFe></retConsReciNFe>";
        Assert.assertEquals(xmlEsperado, retorno.toString());
    }
}