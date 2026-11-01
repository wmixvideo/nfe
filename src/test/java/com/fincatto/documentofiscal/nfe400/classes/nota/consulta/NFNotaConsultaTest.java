package com.fincatto.documentofiscal.nfe400.classes.nota.consulta;

import com.fincatto.documentofiscal.DFAmbiente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaConsultaTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setVersao(new BigDecimal("4.00"));
        Assertions.assertEquals("4.00", notaConsulta.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setAmbiente(DFAmbiente.HOMOLOGACAO);
        Assertions.assertEquals(DFAmbiente.HOMOLOGACAO, notaConsulta.getAmbiente());
    }

    @Test
    public void deveObterServicoComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setServico("CONSULTAR");
        Assertions.assertEquals("CONSULTAR", notaConsulta.getServico());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFNotaConsulta notaConsulta = new NFNotaConsulta();
        notaConsulta.setChave("40153917432140336471309459374276926791686520");
        Assertions.assertEquals("40153917432140336471309459374276926791686520", notaConsulta.getChave());
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