package com.fincatto.documentofiscal.nfe400.classes.cadastro;

import org.junit.Assert;
import org.junit.Test;

public class NFConsultaCadastroTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirVersaoNulo() {
        final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
        consultaCadastro.setConsultaCadastro(new NFInfoConsultaCadastro());
        consultaCadastro.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirInfoConsultaCadastroNulo() {
        final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
        consultaCadastro.setVersao("3.10");
        consultaCadastro.toString();
    }

    @Test
    public void deveObterOMesmoValorSetadoParaConsultaCadastro() {
        final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
        final NFInfoConsultaCadastro infoConsultaCadastro = new NFInfoConsultaCadastro();
        consultaCadastro.setConsultaCadastro(infoConsultaCadastro);

        Assert.assertEquals(infoConsultaCadastro, consultaCadastro.getConsultaCadastro());
    }

    @Test
    public void deveObterOMesmoValorSetadoParaVersao() {
        final NFConsultaCadastro consultaCadastro = new NFConsultaCadastro();
        consultaCadastro.setVersao("3.10");
        Assert.assertEquals("3.10", consultaCadastro.getVersao());
    }
}