package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSSN101Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaAplicavelCalculoCreditoSNComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN101().setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorCreditoICMSSNComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN101().setValorCreditoICMSSN(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoSituacaoOperacaoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
        icms101.setOrigem(NFOrigem.NACIONAL);
        icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms101.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitiOrigemNulo() {
        final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
        icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
        icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms101.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaAplicavelCalculoCreditoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
        icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
        icms101.setOrigem(NFOrigem.NACIONAL);
        icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
        icms101.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorCreditoICMSSNNulo() {
        final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
        icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
        icms101.setOrigem(NFOrigem.NACIONAL);
        icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms101.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
        icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
        icms101.setOrigem(NFOrigem.NACIONAL);
        icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN101><orig>0</orig><CSOSN>103</CSOSN><pCredSN>99.99</pCredSN><vCredICMSSN>999999999999.99</vCredICMSSN></NFNotaInfoItemImpostoICMSSN101>";
        Assert.assertEquals(xmlEsperado, icms101.toString());
    }
}