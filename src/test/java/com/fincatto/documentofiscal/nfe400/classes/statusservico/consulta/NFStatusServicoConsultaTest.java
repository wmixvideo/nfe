package com.fincatto.documentofiscal.nfe400.classes.statusservico.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.classes.statusservico.consulta.NFStatusServicoConsulta;
import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFStatusServicoConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final String versao = "3.10";
        servicoConsulta.setVersao(versao);
        Assertions.assertEquals(versao, servicoConsulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        servicoConsulta.setAmbiente(ambiente);
        Assertions.assertEquals(ambiente, servicoConsulta.getAmbiente());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.SP;
        servicoConsulta.setUf(unidadeFederativa);
        Assertions.assertEquals(unidadeFederativa, servicoConsulta.getUf());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final String servico = "STATUS";
        servicoConsulta.setServico(servico);
        Assertions.assertEquals(servico, servicoConsulta.getServico());
    }

    @Test
    public void deveGerarXmlCorretamente() {
        String xml = "<consStatServ versao=\"4.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\"><tpAmb>2</tpAmb><cUF>42</cUF><xServ>STATUS</xServ></consStatServ>";
        Assertions.assertEquals(xml, FabricaDeObjetosFake.getNFStatusServicoConsulta().toString());
    }
}