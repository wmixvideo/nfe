package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.DFUnidadeFederativa;
import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoCombustivelTest {

    @Test
    public void naoDevePermitirCodigoAutorizacaoCODIFComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoCombustivel().setCodigoAutorizacaoCODIF("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoCombustivel().setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG1");
            }
        });
    }

    @Test
    public void naoDevePermitirCodigoProdutoANPComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoCombustivel().setCodigoProdutoANP("99999999");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoCombustivel().setCodigoProdutoANP("9999999999");
            }
        });
    }

    @Test
    public void naoDevePermitirQuantidadeComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoCombustivel().setQuantidade(new BigDecimal("1000000000000")));
    }

    @Test
    public void devePermitirPercentualGasNaturalNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
        combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
        combustivel.setUf(DFUnidadeFederativa.AC);
        combustivel.toString();
    }

    @Test
    public void devePermitirCideNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
        combustivel.setUf(DFUnidadeFederativa.AC);
        combustivel.setPercentualGasNatural(new BigDecimal("99.99"));
        combustivel.toString();
    }

    @Test
    public void devePermitirCodigoAutorizacaoCODIFNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
        combustivel.setUf(DFUnidadeFederativa.AC);
        combustivel.setPercentualGasNatural(new BigDecimal("99.99"));
        combustivel.toString();
    }

    @Test
    public void naoDevePermitirCodigoProdutoANPNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
            combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
            combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
            combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
            combustivel.setUf(DFUnidadeFederativa.AC);
            combustivel.setPercentualGasNatural(new BigDecimal("99.99"));
            combustivel.toString();
        });
    }

    @Test
    public void devePermitirQuantidadeNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
        combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setUf(DFUnidadeFederativa.AC);
        combustivel.setPercentualGasNatural(new BigDecimal("99.99"));
        combustivel.toString();
    }

    @Test
    public void naoDevePermitirUFNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
            combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
            combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
            combustivel.setCodigoProdutoANP("999999999");
            combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
            combustivel.setPercentualGasNatural(new BigDecimal("99.99"));
            combustivel.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoCombustivel><cProdANP>999999999</cProdANP><pMixGN>99.99</pMixGN><CODIF>Cirh89sPDDbnFAzZMPpmG</CODIF><qTemp>99999999999.9999</qTemp><UFCons>RS</UFCons><CIDE><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vCIDE>999999999999.99</vCIDE></CIDE></NFNotaInfoItemProdutoCombustivel>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel().toString());
    }
}