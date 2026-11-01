package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoCartaoTest {

    @Test
    public void naoDevePermitirNumeroAutorizacaoOperacaoCartaoComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoCartao().setNumeroAutorizacaoOperacaoCartao("9ItpS1hBk3TyhjUB3I901"));
    }

    @Test
    public void naoDevePermitirCNPJComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoCartao().setCnpj("1234567890123");
            } catch (final IllegalStateException e) {
                new NFNotaInfoCartao().setCnpj("123456789012345");
            }
        });
    }

    @Test
    public void naoDevePermitirCNPJNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoCartao cartao = new NFNotaInfoCartao();
            cartao.setNumeroAutorizacaoOperacaoCartao("9ItpS1hBk3TyhjUB3I90");
            cartao.setOperadoraCartao(NFOperadoraCartao.MASTERCARD);
            cartao.toString();
        });
    }

    @Test
    public void naoDevePermitirNumeroAutorizacaoOperacaoCartaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoCartao cartao = new NFNotaInfoCartao();
            cartao.setCnpj("12345678901234");
            cartao.setOperadoraCartao(NFOperadoraCartao.MASTERCARD);
            cartao.toString();
        });
    }

    @Test
    public void naoDevePermitirOperadoraCartaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoCartao cartao = new NFNotaInfoCartao();
            cartao.setCnpj("12345678901234");
            cartao.setNumeroAutorizacaoOperacaoCartao("9ItpS1hBk3TyhjUB3I90");
            cartao.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoCartao><tpIntegra>1</tpIntegra><CNPJ>12345678901234</CNPJ><tBand>02</tBand><cAut>9ItpS1hBk3TyhjUB3I90</cAut></NFNotaInfoCartao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoCartao().toString());
    }
}