package com.fincatto.documentofiscal.nfe400.classes.evento.inutilizacao;

import com.fincatto.documentofiscal.nfe400.classes.nota.assinatura.NFSignature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFRetornoEventoInutilizacaoTest {

    @Test
    public void deveObterVersaoComoFoiSetado() {
        final NFRetornoEventoInutilizacao eventoInutilizacao = new NFRetornoEventoInutilizacao();
        final String versao = "1.30";
        eventoInutilizacao.setVersao(new BigDecimal(versao));
        Assertions.assertEquals(versao, eventoInutilizacao.getVersao());
    }

    @Test
    public void deveObterDadosComoFoiSetado() {
        final NFRetornoEventoInutilizacao eventoInutilizacao = new NFRetornoEventoInutilizacao();
        final NFRetornoEventoInutilizacaoDados dados = new NFRetornoEventoInutilizacaoDados();
        eventoInutilizacao.setDados(dados);
        Assertions.assertEquals(dados, eventoInutilizacao.getDados());
    }

    @Test
    public void deveObterAssinaturaComoFoiSetado() {
        final NFEnviaEventoInutilizacao eventoInutilizacao = new NFEnviaEventoInutilizacao();
        final NFSignature assinatura = new NFSignature();
        final String signatureValue = "signature";
        assinatura.setSignatureValue(signatureValue);
        eventoInutilizacao.setAssinatura(assinatura);
        Assertions.assertEquals(assinatura, eventoInutilizacao.getAssinatura());
    }
}
