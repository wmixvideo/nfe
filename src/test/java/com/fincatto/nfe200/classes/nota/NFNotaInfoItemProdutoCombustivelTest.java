package com.fincatto.nfe200.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe200.FabricaDeObjetosFake;
import com.fincatto.nfe200.classes.NFUnidadeFederativa;
import com.fincatto.nfe200.classes.nota.NFNotaInfoItemProdutoCombustivel;

public class NFNotaInfoItemProdutoCombustivelTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoAutorizacaoCODIFComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoCombustivel().setCodigoAutorizacaoCODIF("");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoCombustivel().setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG1");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoProdutoANPComTamanhoInvalido() {
        try {
            new NFNotaInfoItemProdutoCombustivel().setCodigoProdutoANP("99999999");
        } catch (final IllegalStateException e) {
            new NFNotaInfoItemProdutoCombustivel().setCodigoProdutoANP("9999999999");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeComTamanhoInvalido() {
        new NFNotaInfoItemProdutoCombustivel().setQuantidade(new BigDecimal("100000000000"));
    }

    @Test
    public void devePermitirCideNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
        combustivel.setUf(NFUnidadeFederativa.AC);
        combustivel.toString();
    }

    @Test
    public void devePermitirCodigoAutorizacaoCODIFNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
        combustivel.setUf(NFUnidadeFederativa.AC);
        combustivel.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoProdutoANPNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
        combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
        combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
        combustivel.setUf(NFUnidadeFederativa.AC);
        combustivel.toString();
    }

    @Test
    public void devePermitirQuantidadeNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
        combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setUf(NFUnidadeFederativa.AC);
        combustivel.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirUFNulo() {
        final NFNotaInfoItemProdutoCombustivel combustivel = new NFNotaInfoItemProdutoCombustivel();
        combustivel.setCide(FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivelCIDE());
        combustivel.setCodigoAutorizacaoCODIF("Cirh89sPDDbnFAzZMPpmG");
        combustivel.setCodigoProdutoANP("999999999");
        combustivel.setQuantidade(new BigDecimal("99999999999.9999"));
        combustivel.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoCombustivel><cProdANP>999999999</cProdANP><CODIF>Cirh89sPDDbnFAzZMPpmG</CODIF><qTemp>99999999999.9999</qTemp><UFCons>AC</UFCons><CIDE><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vCIDE>999999999999.99</vCIDE></CIDE></NFNotaInfoItemProdutoCombustivel>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemProdutoCombustivel().toString());
    }
}