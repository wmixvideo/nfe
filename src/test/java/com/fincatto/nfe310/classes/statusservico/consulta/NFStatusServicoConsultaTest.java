package com.fincatto.nfe310.classes.statusservico.consulta;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.dfe.classes.DFAmbiente;
import com.fincatto.dfe.classes.DFUnidadeFederativa;
import com.fincatto.nfe310.FabricaDeObjetosFake;

public class NFStatusServicoConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFStatusServicoConsulta consulta = new NFStatusServicoConsulta();
        final String versao = "2.00";
        consulta.setVersao(versao);
        Assert.assertEquals(versao, consulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFStatusServicoConsulta consulta = new NFStatusServicoConsulta();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        consulta.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, consulta.getAmbiente());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFStatusServicoConsulta consultaRetorno = new NFStatusServicoConsulta();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.AC;
        consultaRetorno.setUf(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, consultaRetorno.getUf());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final NFStatusServicoConsulta consulta = new NFStatusServicoConsulta();
        final String servico = "STATUS";
        consulta.setServico(servico);
        Assert.assertEquals(servico, consulta.getServico());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<consStatServ versao=\"3.10\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>1</tpAmb><cUF>52</cUF><xServ>STATUS</xServ></consStatServ>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFStatusServicoConsulta().toString());
    }
}