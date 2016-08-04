package com.fincatto.nfe.core.nota.consulta;

import com.fincatto.nfe.core.NFAmbiente;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final String versao = "3.10";
        notaConsulta.setVersao(new BigDecimal(versao));
        Assert.assertEquals(versao, notaConsulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final NFAmbiente ambiente = NFAmbiente.HOMOLOGACAO;
        notaConsulta.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, notaConsulta.getAmbiente());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final String servico = "CONSULTAR";
        notaConsulta.setServico(servico);
        Assert.assertEquals(servico, notaConsulta.getServico());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final String chave = "40153917432140336471309459374276926791686520";
        notaConsulta.setChave(chave);
        Assert.assertEquals(chave, notaConsulta.getChave());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirChaveComTamanhoInvalido() {
        try {
            new NFNotaConsulta().setChave("4015391743214033647130945937427692679168652");
            Assert.fail();
        } catch (final IllegalStateException e) {
            new NFNotaConsulta().setChave("401539174321403364713094593742769267916865212");
            Assert.fail();
        }
    }
}