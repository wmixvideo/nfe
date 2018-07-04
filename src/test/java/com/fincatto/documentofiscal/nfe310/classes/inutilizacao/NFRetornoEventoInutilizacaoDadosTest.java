package com.fincatto.documentofiscal.nfe310.classes.inutilizacao;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.classes.evento.inutilizacao.NFRetornoEventoInutilizacaoDados;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NFRetornoEventoInutilizacaoDadosTest {

    @Test
    public void deveObterAmbienteComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final DFAmbiente ambiente = DFAmbiente.HOMOLOGACAO;
        dados.setAmbiente(ambiente);
        Assert.assertEquals(ambiente, dados.getAmbiente());
    }

    @Test
    public void deveObterAnoComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final int ano = 2015;
        dados.setAno(ano);
        Assert.assertEquals(ano, dados.getAno(), 0);
    }

    @Test
    public void deveObterCnpjComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String cnpj = "44806226000150";
        dados.setCnpj(cnpj);
        Assert.assertEquals(cnpj, dados.getCnpj());
    }

    @Test
    public void deveObterDataHoraRecebimentoComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final LocalDateTime datahoraRecebimento = LocalDateTime.parse("2010-10-10 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        dados.setDatahoraRecebimento(datahoraRecebimento);
        Assert.assertEquals(datahoraRecebimento, dados.getDatahoraRecebimento());
    }

    @Test
    public void deveObterIdentificadorComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String identificador = "NFe132465789123456789";
        dados.setIdentificador(identificador);
        Assert.assertEquals(identificador, dados.getIdentificador());
    }

    @Test
    public void deveObterModeloNotaFiscalComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String modeloNotaFiscal = "55";
        dados.setModeloNotaFiscal(modeloNotaFiscal);
        Assert.assertEquals(modeloNotaFiscal, dados.getModeloNotaFiscal());
    }

    @Test
    public void deveObterMotivoComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String motivo = "motivo de teste";
        dados.setMotivo(motivo);
        Assert.assertEquals(motivo, dados.getMotivo());
    }

    @Test
    public void deveObterNumeroNFFinalComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String numeroNFFinal = "654231";
        dados.setNumeroNFFinal(numeroNFFinal);

        Assert.assertEquals(numeroNFFinal, dados.getNumeroNFFinal());
    }

    @Test
    public void deveObterNumeroNFInicialComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String numeroNFInicial = "132456";
        dados.setNumeroNFInicial(numeroNFInicial);
        Assert.assertEquals(numeroNFInicial, dados.getNumeroNFInicial());
    }

    @Test
    public void deveObterNumeroProtocoloComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String numeroProtocolo = "123465789";
        dados.setNumeroProtocolo(numeroProtocolo);
        Assert.assertEquals(numeroProtocolo, dados.getNumeroProtocolo());
    }

    @Test
    public void deveObterSerieComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String serie = "088";
        dados.setSerie(serie);
        Assert.assertEquals(serie, dados.getSerie());
    }

    @Test
    public void deveObterStatusComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String status = "Em andamento";
        dados.setStatus(status);
        Assert.assertEquals(status, dados.getStatus());
    }

    @Test
    public void deveObterUnidadeFederativaComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final DFUnidadeFederativa unidadeFederativa = DFUnidadeFederativa.SC;
        dados.setUf(unidadeFederativa);
        Assert.assertEquals(unidadeFederativa, dados.getUf());
    }

    @Test
    public void deveObterVersaoAplicacaoComoFoiSetado() {
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        final String versaoAplicacao = "v10.0";
        dados.setVersaoAplicacao(versaoAplicacao);
        Assert.assertEquals(versaoAplicacao, dados.getVersaoAplicacao());
    }
}