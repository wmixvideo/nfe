package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFInformacaoImpostoDevolvidoTest {

    @Test
    public void naoDevePermitirValorIPINulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFInformacaoImpostoDevolvido().toString());
    }

    @Test
    public void naoDevePermitirValorIPIInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            final NFInformacaoImpostoDevolvido informacaoImpostoDevolvido = new NFInformacaoImpostoDevolvido();
            informacaoImpostoDevolvido.setValorIPIDevolvido(new BigDecimal("10000000000000.00"));
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFInformacaoImpostoDevolvido informacaoImpostoDevolvido = new NFInformacaoImpostoDevolvido();
        informacaoImpostoDevolvido.setValorIPIDevolvido(new BigDecimal("9999999999999.99"));

        final String xmlEsperado = "<NFInformacaoImpostoDevolvido><vIPIDevol>9999999999999.99</vIPIDevol></NFInformacaoImpostoDevolvido>";
        Assertions.assertEquals(xmlEsperado, informacaoImpostoDevolvido.toString());
    }
}