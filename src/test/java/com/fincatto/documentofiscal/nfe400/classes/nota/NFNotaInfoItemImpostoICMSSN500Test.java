package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;

public class NFNotaInfoItemImpostoICMSSN500Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTRetidoTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN500().setValorICMSSTRetido(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCICMSSTRetidoTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMSSN500().setValorBCICMSSTRetido(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobrezaRetidoST() {
        new NFNotaInfoItemImpostoICMSSN500().setPercentualFundoCombatePobrezaRetidoST(BigDecimal.ZERO);
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemSNNulo() {
        final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
        icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms500.setPercentualICMSSTRetido(new BigDecimal("99.99"));
        icms500.setPercentualICMSSTRetido(new BigDecimal("99.99"));
        icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icms500.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("99.99"));
        icms500.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icms500.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
        icms500.setOrigem(NFOrigem.NACIONAL);
        icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icms500.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("99.99"));
        icms500.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icms500.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
        icms500.setOrigem(NFOrigem.NACIONAL);
        icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms500.setPercentualICMSSTRetido(new BigDecimal("99.99"));
        icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icms500.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("99.99"));
        icms500.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN500><orig>0</orig><CSOSN>300</CSOSN><vBCSTRet>999999999999.99</vBCSTRet><pST>99.99</pST><vICMSSTRet>999999999999.99</vICMSSTRet><vBCFCPSTRet>999999999999.99</vBCFCPSTRet><pFCPSTRet>99.99</pFCPSTRet><vFCPSTRet>999999999999.99</vFCPSTRet></NFNotaInfoItemImpostoICMSSN500>";
        Assert.assertEquals(xmlEsperado, icms500.toString());
    }
}