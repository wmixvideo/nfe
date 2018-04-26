package com.fincatto.documentofiscal.nfe310.classes.evento.cancelamento;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.classes.nota.assinatura.NFSignature;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NFRetornoInfoCancelamentoTest {

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        retornoInfoCancelamento.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, retornoInfoCancelamento.getAmbiente());
    }

    @Test
    public void deveObterChaveComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final String chave = "chave";
        retornoInfoCancelamento.setChave(chave);
        Assert.assertEquals(chave, retornoInfoCancelamento.getChave());
    }

    @Test
    public void deveObterCodigoStatusComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final String codigoStatus = "codigo";
        retornoInfoCancelamento.setCodigoStatus(codigoStatus);
        Assert.assertEquals(codigoStatus, retornoInfoCancelamento.getCodigoStatus());
    }

    @Test
    public void deveObterDataHoraRecebimentoComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final LocalDateTime dataHoraRecebimento = LocalDateTime.from(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").parse("2010-10-10 10:10:10"));
        retornoInfoCancelamento.setDatahoraRecebimento(dataHoraRecebimento);
        Assert.assertEquals(dataHoraRecebimento, retornoInfoCancelamento.getDatahoraRecebimento());
    }

    @Test
    public void deveObterIdentificadorComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final String identificador = "identificador";
        retornoInfoCancelamento.setIdentificador(identificador);
        Assert.assertEquals(identificador, retornoInfoCancelamento.getIdentificador());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final String motivo = "motivo";
        retornoInfoCancelamento.setMotivo(motivo);
        Assert.assertEquals(motivo, retornoInfoCancelamento.getMotivo());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final String numeroProtocolo = "numeroProtocolo";
        retornoInfoCancelamento.setNumeroProtocolo(numeroProtocolo);
        Assert.assertEquals(numeroProtocolo, retornoInfoCancelamento.getNumeroProtocolo());
    }

    @Test
    public void deveObterUfComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.SC;
        retornoInfoCancelamento.setUf(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, retornoInfoCancelamento.getUf());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final String versaoAplicacao = "3.10";
        retornoInfoCancelamento.setVersaoAplicacao(versaoAplicacao);
        Assert.assertEquals(versaoAplicacao, retornoInfoCancelamento.getVersaoAplicacao());
    }

    @Test
    public void deveObterAssinaturaComoFoiSetado() {
        final NFRetornoInfoCancelamento retornoInfoCancelamento = new NFRetornoInfoCancelamento();
        final NFSignature assinatura = new NFSignature();
        retornoInfoCancelamento.setAssinatura(assinatura);
        Assert.assertEquals(assinatura, retornoInfoCancelamento.getAssinatura());
    }
}