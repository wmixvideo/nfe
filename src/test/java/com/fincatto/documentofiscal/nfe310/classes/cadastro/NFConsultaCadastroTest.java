package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFConsultaCadastroTest {

    @Test
    public void naoDevePermitirVersaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
            consultaCadastro.setConsultaCadastro(new NFInfoConsultaCadastro());
            consultaCadastro.toString();
        });
    }

    @Test
    public void naoDevePermitirInfoConsultaCadastroNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
            consultaCadastro.setVersao("3.10");
            consultaCadastro.toString();
        });
    }

    @Test
    public void deveObterOMesmoValorSetadoParaConsultaCadastro() {
        final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        consultaCadastro.setConsultaCadastro(infoConsultaCadastro);

        Assertions.assertEquals(infoConsultaCadastro, consultaCadastro.getConsultaCadastro());
    }

    @Test
    public void deveObterOMesmoValorSetadoParaVersao() {
        final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
        consultaCadastro.setVersao("3.10");
        Assertions.assertEquals("3.10", consultaCadastro.getVersao());
    }
}