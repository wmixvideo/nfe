package com.fincatto.documentofiscal.nfe400.classes.lote.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class NFLoteConsultaRetornoTest {

    @Test
    public void deveGerarAmbienteHomologacao() {
        final NFLoteConsultaRetorno retorno = new NFLoteConsultaRetorno();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assert.assertEquals(DFAmbiente.HOMOLOGACAO, retorno.getAmbiente());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFLoteConsultaRetorno retorno = new NFLoteConsultaRetorno();
        retorno.setAmbiente(DFAmbiente.HOMOLOGACAO);
        retorno.setMotivo("8CwtnC5gWwUncMBYAZl9p4fvVx8RkCH2EKx2mtUNVA5tLoJsjNWL5CJ6DXNUHTWKpPl6fMKKxA0aXBu6IfmJLIHlPxtF0oZkKrNsGyGpwKqWxvDZ9HQGqscmhtTrp5NbNzk9TOsCJaMU59tF8kOxu0EUZAMLF8bGJteg86T4hQ6ej5Zi0n1Tin0vFAtN1ue68NWrfQWM11VPpqvSXRlaa8qIw1Qal8tWCFGJA0wZpl7eV98bAYL18pt3e71yKcX");
        retorno.setNumeroRecibo("123456789012345");
        retorno.setProtocolos(Collections.singletonList(FabricaDeObjetosFake.getNFProtocolo()));
        retorno.setStatus("eeowo");
        retorno.setUf(DFUnidadeFederativa.SC);
        retorno.setVersao("4.00");
        retorno.setVersaoAplicacao("1.00");
        retorno.setCodigoMessage("dfksfod");
        retorno.setMensagem("sfjoijegiojariogjreiogjseriogjioesrjgoigresij");
        retorno.setDataHoraRecebimento(LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2014-10-10 10:10:10")));

        final String xmlEsperado = "<retConsReciNFe versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><verAplic>1.00</verAplic><nRec>123456789012345</nRec><cStat>eeowo</cStat><dhRecbto>2014-10-10T10:10:10-03:00</dhRecbto><xMotivo>8CwtnC5gWwUncMBYAZl9p4fvVx8RkCH2EKx2mtUNVA5tLoJsjNWL5CJ6DXNUHTWKpPl6fMKKxA0aXBu6IfmJLIHlPxtF0oZkKrNsGyGpwKqWxvDZ9HQGqscmhtTrp5NbNzk9TOsCJaMU59tF8kOxu0EUZAMLF8bGJteg86T4hQ6ej5Zi0n1Tin0vFAtN1ue68NWrfQWM11VPpqvSXRlaa8qIw1Qal8tWCFGJA0wZpl7eV98bAYL18pt3e71yKcX</xMotivo><cUF>42</cUF><cMsg>dfksfod</cMsg><xMsg>sfjoijegiojariogjreiogjseriogjioesrjgoigresij</xMsg><protNFe versao=\"4.00\"><infProt Id=\"ID798456123\"><tpAmb>2</tpAmb><verAplic>4.00</verAplic><chNFe>EAIOjea</chNFe><dhRecbto>2014-06-10T09:00:00-03:00</dhRecbto><nProt>490309504</nProt><digVal>gfsfgsrg</digVal><cStat>OK</cStat><xMotivo>jsoaosk</xMotivo></infProt></protNFe></retConsReciNFe>";
        Assert.assertEquals(xmlEsperado, retorno.toString());
    }
}