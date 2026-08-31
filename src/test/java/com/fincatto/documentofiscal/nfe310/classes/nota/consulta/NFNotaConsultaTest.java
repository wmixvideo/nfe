package com.fincatto.documentofiscal.nfe310.classes.nota.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final String versao = "3.10";
        notaConsulta.setVersao(new BigDecimal(versao));
        Assertions.assertEquals(versao, notaConsulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        notaConsulta.setAmbiente(ambiente);
        Assertions.assertEquals(ambiente, notaConsulta.getAmbiente());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final String servico = "CONSULTAR";
        notaConsulta.setServico(servico);
        Assertions.assertEquals(servico, notaConsulta.getServico());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        final String chave = "40153917432140336471309459374276926791686520";
        notaConsulta.setChave(chave);
        Assertions.assertEquals(chave, notaConsulta.getChave());
    }

    @Test
    public void naoDevePermitirChaveComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaConsulta().setChave("4015391743214033647130945937427692679168652");
                Assertions.fail();
            } catch (final IllegalStateException e) {
                new NFNotaConsulta().setChave("401539174321403364713094593742769267916865212");
                Assertions.fail();
            }
        });
    }
}