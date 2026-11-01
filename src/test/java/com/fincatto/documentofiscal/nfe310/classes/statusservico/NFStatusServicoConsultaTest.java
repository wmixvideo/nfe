package com.fincatto.documentofiscal.nfe310.classes.statusservico;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.classes.statusservico.consulta.NFStatusServicoConsulta;
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
}