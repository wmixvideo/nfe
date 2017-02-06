package com.fincatto.cte300.classes.statusservico.consulta;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.cte300.FabricaDeObjetosFakeCTe;
import com.fincatto.cte300.classes.statusservico.consulta.CTStatusServicoConsulta;
import com.fincatto.dfe.classes.DFAmbiente;

public class CTStatusServicoConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final CTStatusServicoConsulta consulta = new CTStatusServicoConsulta();
        final String versao = "2.00";
        consulta.setVersao(versao);
        Assert.assertEquals(versao, consulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final CTStatusServicoConsulta consulta = new CTStatusServicoConsulta();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        consulta.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, consulta.getAmbiente());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final CTStatusServicoConsulta consulta = new CTStatusServicoConsulta();
        final String servico = "STATUS";
        consulta.setServico(servico);
        Assert.assertEquals(servico, consulta.getServico());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<consStatServCte versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/cte\"><tpAmb>1</tpAmb><xServ>STATUS</xServ></consStatServCte>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFakeCTe.getCTStatusServicoConsulta().toString());
    }
}