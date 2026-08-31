package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoGrupoCreditoPresumidoTest {

    @Test
    public void naoDevePermitirCodigoBeneficioFiscalCreditoPresumidoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemProdutoGrupoCreditoPresumido().setCodigoBeneficioFiscalCreditoPresumido(
            "12345678901"));
    }

    @Test
    public void naoDevePermitirPercentualCreditoPresumidoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoGrupoCreditoPresumido().setPercentualCreditoPresumido(
            new BigDecimal("100.12456")));
    }

    @Test
    public void naoDevePermitirValorCreditoPresumidoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoGrupoCreditoPresumido().setValorCreditoPresumido(
            new BigDecimal("12345.124567")));
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemProdutoGrupoCreditoPresumido><cCredPresumido>DF020111</cCredPresumido><pCredPresumido>65.12</pCredPresumido><vCredPresumido>12.73</vCredPresumido></NFNotaInfoItemProdutoGrupoCreditoPresumido>";
        Assertions.assertEquals(xmlEsperado,
            FabricaDeObjetosFake.getNFNotaInfoItemProdutoGrupoCreditoPresumido().toString());
    }
}
