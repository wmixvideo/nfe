package com.fincatto.documentofiscal.nfe400.classes.lote.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFLoteConsultaTest {

    @Test
    public void deveGerarAmbienteHomologacao(){
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, consulta.getAmbiente());
    }

    @Test
    public void deveGerarComVersao400(){
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setVersao(new BigDecimal("4.00"));
        Assertions.assertEquals("4.00", consulta.getVersao());
    }

    @Test
    public void deveGerarComRecibo(){
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setRecibo("ItbDxsHiXUqeCEM");
        Assertions.assertEquals("ItbDxsHiXUqeCEM", consulta.getRecibo());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFLoteConsulta consulta = new NFLoteConsulta();
        consulta.setAmbiente(DFAmbiente.HOMOLOGACAO);
        consulta.setRecibo("ItbDxsHiXUqeCEM");
        consulta.setVersao(new BigDecimal("4.00"));

        final String xmlEsperado = "<consReciNFe versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><nRec>ItbDxsHiXUqeCEM</nRec></consReciNFe>";
        Assertions.assertEquals(xmlEsperado, consulta.toString());
    }
}