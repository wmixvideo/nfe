package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS02Test {

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS02().setPercentualAliquota(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS02().setQuantidadeBaseCalculo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS02().setValorTributo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
            icms02.setPercentualAliquota(new BigDecimal("99.99"));
            icms02.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_02);
            icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms02.setValorTributo(new BigDecimal("999999999999.99"));
            icms02.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
            icms02.setOrigem(NFOrigem.NACIONAL);
            icms02.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_02);
            icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms02.setValorTributo(new BigDecimal("999999999999.99"));
            icms02.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
            icms02.setOrigem(NFOrigem.NACIONAL);
            icms02.setPercentualAliquota(new BigDecimal("99.99"));
            icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms02.setValorTributo(new BigDecimal("999999999999.99"));
            icms02.toString();
        });
    }

    @Test
    public void naoDevePermitirValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
            icms02.setOrigem(NFOrigem.NACIONAL);
            icms02.setPercentualAliquota(new BigDecimal("99.99"));
            icms02.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_02);
            icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms02.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS02><orig>0</orig><CST>02</CST><qBCMono>999999999999.99</qBCMono><adRemICMS>99.99</adRemICMS><vICMSMono>999999999999.99</vICMSMono></NFNotaInfoItemImpostoICMS02>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS02().toString());
    }
}