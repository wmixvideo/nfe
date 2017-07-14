package com.fincatto.nfe310.classes.lote.envio;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.FabricaDeObjetosFake;
import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class NFLoteEnvioRetornoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFLoteEnvioRetorno retorno = new NFLoteEnvioRetorno();
        retorno.setAmbiente(NFAmbiente.HOMOLOGACAO);
        retorno.setDataRecebimento(new LocalDateTime(0));
        retorno.setInfoRecebimento(FabricaDeObjetosFake.getNFLoteEnvioRetornoRecebimentoInfo());
        retorno.setMotivo("kdosfksodf");
        retorno.setStatus("iejsasfisf");
        retorno.setUf(NFUnidadeFederativa.BA);
        retorno.setVersao("2.00");
        retorno.setVersaoAplicacao("2.00");
        
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        isoFormat.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        String data = isoFormat.format(retorno.getDataRecebimento().toDate());

        String xmlEsperado = "<retEnviNFe versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><verAplic>2.00</verAplic><cStat>iejsasfisf</cStat><xMotivo>kdosfksodf</xMotivo><cUF>29</cUF><dhRecbto>${dhRecbto}</dhRecbto><infRec><nRec>845e40545</nRec><tMed>430kfszodkgvre</tMed></infRec></retEnviNFe>";
        
        xmlEsperado = xmlEsperado.replace("${dhRecbto}", data);
        
        Assert.assertEquals(xmlEsperado, retorno.toString());
    }
}