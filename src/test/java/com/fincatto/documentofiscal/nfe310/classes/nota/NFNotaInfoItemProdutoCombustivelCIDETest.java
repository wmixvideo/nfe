package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoCombustivelCIDETest {

    @Test
    public void naoDevePermitirValorQuantidadeBCCIDEComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoCombustivelCIDE().setQuantidadeBCCIDE(new BigDecimal("1000000000000")));
    }

    @Test
    public void naoDevePermitirValorAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoCombustivelCIDE().setValorAliquota(new BigDecimal("100000000000")));
    }

    @Test
    public void naoDevePermitirValorComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoCombustivelCIDE().setValor(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirQuantidadeBCCIDENulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
            cide.setValor(new BigDecimal("999999999999.99"));
            cide.setValorAliquota(new BigDecimal("9999999999.9999"));
            cide.toString();
        });
    }

    @Test
    public void naoDevePermitirValorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
            cide.setQuantidadeBCCIDE(new BigDecimal("99999999999.9999"));
            cide.setValorAliquota(new BigDecimal("9999999999.9999"));
            cide.toString();
        });
    }

    @Test
    public void naoDevePermitirValorAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
            cide.setQuantidadeBCCIDE(new BigDecimal("99999999999.9999"));
            cide.setValor(new BigDecimal("999999999999.99"));
            cide.toString();
        });
    }

    @Test
    public void deveObterValorAliquotaComoFoiSetado() {
        final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
        cide.setValorAliquota(new BigDecimal("9999999999.9999"));
        Assertions.assertEquals("9999999999.9999", cide.getValorAliquota());
    }

    @Test
    public void deveObterValorComoFoiSetado() {
        final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
        cide.setValor(new BigDecimal("999999999999.99"));
        Assertions.assertEquals("999999999999.99", cide.getValor());
    }

    @Test
    public void deveObterQuantidadeBCCIDEComoFoiSetado() {
        final NFNotaInfoItemProdutoCombustivelCIDE cide = new NFNotaInfoItemProdutoCombustivelCIDE();
        cide.setQuantidadeBCCIDE(new BigDecimal("99999999999.9999"));
        Assertions.assertEquals("99999999999.9999", cide.getQuantidadeBCCIDE());
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoCombustivelCIDE><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vCIDE>999999999999.99</vCIDE></NFNotaInfoItemProdutoCombustivelCIDE>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE().toString());
    }
}