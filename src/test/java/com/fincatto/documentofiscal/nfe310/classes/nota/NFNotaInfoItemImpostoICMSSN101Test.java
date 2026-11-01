package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN101Test {

    @Test
    public void naoDevePermitirPercentualAliquotaAplicavelCalculoCreditoSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN101().setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorCreditoICMSSNComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN101().setValorCreditoICMSSN(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirCodigoSituacaoOperacaoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
            icms101.setOrigem(NFOrigem.NACIONAL);
            icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
            icms101.toString();
        });
    }

    @Test
    public void naoDevePermitiOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
            icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
            icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
            icms101.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaAplicavelCalculoCreditoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
            icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
            icms101.setOrigem(NFOrigem.NACIONAL);
            icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));
            icms101.toString();
        });
    }

    @Test
    public void naoDevePermitirValorCreditoICMSSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
            icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
            icms101.setOrigem(NFOrigem.NACIONAL);
            icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
            icms101.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN101 icms101 = new NFNotaInfoItemImpostoICMSSN101();
        icms101.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.ISENCAO_ICMS_FAIXA_RECEITA_BRUTA);
        icms101.setOrigem(NFOrigem.NACIONAL);
        icms101.setPercentualAliquotaAplicavelCalculoCreditoSN(new BigDecimal("99.99"));
        icms101.setValorCreditoICMSSN(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN101><orig>0</orig><CSOSN>103</CSOSN><pCredSN>99.99</pCredSN><vCredICMSSN>999999999999.99</vCredICMSSN></NFNotaInfoItemImpostoICMSSN101>";
        Assertions.assertEquals(xmlEsperado, icms101.toString());
    }
}