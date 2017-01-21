package com.fincatto.nfe310.classes.cadastro;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class NFRetornoConsultaCadastroSituacaoCadastralTest {

    @Test
    public void deveObterCnaePrincipalContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setCnaePrincipalContribuinte("123456879");
        Assert.assertEquals("123456879", retorno.getCnaePrincipalContribuinte());
    }

    @Test
    public void deveObterCnpjComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setCnpj("28087726000122");
        Assert.assertEquals("28087726000122", retorno.getCnpj());
    }

    @Test
    public void deveObterCpfComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setCpf("24868707841");
        Assert.assertEquals("24868707841", retorno.getCpf());
    }

    @Test
    public void deveObterDataInicioAtividadeComoFoiSetado() throws ParseException {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final LocalDate dataInicioAtividade = LocalDate.fromDateFields(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2010"));
        retorno.setDataInicioAtividade(dataInicioAtividade);
        Assert.assertEquals(dataInicioAtividade, retorno.getDataInicioAtividade());
    }

    @Test
    public void deveObterDataOcorrenciaBaixaComoFoiSetado() throws ParseException {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final LocalDate dataOcorrenciaBaixa = LocalDate.fromDateFields(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2010"));
        retorno.setDataOcorrenciaBaixa(dataOcorrenciaBaixa);
        Assert.assertEquals(dataOcorrenciaBaixa, retorno.getDataOcorrenciaBaixa());
    }

    @Test
    public void deveObterDataUltimaModificacaoComoFoiSetado() throws ParseException {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final LocalDate dataUltimaModificacaoSituacaoCadastral = LocalDate.fromDateFields(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2010"));
        retorno.setDataUltimaModificacaoSituacaoCadastral(dataUltimaModificacaoSituacaoCadastral);
        Assert.assertEquals(dataUltimaModificacaoSituacaoCadastral, retorno.getDataUltimaModificacaoSituacaoCadastral());
    }

    @Test
    public void deveObterEnderecoComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final NFRetornoConsultaCadastroEndereco endereco = new NFRetornoConsultaCadastroEndereco();
        retorno.setEndereco(endereco);
        Assert.assertEquals(endereco, retorno.getEndereco());
    }

    @Test
    public void deveObterIndicadorContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setIndicadorContribuinteNFe(NFIndicadorContribuinteNFe.CREDENCIADO);
        Assert.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO, retorno.getIndicadorContribuinteNFe());
    }

    @Test
    public void deveObterIndicaodrContribuinteCTeComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setIndicaodrContribuinteCTe(NFIndicadorContribuinteCTe.CREDENCIADO);
        Assert.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO, retorno.getIndicaodrContribuinteCTe());
    }

    @Test
    public void deveObterIEComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setInscricaoEstadual("132456");
        Assert.assertEquals("132456", retorno.getInscricaoEstadual());
    }

    @Test
    public void deveObterIEAtualComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setInscricaoEstadualAtual("654123");
        Assert.assertEquals("654123", retorno.getInscricaoEstadualAtual());
    }

    @Test
    public void deveObterIEUnicaComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setInscricaoEstadualUnica("654321");
        Assert.assertEquals("654321", retorno.getInscricaoEstadualUnica());
    }

    @Test
    public void deveObterNomeFantasiaComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setNomeFantasia("Video locadora do Pedro");
        Assert.assertEquals("Video locadora do Pedro", retorno.getNomeFantasia());
    }

    @Test
    public void deveObterRazaoSocialComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setRazaoSocial("Pedro da Silva");
        Assert.assertEquals("Pedro da Silva", retorno.getRazaoSocial());
    }

    @Test
    public void deveObterRegimeApuracaoICMSContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setRegimeApuracaoICMSContribuinte("f4kfk4fj923");
        Assert.assertEquals("f4kfk4fj923", retorno.getRegimeApuracaoICMSContribuinte());
    }

    @Test
    public void deveObterSituacaoContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setSituacaoContribuinte(NFSituacaoContribuinte.HABILITADO);
        Assert.assertEquals(NFSituacaoContribuinte.HABILITADO, retorno.getSituacaoContribuinte());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setUf(NFUnidadeFederativa.SC);
        Assert.assertEquals(NFUnidadeFederativa.SC, retorno.getUf());
    }
}