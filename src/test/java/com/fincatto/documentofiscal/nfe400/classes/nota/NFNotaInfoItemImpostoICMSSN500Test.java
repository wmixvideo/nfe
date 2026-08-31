package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMSSN500Test {

    @Test
    public void naoDevePermitirValorICMSSTRetidoTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN500().setValorICMSSTRetido(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorBCICMSSTRetidoTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMSSN500().setValorBCICMSSTRetido(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobrezaRetidoST() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoICMSSN500().setPercentualFundoCombatePobrezaRetidoST(BigDecimal.ZERO));
    }

    @Test
    public void naoDevePermitirOrigemSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
            icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
            icms500.setPercentualICMSSTRetido(new BigDecimal("99.99"));
            icms500.setPercentualICMSSTRetido(new BigDecimal("99.99"));
            icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
            icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
            icms500.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
            icms500.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("99.99"));
            icms500.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
            icms500.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoOperacaoSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
            icms500.setOrigem(NFOrigem.NACIONAL);
            icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
            icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
            icms500.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
            icms500.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("99.99"));
            icms500.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
            icms500.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
        icms500.setOrigem(NFOrigem.NACIONAL);
        icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.CSOSN_300);
        icms500.setPercentualICMSSTRetido(new BigDecimal("99.99"));
        icms500.setValorICMSSubstituto(new BigDecimal("999999999999.99"));
        icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icms500.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("99.99"));
        icms500.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN500><orig>0</orig><CSOSN>300</CSOSN><vBCSTRet>999999999999.99</vBCSTRet><pST>99.99</pST><vICMSSubstituto>999999999999.99</vICMSSubstituto><vICMSSTRet>999999999999.99</vICMSSTRet><vBCFCPSTRet>999999999999.99</vBCFCPSTRet><pFCPSTRet>99.99</pFCPSTRet><vFCPSTRet>999999999999.99</vFCPSTRet></NFNotaInfoItemImpostoICMSSN500>";
        Assertions.assertEquals(xmlEsperado, icms500.toString());
    }
}