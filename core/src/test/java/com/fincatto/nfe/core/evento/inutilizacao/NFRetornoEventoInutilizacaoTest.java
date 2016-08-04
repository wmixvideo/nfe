package com.fincatto.nfe.core.evento.inutilizacao;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFRetornoEventoInutilizacaoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFRetornoEventoInutilizacao eventoInutilizacao = new NFRetornoEventoInutilizacao();
        final String versao = "1.30";
        eventoInutilizacao.setVersao(new BigDecimal(versao));
        Assert.assertEquals(versao, eventoInutilizacao.getVersao());
    }

    @Test
    public void deveObterDadosComoFoiSetado() {
        final NFRetornoEventoInutilizacao eventoInutilizacao = new NFRetornoEventoInutilizacao();
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        eventoInutilizacao.setDados(dados);
        Assert.assertEquals(dados, eventoInutilizacao.getDados());
    }
}