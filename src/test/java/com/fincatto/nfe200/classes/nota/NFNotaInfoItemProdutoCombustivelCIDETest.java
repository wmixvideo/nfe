package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemProdutoCombustivelCIDE;

public class NFNotaInfoItemProdutoCombustivelCIDETest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorQuantidadeBCCIDEComTamanhoInvalido() {
        new NFNotaInfoItemProdutoCombustivelCIDE().setQuantidadeBCCIDE(new BigDecimal("100000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemProdutoCombustivelCIDE().setValorAliquota(new BigDecimal("10000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorComTamanhoInvalido() {
        new NFNotaInfoItemProdutoCombustivelCIDE().setValor(new BigDecimal("1000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeBCCIDENulo() {
        final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
        cide.setValor(new BigDecimal("999999999999.99"));
        cide.setValorAliquota(new BigDecimal("9999999999.9999"));
        cide.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorNulo() {
        final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
        cide.setQuantidadeBCCIDE(new BigDecimal("99999999999.9999"));
        cide.setValorAliquota(new BigDecimal("9999999999.9999"));
        cide.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorAliquotaNulo() {
        final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
        cide.setQuantidadeBCCIDE(new BigDecimal("99999999999.9999"));
        cide.setValor(new BigDecimal("999999999999.99"));
        cide.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoCombustivelCIDE><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vCIDE>999999999999.99</vCIDE></NFNotaInfoItemProdutoCombustivelCIDE>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE().toString());
    }
}