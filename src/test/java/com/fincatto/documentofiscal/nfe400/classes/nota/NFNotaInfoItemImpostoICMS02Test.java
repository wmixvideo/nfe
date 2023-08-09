package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoItemModalidadeBCICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS02Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS02().setPercentualAliquota(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS02().setQuantidadeBaseCalculo(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS02().setValorTributo(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
        icms02.setPercentualAliquota(new BigDecimal("99.99"));
        icms02.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_SOBRE_IMPOSTO);
        icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms02.setValorTributo(new BigDecimal("999999999999.99"));
        icms02.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
        icms02.setOrigem(NFOrigem.NACIONAL);
        icms02.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_SOBRE_IMPOSTO);
        icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms02.setValorTributo(new BigDecimal("999999999999.99"));
        icms02.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
        icms02.setOrigem(NFOrigem.NACIONAL);
        icms02.setPercentualAliquota(new BigDecimal("99.99"));
        icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms02.setValorTributo(new BigDecimal("999999999999.99"));
        icms02.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS02 icms02 = new NFNotaInfoItemImpostoICMS02();
        icms02.setOrigem(NFOrigem.NACIONAL);
        icms02.setPercentualAliquota(new BigDecimal("99.99"));
        icms02.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_SOBRE_IMPOSTO);
        icms02.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms02.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS02><orig>0</orig><CST>02</CST><qBCMono>999999999999.99</qBCMono><adRemICMS>99.99</adRemICMS><vICMSMono>999999999999.99</vICMSMono></NFNotaInfoItemImpostoICMS02>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS02().toString());
    }
}