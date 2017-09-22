package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.classes.cadastro.NFRetornoConsultaCadastroEndereco;

public class NFRetornoConsultaCadastroEnderecoTest {

    @Test
    public void deveObterBairroComoFoiSetado() {
        final NFRetornoConsultaCadastroEndereco retornoConsultaCadastroEndereco = new NFRetornoConsultaCadastroEndereco();
        retornoConsultaCadastroEndereco.setBairro("Jardim America");
        Assert.assertEquals("Jardim America", retornoConsultaCadastroEndereco.getBairro());
    }

    @Test
    public void deveObterCepComoFoiSetado() {
        final NFRetornoConsultaCadastroEndereco retornoConsultaCadastroEndereco = new NFRetornoConsultaCadastroEndereco();
        retornoConsultaCadastroEndereco.setCep("88132-020");
        Assert.assertEquals("88132-020", retornoConsultaCadastroEndereco.getCep());
    }

    @Test
    public void deveObterCodigoMunicipioFoiSetado() {
        final NFRetornoConsultaCadastroEndereco retornoConsultaCadastroEndereco = new NFRetornoConsultaCadastroEndereco();
        retornoConsultaCadastroEndereco.setCodigoMunicipio("3456");
        Assert.assertEquals("3456", retornoConsultaCadastroEndereco.getCodigoMunicipio());
    }

    @Test
    public void deveObterComplementoComoFoiSetado() {
        final NFRetornoConsultaCadastroEndereco retornoConsultaCadastroEndereco = new NFRetornoConsultaCadastroEndereco();
        retornoConsultaCadastroEndereco.setComplemento("Em cima da mercearia nego drama");
        Assert.assertEquals("Em cima da mercearia nego drama", retornoConsultaCadastroEndereco.getComplemento());
    }

    @Test
    public void deveObterConsultaCadastroComoFoiSetado() {
        final NFRetornoConsultaCadastroEndereco retornoConsultaCadastroEndereco = new NFRetornoConsultaCadastroEndereco();
        retornoConsultaCadastroEndereco.setDescricaoMunicipio("Palho\u00e7a");
        Assert.assertEquals("Palho\u00e7a", retornoConsultaCadastroEndereco.getDescricaoMunicipio());
    }

    @Test
    public void deveObterLogradouroComoFoiSetado() {
        final NFRetornoConsultaCadastroEndereco retornoConsultaCadastroEndereco = new NFRetornoConsultaCadastroEndereco();
        retornoConsultaCadastroEndereco.setLogradouro("Av Jos\u00e9 Bonif\u00e1cio");
        Assert.assertEquals("Av Jos\u00e9 Bonif\u00e1cio", retornoConsultaCadastroEndereco.getLogradouro());
    }

    @Test
    public void deveObterNumeroComoFoiSetado() {
        final NFRetornoConsultaCadastroEndereco retornoConsultaCadastroEndereco = new NFRetornoConsultaCadastroEndereco();
        retornoConsultaCadastroEndereco.setNumero("1435");
        Assert.assertEquals("1435", retornoConsultaCadastroEndereco.getNumero());
    }
}