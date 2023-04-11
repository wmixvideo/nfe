package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS15Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS15().setPercentualAliquota(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS15().setQuantidadeBaseCalculo(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS15().setValorTributo(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaRetencaoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS15().setPercentualAliquotaRetencao(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoRetencaoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS15().setQuantidadeBaseCalculoTributadaSujeitaRetencao(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoRetencaoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS15().setValorTributoRetencao(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS15 icms15 = new NFNotaInfoItemImpostoICMS15();
        icms15.setPercentualAliquota(new BigDecimal("99.99"));
        icms15.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES);
        icms15.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms15.setValorTributo(new BigDecimal("999999999999.99"));
        icms15.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS15 icms15 = new NFNotaInfoItemImpostoICMS15();
        icms15.setOrigem(NFOrigem.NACIONAL);
        icms15.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES);
        icms15.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms15.setValorTributo(new BigDecimal("999999999999.99"));
        icms15.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        final NFNotaInfoItemImpostoICMS15 icms15 = new NFNotaInfoItemImpostoICMS15();
        icms15.setOrigem(NFOrigem.NACIONAL);
        icms15.setPercentualAliquota(new BigDecimal("99.99"));
        icms15.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms15.setValorTributo(new BigDecimal("999999999999.99"));
        icms15.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCalculoNulo() {
        final NFNotaInfoItemImpostoICMS15 icms15 = new NFNotaInfoItemImpostoICMS15();
        icms15.setOrigem(NFOrigem.NACIONAL);
        icms15.setPercentualAliquota(new BigDecimal("99.99"));
        icms15.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES);
        icms15.setValorTributo(new BigDecimal("999999999999.99"));
        icms15.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS15 icms15 = new NFNotaInfoItemImpostoICMS15();
        icms15.setOrigem(NFOrigem.NACIONAL);
        icms15.setPercentualAliquota(new BigDecimal("99.99"));
        icms15.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES);
        icms15.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms15.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaRetencaoNulo() {
        final NFNotaInfoItemImpostoICMS15 icms15 = new NFNotaInfoItemImpostoICMS15();
        icms15.setOrigem(NFOrigem.NACIONAL);
        icms15.setPercentualAliquota(new BigDecimal("99.99"));
        icms15.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES);
        icms15.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms15.setValorTributo(new BigDecimal("999999999999.99"));
        icms15.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoRetencaoNulo() {
        final NFNotaInfoItemImpostoICMS15 icms15 = new NFNotaInfoItemImpostoICMS15();
        icms15.setOrigem(NFOrigem.NACIONAL);
        icms15.setPercentualAliquota(new BigDecimal("99.99"));
        icms15.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_PROPRIA_E_COM_RESPONSABILIDADE_PELO_RETENCAO_SOBRE_COMBUSTIVES);
        icms15.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms15.setValorTributo(new BigDecimal("999999999999.99"));
        icms15.setPercentualReducaoAliquota(new BigDecimal("0"));
        icms15.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS15><orig>0</orig><CST>15</CST><qBCMono>999999999999.99</qBCMono><adRemICMS>99.99</adRemICMS><vICMSMono>999999999999.99</vICMSMono><adRemICMSReten>0.00</adRemICMSReten><vICMSMonoReten>0.00</vICMSMonoReten></NFNotaInfoItemImpostoICMS15>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS15().toString());
    }
}