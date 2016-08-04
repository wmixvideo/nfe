package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.FabricaDeObjetosFake;
import com.fincatto.nfe.core.NFNotaInfoSituacaoTributariaCOFINS;
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
        new NFNotaInfoItemImpostoCOFINSAliquota().setValorBaseCalulo(new BigDecimal("10000000000000"));
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
        cofinsAliquota.setValorBaseCalulo(new BigDecimal("999999999999.99"));
        cofinsAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveSituacaoTributariaAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
        cofinsAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
        cofinsAliquota.setValorBaseCalulo(new BigDecimal("999999999999.99"));
        cofinsAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSAliquota cofinsAliquota = new NFNotaInfoItemImpostoCOFINSAliquota();
        cofinsAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CREDITO_PRESUMIDO_OUTRAS_OPERACOES);
        cofinsAliquota.setValor(new BigDecimal("999999999999.99"));
        cofinsAliquota.setValorBaseCalulo(new BigDecimal("999999999999.99"));
        cofinsAliquota.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSAliquota><CST>01</CST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.99</vCOFINS></NFNotaInfoItemImpostoCOFINSAliquota>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSAliquota().toString());
    }
}