package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFRetornoConsultaCadastroTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFRetornoConsultaCadastro retornoConsultaCadastro = new NFRetornoConsultaCadastro();
        retornoConsultaCadastro.setVersao("3.10");
        Assertions.assertEquals("3.10", retornoConsultaCadastro.getVersao());
    }

    @Test
    public void deveObterDadosComoFoiSetado() {
        final NFRetornoConsultaCadastro retornoConsultaCadastro = new NFRetornoConsultaCadastro();
        final NFRetornoConsultaCadastroDados dados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastro.setDados(dados);
        Assertions.assertEquals(dados, retornoConsultaCadastro.getDados());
    }
}