package com.fincatto.nfe.core.nota;

import com.fincatto.nfe.core.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSSTTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorCOFINSForaoDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setValorCOFINS(new BigDecimal("99999999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorAliquotaCOFINSForaoDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setValorAliquotaCOFINS(new BigDecimal("99999999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeVendidaForaDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setQuantidadeVendida(new BigDecimal("999999999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorPercentualAliquotaCOFINSForaDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setPercentualAliquota(new BigDecimal("1000.01"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBaseCalculoForaDoLimite() {
        new NFNotaInfoItemImpostoCOFINSST().setValorBaseCalculo(new BigDecimal("99999999999999999"));
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSST><vBC>999999999999.99</vBC><pCOFINS>99.99</pCOFINS><vCOFINS>999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSST>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSST().toString());
    }
}