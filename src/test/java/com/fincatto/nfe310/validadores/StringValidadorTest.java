package com.fincatto.nfe310.validadores;

import org.junit.Assert;
import org.junit.Test;

public class StringValidadorTest {

    @Test
    public void deveValidarDataPadraoBrasileiro() {
        StringValidador.mmaaaa("12/2014");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaPadraoAmericano() {
        StringValidador.mmaaaa("2014-12");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaSemCaracterSeparador() {
        StringValidador.mmaaaa("201412");
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroIntervalo60() {
        StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh");
        StringValidador.tamanho60("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo60() {
        try {
            StringValidador.tamanho60("oO3xPZlrBVtl4YcGaFLDmKouamLIoyIptA1fZ8CBfZWjzsjMW7ozuF1bkQrh1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho60("");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanho2ou3N() {
        StringValidador.tamanho2ou3N("01");
        StringValidador.tamanho2ou3N("999");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirNaoNumerosParaTamanho2ou3N() {
        StringValidador.tamanho2ou3N("0N");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirExtrapolarTamanho2ou3N() {
        try {
            StringValidador.tamanho2ou3N("9");
            Assert.fail();
        } catch (final IllegalStateException e) {
            StringValidador.tamanho2ou3N("1000");
            Assert.fail();
        }
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroIntervalo() {
        StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV");
        StringValidador.tamanho22("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo22() {
        try {
            StringValidador.tamanho22("AZgCErXz4DlSwRmsJaeyUV1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho22("");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarTamanhoDeStringCasoEstejaDentroDoIntervalo() {
        StringValidador.tamanho20("AZgCErXz4DlSwRmsJaey");
        StringValidador.tamanho20("o");
    }

    @Test(expected = IllegalStateException.class)
    public void deveLancarExcecaoCasoEstejaForaDoIntervalo20() {
        try {
            StringValidador.tamanho20("AZgCErXz4DlSwRmsJaey1");
            Assert.fail("Validacao falhou");
        } catch (final IllegalStateException e) {
            StringValidador.tamanho20("");
        }
        Assert.fail("Validacao falhou");
    }

    @Test
    public void deveValidarPlacaDeVeiculo() {
        StringValidador.placaDeVeiculo("MKZ8851");
        StringValidador.placaDeVeiculo("MKZ8851");
        StringValidador.placaDeVeiculo("MKZT885");
        StringValidador.placaDeVeiculo("MKZ885");
        StringValidador.placaDeVeiculo("MK8851");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarPlacaDeVeiculoCasoNaoPossua6ou7Caracteres() {
        try {
            StringValidador.placaDeVeiculo("MK885");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            StringValidador.placaDeVeiculo("MKZT8851");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCPFCasoNaoPossua11Caracteres() {
        try {
            StringValidador.cpf("1234567890");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            StringValidador.cpf("123456789012");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarCNPJCasoNaoPossua14Caracteres() {
        try {
            StringValidador.cnpj("1234567890123");
            Assert.fail("Validacao nao funcionou");
        } catch (final IllegalStateException e) {
            StringValidador.cnpj("123456789012345");
        }
        Assert.fail("Validacao nao funcionou");
    }

    @Test
    public void deveValidarInscricaoEstadualCasoEstejaNoPadrao() {
        StringValidador.inscricaoEstadual("");
        StringValidador.inscricaoEstadual("ISENTO");
        StringValidador.inscricaoEstadual("12");
        StringValidador.inscricaoEstadual("12345678901234");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualCasoNaoEstejaNoTamanho() {
        try {
            StringValidador.inscricaoEstadual("1");
        } catch (final IllegalStateException e) {
            StringValidador.inscricaoEstadual("123456789012345");
        }
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveValidarInscricaoEstadualCasoEstejaForaDoPadrao() {
        StringValidador.inscricaoEstadual("ISENT0");
    }

    @Test
    public void deveValidarCodigoDeBarrasValido() {
        StringValidador.codigoDeBarras("35647210039861");
        StringValidador.codigoDeBarras("356472100398");
        StringValidador.codigoDeBarras("35647210");
        StringValidador.codigoDeBarras("");
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoDeBarrasComValorInvalido() {
        try {
            StringValidador.codigoDeBarras("356472100398610");
        } catch (final IllegalStateException e) {
            try {
                StringValidador.codigoDeBarras("35647210039");
            } catch (final IllegalStateException e2) {
                try {
                    StringValidador.codigoDeBarras("3564721");
                } catch (final IllegalStateException e3) {
                    StringValidador.codigoDeBarras("3");
                }
            }
        }
    }
}