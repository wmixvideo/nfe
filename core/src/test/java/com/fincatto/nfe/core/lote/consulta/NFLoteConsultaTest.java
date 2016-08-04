package com.fincatto.nfe.core.lote.consulta;

import com.fincatto.nfe.core.NFAmbiente;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFLoteConsultaTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setAmbiente(NFAmbiente.HOMOLOGACAO);
        consulta.setRecibo("ItbDxsHiXUqeCEM");
        consulta.setVersao(new BigDecimal("2.00"));

        final String xmlEsperado = "<consReciNFe versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><nRec>ItbDxsHiXUqeCEM</nRec></consReciNFe>";
        Assert.assertEquals(xmlEsperado, consulta.toString());
    }
}