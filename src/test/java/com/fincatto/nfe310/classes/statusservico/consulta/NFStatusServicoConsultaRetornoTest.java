package com.fincatto.nfe310.classes.statusservico.consulta;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe310.classes.NFAmbiente;
import com.fincatto.nfe310.classes.NFUnidadeFederativa;

public class NFStatusServicoConsultaRetornoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final String versao = "3.10";
        consultaRetorno.setVersao(versao);
        Assert.assertEquals(versao, consultaRetorno.getVersao());
    }

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final NFAmbiente ambiente = NFAmbiente.HOMOLOGACAO;
        consultaRetorno.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, consultaRetorno.getAmbiente());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final String versaoAplicacao = "1.01";
        consultaRetorno.setVersaoAplicacao(versaoAplicacao);
        Assert.assertEquals(versaoAplicacao, consultaRetorno.getVersaoAplicacao());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final String status = "107";
        consultaRetorno.setStatus(status);
        Assert.assertEquals(status, consultaRetorno.getStatus());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final String motivo = "Servico em operacao";
        consultaRetorno.setMotivo(motivo);
        Assert.assertEquals(motivo, consultaRetorno.getMotivo());
    }

    @Test
    public void deveObterUFComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final NFUnidadeFederativa unidadeFederativa = NFUnidadeFederativa.AC;
        consultaRetorno.setUf(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, consultaRetorno.getUf());
    }

    @Test
    public void deveObterDataRecebimentoComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final LocalDateTime dataRecebimento = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss").parseLocalDateTime("2013/12/10 15:10:59");
        consultaRetorno.setDataRecebimento(dataRecebimento);
        Assert.assertEquals(dataRecebimento, consultaRetorno.getDataRecebimento());
    }

    @Test
    public void deveObterDataRetornoComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final DateTime dataRetorno = DateTime.parse("2015/11/13", DateTimeFormat.forPattern("yyyy/MM/dd"));
        consultaRetorno.setDataRetorno(dataRetorno);
        Assert.assertEquals(dataRetorno, consultaRetorno.getDataRetorno());
    }

    @Test
    public void deveObterObservacaoComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final String observacao = "Sem informacao";
        consultaRetorno.setObservacao(observacao);
        Assert.assertEquals(observacao, consultaRetorno.getObservacao());
    }

    @Test
    public void deveObterTempoMedioComoFoiSetado() {
        final NFStatusServicoConsultaRetorno consultaRetorno = new NFStatusServicoConsultaRetorno();
        final String tempoMedio = "10";
        consultaRetorno.setTempoMedio(tempoMedio);
        Assert.assertEquals(tempoMedio, consultaRetorno.getTempoMedio());
    }
}