package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemImpostoCOFINSSTTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorCOFINSForaoDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setValorCOFINS(new BigDecimal("99999999999999999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorAliquotaCOFINSForaoDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setValorAliquotaCOFINS(new BigDecimal("99999999999999999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeVendidaForaDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setQuantidadeVendida(new BigDecimal("999999999999999999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorPercentualAliquotaCOFINSForaDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setPercentualAliquota(new BigDecimal("100.01"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorBaseCalculoForaDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setValorBaseCalculo(new BigDecimal("99999999999999999"));
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoCOFINSST cofins = new NFNotaInfoItemImpostoCOFINSST();
        cofins.setPercentualAliquota(new BigDecimal("99.99"));
        cofins.setQuantidadeVendida(new BigDecimal("9999999999999999"));
        cofins.setValorCOFINS(new BigDecimal("999999999999999"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSST><pCOFINS>99.99</pCOFINS><qBCProd>9999999999999999</qBCProd><vCOFINS>999999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSST>";
        Assert.assertEquals(xmlEsperado, cofins.toString());
    }
}