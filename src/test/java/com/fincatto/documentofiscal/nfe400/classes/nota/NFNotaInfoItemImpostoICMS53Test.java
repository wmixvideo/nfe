package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS53Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS53().setPercentualAliquota(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS53().setQuantidadeBaseCalculo(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS53().setValorTributo(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
        icms53.setPercentualAliquota(new BigDecimal("99.99"));
        icms53.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO);
        icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms53.setValorTributo(new BigDecimal("999999999999.99"));
        icms53.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
        icms53.setOrigem(NFOrigem.NACIONAL);
        icms53.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO);
        icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms53.setValorTributo(new BigDecimal("999999999999.99"));
        icms53.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
        icms53.setOrigem(NFOrigem.NACIONAL);
        icms53.setPercentualAliquota(new BigDecimal("99.99"));
        icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms53.setValorTributo(new BigDecimal("999999999999.99"));
        icms53.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCalculoNulo() {
        final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
        icms53.setOrigem(NFOrigem.NACIONAL);
        icms53.setPercentualAliquota(new BigDecimal("99.99"));
        icms53.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO);
        icms53.setValorTributo(new BigDecimal("999999999999.99"));
        icms53.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
        icms53.setOrigem(NFOrigem.NACIONAL);
        icms53.setPercentualAliquota(new BigDecimal("99.99"));
        icms53.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO);
        icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms53.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS53><orig>0</orig><CST>53</CST><qBCMonoDif>999999999999.99</qBCMonoDif><adRemICMSDif>99.99</adRemICMSDif><vICMSMonoDif>999999999999.99</vICMSMonoDif></NFNotaInfoItemImpostoICMS53>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS53().toString());
    }
}