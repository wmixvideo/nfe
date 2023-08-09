package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS61Test {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS61().setPercentualAliquota(new BigDecimal("1000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS61().setQuantidadeBaseCalculo(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS61().setValorTributo(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
        icms61.setPercentualAliquota(new BigDecimal("99.99"));
        icms61.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COBRADA_ANTERIORMENTE);
        icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms61.setValorTributo(new BigDecimal("999999999999.99"));
        icms61.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
        icms61.setOrigem(NFOrigem.NACIONAL);
        icms61.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COBRADA_ANTERIORMENTE);
        icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms61.setValorTributo(new BigDecimal("999999999999.99"));
        icms61.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
        icms61.setOrigem(NFOrigem.NACIONAL);
        icms61.setPercentualAliquota(new BigDecimal("99.99"));
        icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms61.setValorTributo(new BigDecimal("999999999999.99"));
        icms61.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
        icms61.setOrigem(NFOrigem.NACIONAL);
        icms61.setPercentualAliquota(new BigDecimal("99.99"));
        icms61.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COBRADA_ANTERIORMENTE);
        icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms61.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS61><orig>0</orig><CST>61</CST><qBCMonoRet>999999999999.99</qBCMonoRet><adRemICMSRet>99.99</adRemICMSRet><vICMSMonoRet>999999999999.99</vICMSMonoRet></NFNotaInfoItemImpostoICMS61>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS61().toString());
    }
}