package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaCOFINS;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSAliquotaTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSAliquota().setValor(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCaluloTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSAliquota().setValorBaseCalculo(new BigDecimal("10000000000000"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualAliquotaTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSAliquota().setPercentualAliquota(new BigDecimal("1000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValorBaseCalculoNulo() {
        final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
        cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES);
        cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
        cofinsAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValorAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
        cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES);
        cofinsAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        cofinsAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveSituacaoTributariaAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
        cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
        cofinsAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        cofinsAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
        cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES);
        cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
        cofinsAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        cofinsAliquota.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSAliquota><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></NFNotaInfoItemImpostoCOFINSAliquota>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota().toString());
    }
}