package com.fincatto.documentofiscal.nfe310.classes.cadastro;

import com.fincatto.documentofiscal.DFConfig;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NFRetornoConsultaCadastroDadosTest {

    @Test
    public void deveObterCnpjComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setCnpj("28087726000122");
        Assertions.assertEquals("28087726000122", retornoConsultaCadastroDados.getCnpj());
    }

    @Test
    public void deveObterCpfComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setCpf("24868707841");
        Assertions.assertEquals("24868707841", retornoConsultaCadastroDados.getCpf());
    }

    @Test
    public void deveObterDataHoraProcessamentoComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        //final LocalDateTime dataHoraProcessamento = LocalDateTime.from(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").parse("20/10/2010 10:10:10"));
        final ZonedDateTime dataHoraProcessamento = ZonedDateTime.of(LocalDateTime.of(2010, 10, 20, 10, 10, 10), DFConfig.TIMEZONE_SP.toZoneId());
        retornoConsultaCadastroDados.setDataHoraProcessamento(dataHoraProcessamento);
        Assertions.assertEquals(dataHoraProcessamento, retornoConsultaCadastroDados.getDataHoraProcessamento());
    }

    @Test
    public void deveObterIEComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setInscricaoEstadual("345678");
        Assertions.assertEquals("345678", retornoConsultaCadastroDados.getInscricaoEstadual());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setMotivo("G1692853745128213111569303684020089712558655040015175940150684914083778523271947");
        Assertions.assertEquals("G1692853745128213111569303684020089712558655040015175940150684914083778523271947", retornoConsultaCadastroDados.getMotivo());
    }

    @Test
    public void deveObterSituacaoCadastralComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        final ArrayList<NFRetornoConsultaCadastroSituacaoCadastral> listaSituacaoCadastral = new ArrayList<>();
        retornoConsultaCadastroDados.setSituacaoCadastral(listaSituacaoCadastral);
        Assertions.assertEquals(listaSituacaoCadastral, retornoConsultaCadastroDados.getSituacaoCadastral());
    }

    @Test
    public void deveObterStatusRespostaComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setStatusResposta("fhowdk");
        Assertions.assertEquals("fhowdk", retornoConsultaCadastroDados.getStatusResposta());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setUf(DFUnidadeFederativa.SC);
        Assertions.assertEquals(DFUnidadeFederativa.SC, retornoConsultaCadastroDados.getUf());
    }

    @Test
    public void deveObterUFAutorizadoraComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        retornoConsultaCadastroDados.setUfAutorizadora(DFUnidadeFederativa.SP);
        Assertions.assertEquals(DFUnidadeFederativa.SP, retornoConsultaCadastroDados.getUfAutorizadora());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final NFRetornoConsultaCadastroDados retornoConsultaCadastroDados = new NFRetornoConsultaCadastroDados();
        final String versaoAplicacao = "3.10";
        retornoConsultaCadastroDados.setVersaoAplicacao(versaoAplicacao);
        Assertions.assertEquals(versaoAplicacao, retornoConsultaCadastroDados.getVersaoAplicacao());
    }
}