package com.fincatto.documentofiscal.nfe400.classes.cadastro;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NFRetornoConsultaCadastroDadosTest {

    @Test
    public void deveObterCnpjComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setCnpj("28087726000122");
        Assert.assertEquals("28087726000122", retornoConsultaCadastroDados.getCnpj());
    }

    @Test
    public void deveObterCpfComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setCpf("24868707841");
        Assert.assertEquals("24868707841", retornoConsultaCadastroDados.getCpf());
    }

    @Test
    public void deveObterDataHoraProcessamentoComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        final LocalDateTime dataHoraProcessamento = LocalDateTime.from(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").parse("20/10/2010 10:10:10"));
        retornoConsultaCadastroDados.setDataHoraProcessamento(dataHoraProcessamento);
        Assert.assertEquals(dataHoraProcessamento, retornoConsultaCadastroDados.getDataHoraProcessamento());
    }

    @Test
    public void deveObterIEComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setInscricaoEstadual("345678");
        Assert.assertEquals("345678", retornoConsultaCadastroDados.getInscricaoEstadual());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setMotivo("G1692853745128213111569303684020089712558655040015175940150684914083778523271947");
        Assert.assertEquals("G1692853745128213111569303684020089712558655040015175940150684914083778523271947", retornoConsultaCadastroDados.getMotivo());
    }

    @Test
    public void deveObterSituacaoCadastralComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        final ArrayList<NFRetornoConsultaCadastroSituacaoCadastral> listaSituacaoCadastral = new ArrayList<>();
        retornoConsultaCadastroDados.setSituacaoCadastral(listaSituacaoCadastral);
        Assert.assertEquals(listaSituacaoCadastral, retornoConsultaCadastroDados.getSituacaoCadastral());
    }

    @Test
    public void deveObterStatusRespostaComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setStatusResposta("fhowdk");
        Assert.assertEquals("fhowdk", retornoConsultaCadastroDados.getStatusResposta());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setUf(DFUnidadeFederativa.SC);
        Assert.assertEquals(DFUnidadeFederativa.SC, retornoConsultaCadastroDados.getUf());
    }

    @Test
    public void deveObterUFAutorizadoraComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setUfAutorizadora(DFUnidadeFederativa.SP);
        Assert.assertEquals(DFUnidadeFederativa.SP, retornoConsultaCadastroDados.getUfAutorizadora());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        final String versaoAplicacao = "3.10";
        retornoConsultaCadastroDados.setVersaoAplicacao(versaoAplicacao);
        Assert.assertEquals(versaoAplicacao, retornoConsultaCadastroDados.getVersaoAplicacao());
    }
}