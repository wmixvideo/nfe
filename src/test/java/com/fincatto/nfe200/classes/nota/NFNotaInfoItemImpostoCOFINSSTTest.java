package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemImpostoCOFINSST;

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
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSST>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST().toString());
    }
}