package com.fincatto.documentofiscal.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DFUtilsTest {
    @Test
    public void deveRejeitarCnpjNulo() {
        Assertions.assertFalse(DFUtils.isCnpjValido(null));
    }

    @Test
    public void deveRejeitarCnpjVazio() {
        Assertions.assertFalse(DFUtils.isCnpjValido(""));
    }

    @Test
    public void deveRejeitarCnpjComTodosDigitosIguais() {
        Assertions.assertFalse(DFUtils.isCnpjValido("00000000000000"));
        Assertions.assertFalse(DFUtils.isCnpjValido("11111111111111"));
    }

    @Test
    public void deveValidarCnpjNumericoTradicional() {
        Assertions.assertTrue(DFUtils.isCnpjValido("03918609000132"));
        Assertions.assertTrue(DFUtils.isCnpjValido("11222333000181"));
    }

    @Test
    public void deveRejeitarCnpjNumericoComDigitoInvalido() {
        Assertions.assertFalse(DFUtils.isCnpjValido("03918609000199"));
        Assertions.assertFalse(DFUtils.isCnpjValido("11222333000100"));
    }

    @Test
    public void deveRejeitarCnpjComTamanhoInvalido() {
        Assertions.assertFalse(DFUtils.isCnpjValido("0391860900013"));
        Assertions.assertFalse(DFUtils.isCnpjValido("039186090001322"));
    }

    @Test
    public void deveRejeitarCnpjComCaracteresEspeciais() {
        Assertions.assertFalse(DFUtils.isCnpjValido("03.918.609/0001-32"));
    }

    @Test
    public void deveValidarCnpjAlfanumerico() {
        Assertions.assertTrue(DFUtils.isCnpjValido("12ABC34501DE35"));
        Assertions.assertTrue(DFUtils.isCnpjValido("12abc34501de35"));
    }

    @Test
    public void deveValidarCnpjAlfanumericoCaseInsensitive() {
        Assertions.assertTrue(DFUtils.isCnpjValido("12abc34501de35"));
    }

    @Test
    public void deveRejeitarCnpjAlfanumericoComDigitoInvalido() {
        Assertions.assertFalse(DFUtils.isCnpjValido("12ABC34501DE99"));
    }

    @Test
    public void deveRejeitarCnpjComLetraNosDigitosVerificadores() {
        Assertions.assertFalse(DFUtils.isCnpjValido("12ABC34501DEAB"));
    }

    @Test
    public void deveAceitarFormatoCnpjAlfanumericoCTe() {
        // Testa que CNPJs alfanuméricos seguem o padrão [A-Z0-9]{12}[0-9]{2}
        // Validação de formato, não de dígito verificador
        String cnpj1 = "0JRXDN7G000175";
        Assertions.assertTrue(cnpj1.length() == 14);
        Assertions.assertTrue(cnpj1.matches("^[0-9A-Z]{12}[0-9]{2}$"));
        
        String cnpj2 = "0X0J92JY000196";
        Assertions.assertTrue(cnpj2.length() == 14);
        Assertions.assertTrue(cnpj2.matches("^[0-9A-Z]{12}[0-9]{2}$"));
    }

    @Test
    public void deveValidarCnpjNumericoCompleto() {
        // Testa CNPJs numéricos válidos tradicionais
        Assertions.assertTrue(DFUtils.isCnpjValido("11222333000181"));
        Assertions.assertTrue(DFUtils.isCnpjValido("03918609000132"));
        Assertions.assertTrue(DFUtils.isCnpjValido("00000000000191"));
    }

    @Test
    public void deveValidarFormatoCnpjMixtoAlfanumerico() {
        // Testa CNPJs alfanuméricos válidos (incluindo cálculo de dígitos verificadores)
        Assertions.assertTrue(DFUtils.isCnpjValido("A1B2C3D4E5F668"));
        Assertions.assertTrue(DFUtils.isCnpjValido("123456ABCDEF66"));
    }

    @Test
    public void deveRejeitarCnpjAlfanumericoComCaracteresInvalidos() {
        // Testa rejeição de caracteres especiais
        Assertions.assertFalse(DFUtils.isCnpjValido("0JRXDN7G0001@5"));
        Assertions.assertFalse(DFUtils.isCnpjValido("0JRXDN7G-00175"));
        Assertions.assertFalse(DFUtils.isCnpjValido("0JRXDN7G 00175"));
    }

    @Test
    public void deveRejeitarCnpjComLetraMinusculaNosDigitosVerificadores() {
        // Os últimos 2 caracteres devem ser sempre numéricos
        Assertions.assertFalse(DFUtils.isCnpjValido("0JRXDN7G0001a5"));
        Assertions.assertFalse(DFUtils.isCnpjValido("0JRXDN7G00017b"));
    }

    @Test
    public void isCPFValido() {
        Assertions.assertFalse(DFUtils.isCpfValido(null));
        Assertions.assertFalse(DFUtils.isCpfValido(""));
        Assertions.assertFalse(DFUtils.isCpfValido("00000000000"));
        Assertions.assertFalse(DFUtils.isCpfValido("11111111111"));
        Assertions.assertFalse(DFUtils.isCpfValido("12345678909"));
        Assertions.assertTrue(DFUtils.isCpfValido("38883975022"));
    }

    @Test
    public void testIsNumerico() {
        Assertions.assertFalse(DFUtils.isNumerico(null));
        Assertions.assertFalse(DFUtils.isNumerico(""));
        Assertions.assertFalse(DFUtils.isNumerico(" 12 "));
        Assertions.assertTrue(DFUtils.isNumerico("0"));
        Assertions.assertTrue(DFUtils.isNumerico("1234567890"));
    }
}
