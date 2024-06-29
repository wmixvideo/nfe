package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoGrupoCreditoPresumidoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoBeneficioFiscalCreditoPresumidoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoGrupoCreditoPresumido().setCodigoBeneficioFiscalCreditoPresumido(
            "12345678901");
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPercentualCreditoPresumidoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoGrupoCreditoPresumido().setPercentualCreditoPresumido(
            new BigDecimal("100.12456"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorCreditoPresumidoComTamanhoInvalido() {
        new NFNotaInfoItemProdutoGrupoCreditoPresumido().setValorCreditoPresumido(
            new BigDecimal("12345.124567"));
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoGrupoCreditoPresumido><cCredPresumido>DF020111</cCredPresumido><pCredPresumido>65.12</pCredPresumido><vCredPresumido>12.73</vCredPresumido></NFNotaInfoItemProdutoGrupoCreditoPresumido>";
        Assert.assertEquals(xmlEsperado,
            FabricaDeObjetosFake.getNFNotaInfoItemProdutoGrupoCreditoPresumido().toString());
    }
}
