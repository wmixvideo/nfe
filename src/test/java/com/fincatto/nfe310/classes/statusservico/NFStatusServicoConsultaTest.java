package com.fincatto.nfe310.classes.statusservico;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;
import com.fincatto.nfe310.classes.statusservico.consulta.NFStatusServicoConsulta;

public class NFStatusServicoConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final String versao = "3.10";
        servicoConsulta.setVersao(versao);
        Assert.assertEquals(versao, servicoConsulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final NFAmbiente ambiente = NFAmbiente.HOMOLOGACAO;
        servicoConsulta.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, servicoConsulta.getAmbiente());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final NFUnidadeFederativa unidadeFederativa = NFUnidadeFederativa.SP;
        servicoConsulta.setUf(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, servicoConsulta.getUf());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final NFStatusServicoConsulta servicoConsulta = new NFStatusServicoConsulta();
        final String servico = "STATUS";
        servicoConsulta.setServico(servico);
        Assert.assertEquals(servico, servicoConsulta.getServico());
    }
}