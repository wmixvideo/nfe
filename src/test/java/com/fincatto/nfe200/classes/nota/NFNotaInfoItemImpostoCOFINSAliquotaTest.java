package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.NFNotaInfoSituacaoTributariaCOFINS;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoCOFINSAliquota;

public class NFNotaInfoItemImpostoCOFINSAliquotaTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSAliquota().setValor(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCaluloTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSAliquota().setValorBaseCalulo(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualAliquotaTamanhoInvalido() {
        new NFNotaInfoItemImpostoCOFINSAliquota().setPercentualAliquota(new BigDecimal("100"));
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