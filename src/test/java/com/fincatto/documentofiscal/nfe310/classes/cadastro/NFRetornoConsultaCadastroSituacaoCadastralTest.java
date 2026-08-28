package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NFRetornoConsultaCadastroSituacaoCadastralTest {

    @Test
    public void deveObterCnaePrincipalContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setCnaePrincipalContribuinte("123456879");
        Assertions.assertEquals("123456879", retorno.getCnaePrincipalContribuinte());
    }

    @Test
    public void deveObterCnpjComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setCnpj("28087726000122");
        Assertions.assertEquals("28087726000122", retorno.getCnpj());
    }

    @Test
    public void deveObterCpfComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setCpf("24868707841");
        Assertions.assertEquals("24868707841", retorno.getCpf());
    }

    @Test
    public void deveObterDataInicioAtividadeComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final LocalDate dataInicioAtividade = LocalDate.from(DateTimeFormatter.ofPattern("dd/MM/yyyy").parse("20/10/2010"));
        retorno.setDataInicioAtividade(dataInicioAtividade);
        Assertions.assertEquals(dataInicioAtividade, retorno.getDataInicioAtividade());
    }

    @Test
    public void deveObterDataOcorrenciaBaixaComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final LocalDate dataOcorrenciaBaixa = LocalDate.from(DateTimeFormatter.ofPattern("dd/MM/yyyy").parse("20/10/2010"));
        retorno.setDataOcorrenciaBaixa(dataOcorrenciaBaixa);
        Assertions.assertEquals(dataOcorrenciaBaixa, retorno.getDataOcorrenciaBaixa());
    }

    @Test
    public void deveObterDataUltimaModificacaoComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final LocalDate dataUltimaModificacaoSituacaoCadastral = LocalDate.from(DateTimeFormatter.ofPattern("dd/MM/yyyy").parse("20/10/2010"));
        retorno.setDataUltimaModificacaoSituacaoCadastral(dataUltimaModificacaoSituacaoCadastral);
        Assertions.assertEquals(dataUltimaModificacaoSituacaoCadastral, retorno.getDataUltimaModificacaoSituacaoCadastral());
    }

    @Test
    public void deveObterEnderecoComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        final NFRetornoConsultaCadastroEndereco endereco = new NFRetornoConsultaCadastroEndereco();
        retorno.setEndereco(endereco);
        Assertions.assertEquals(endereco, retorno.getEndereco());
    }

    @Test
    public void deveObterIndicadorContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setIndicadorContribuinteNFe(NFIndicadorContribuinteNFe.CREDENCIADO);
        Assertions.assertEquals(NFIndicadorContribuinteNFe.CREDENCIADO, retorno.getIndicadorContribuinteNFe());
    }

    @Test
    public void deveObterIndicaodrContribuinteCTeComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setIndicaodrContribuinteCTe(NFIndicadorContribuinteCTe.CREDENCIADO);
        Assertions.assertEquals(NFIndicadorContribuinteCTe.CREDENCIADO, retorno.getIndicaodrContribuinteCTe());
    }

    @Test
    public void deveObterIEComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setInscricaoEstadual("132456");
        Assertions.assertEquals("132456", retorno.getInscricaoEstadual());
    }

    @Test
    public void deveObterIEAtualComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setInscricaoEstadualAtual("654123");
        Assertions.assertEquals("654123", retorno.getInscricaoEstadualAtual());
    }

    @Test
    public void deveObterIEUnicaComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setInscricaoEstadualUnica("654321");
        Assertions.assertEquals("654321", retorno.getInscricaoEstadualUnica());
    }

    @Test
    public void deveObterNomeFantasiaComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setNomeFantasia("Video locadora do Pedro");
        Assertions.assertEquals("Video locadora do Pedro", retorno.getNomeFantasia());
    }

    @Test
    public void deveObterRazaoSocialComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setRazaoSocial("Pedro da Silva");
        Assertions.assertEquals("Pedro da Silva", retorno.getRazaoSocial());
    }

    @Test
    public void deveObterRegimeApuracaoICMSContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setRegimeApuracaoICMSContribuinte("f4kfk4fj923");
        Assertions.assertEquals("f4kfk4fj923", retorno.getRegimeApuracaoICMSContribuinte());
    }

    @Test
    public void deveObterSituacaoContribuinteComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setSituacaoContribuinte(NFSituacaoContribuinte.HABILITADO);
        Assertions.assertEquals(NFSituacaoContribuinte.HABILITADO, retorno.getSituacaoContribuinte());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFRetornoConsultaCadastroSituacaoCadastral retorno = new NFRetornoConsultaCadastroSituacaoCadastral();
        retorno.setUf(DFUnidadeFederativa.SC);
        Assertions.assertEquals(DFUnidadeFederativa.SC, retorno.getUf());
    }
}