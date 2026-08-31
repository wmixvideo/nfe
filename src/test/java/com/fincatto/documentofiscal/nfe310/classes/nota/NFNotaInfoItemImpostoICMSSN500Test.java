package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaSituacaoOperacionalSimplesNacional;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
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
    public void naoDevePermitirOrigemSNNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
            icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
            icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
            icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
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
            icms500.toString();
        });
    }

    @Test
    public void devePermitirValorBCICMSSTRetidoNulo() {
        final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
        icms500.setOrigem(NFOrigem.NACIONAL);
        icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.toString();
    }

    @Test
    public void devePermitirValorICMSSTRetidoNulo() {
        final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
        icms500.setOrigem(NFOrigem.NACIONAL);
        icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMSSN500 icms500 = new NFNotaInfoItemImpostoICMSSN500();
        icms500.setOrigem(NFOrigem.NACIONAL);
        icms500.setSituacaoOperacaoSN(NFNotaSituacaoOperacionalSimplesNacional.IMUNE);
        icms500.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms500.setValorICMSSTRetido(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMSSN500><orig>0</orig><CSOSN>300</CSOSN><vBCSTRet>999999999999.99</vBCSTRet><vICMSSTRet>999999999999.99</vICMSSTRet></NFNotaInfoItemImpostoICMSSN500>";
        Assertions.assertEquals(xmlEsperado, icms500.toString());
    }
}