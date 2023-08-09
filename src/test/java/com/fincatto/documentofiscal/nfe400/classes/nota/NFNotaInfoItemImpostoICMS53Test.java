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
        new NFNotaInfoItemImpostoICMS53().setValorOperacao(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
        icms53.setPercentualAliquota(new BigDecimal("99.99"));
        icms53.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.TRIBUTACAO_MONOFASICA_SOBRE_COMBUSTIVEIS_COM_RECOLHIMENTO_DIFERIDO);
        icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms53.setValorOperacao(new BigDecimal("999999999999.99"));
        icms53.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
        icms53.setOrigem(NFOrigem.NACIONAL);
        icms53.setPercentualAliquota(new BigDecimal("99.99"));
        icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
        icms53.setValorOperacao(new BigDecimal("999999999999.99"));
        icms53.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS53><orig>0</orig><CST>53</CST></NFNotaInfoItemImpostoICMS53>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS53().toString());
    }
}