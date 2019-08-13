package com.fincatto.documentofiscal.validadores;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalValidadorTest {
    
    @Test
    public void tamanho11Com3CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho11Com3CasasDecimais(null, ""));
        Assert.assertEquals("1.000", BigDecimalValidador.tamanho11Com3CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.010", BigDecimalValidador.tamanho11Com3CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.012", BigDecimalValidador.tamanho11Com3CasasDecimais(new BigDecimal(".012"), ""));
    }
    
    @Test
    public void tamanho13Com2CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho13Com2CasasDecimais(null, ""));
        Assert.assertEquals("1.00", BigDecimalValidador.tamanho13Com2CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.01", BigDecimalValidador.tamanho13Com2CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.10", BigDecimalValidador.tamanho13Com2CasasDecimais(new BigDecimal(".1"), ""));
    }
    
    @Test
    public void tamanho15Com2CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho15Com2CasasDecimais(null, ""));
        Assert.assertEquals("0.01", BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("5.00", BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("5"), ""));
        Assert.assertEquals("100.00", BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("100"), ""));
        Assert.assertEquals("0.90", BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal(".9"), ""));
        Assert.assertEquals("182.64", BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("182.64"), ""));
    }
    
    @Test
    public void tamanho15Com3CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho15Com3CasasDecimais(null, ""));
        Assert.assertEquals("0.001", BigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal(".001"), ""));
        Assert.assertEquals("5.000", BigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("5"), ""));
        Assert.assertEquals("100.000", BigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("100"), ""));
        Assert.assertEquals("0.900", BigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal(".9"), ""));
        Assert.assertEquals("182.640", BigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("182.64"), ""));
    }
    
    @Test
    public void tamanho15Com4CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho15Com4CasasDecimais(null, ""));
        Assert.assertEquals("9999999999.9999", BigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("9999999999.9999"), ""));
        Assert.assertEquals("0.1000", BigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("0.0001", BigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("1.0000", BigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho21ComAte10CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho21ComAte10CasasDecimais(null, ""));
        Assert.assertEquals("9999999999.9999999999", BigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("9999999999.9999999999"), ""));
        Assert.assertEquals("1", BigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.1", BigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("0.156", BigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("0.156"), ""));
    }
    
    @Test
    public void tamanho16ComAte4CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho16ComAte4CasasDecimais(null, ""));
        Assert.assertEquals("99999999999.9999", BigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("99999999999.9999"), ""));
        Assert.assertEquals("0.0001", BigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("0.1", BigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("1", BigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho15ComAte6CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho15comAte6CasasDecimais(null, ""));
        Assert.assertEquals("999999999.999999", BigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("999999999.999999"), ""));
        Assert.assertEquals("0.0001", BigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("0.1", BigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("1", BigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho5Com2CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho5Com2CasasDecimais(null, ""));
        Assert.assertEquals("99.99", BigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("99.99"), ""));
        Assert.assertEquals("0.01", BigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("0.01"), ""));
        Assert.assertEquals("0.10", BigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("0.1"), ""));
        Assert.assertEquals("80.00", BigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("80"), ""));
        Assert.assertEquals("80.40", BigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("80.4"), ""));
    }
    
    @Test
    public void tamanho7ComAte4CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho7ComAte4CasasDecimais(null, ""));
        Assert.assertEquals("1.00", BigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.01", BigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.012", BigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal(".012"), ""));
        Assert.assertEquals("0.0123", BigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal(".0123"), ""));
    }
    
    @Test
    public void tamanho15comAte4CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho15comAte4CasasDecimais(null, ""));
        Assert.assertEquals("9999999999.9999", BigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9999"), ""));
        Assert.assertEquals("9999999999.9", BigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9"), ""));
        Assert.assertEquals("9999999999", BigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999"), ""));
        Assert.assertEquals("0.0001", BigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assert.assertEquals("1", BigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho16Com4CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho16Com4CasasDecimais(null, ""));
        Assert.assertEquals("1.0000", BigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.0100", BigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.0120", BigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal(".012"), ""));
        Assert.assertEquals("0.0123", BigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal(".0123"), ""));
    }
    
    @Test
    public void tamanho9Com4CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho9Com4CasasDecimais(null, ""));
        Assert.assertEquals("1.0000", BigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.0100", BigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal(".01"), ""));
        Assert.assertEquals("0.0120", BigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal(".012"), ""));
        Assert.assertEquals("0.0123", BigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal(".0123"), ""));
    }
    
    @Test
    public void tamanho4Com2CasasDecimais() {
        Assert.assertNull(BigDecimalValidador.tamanho4Com2CasasDecimais(null, ""));
        Assert.assertEquals("1.00", BigDecimalValidador.tamanho4Com2CasasDecimais(new BigDecimal("1"), ""));
        Assert.assertEquals("0.10", BigDecimalValidador.tamanho4Com2CasasDecimais(new BigDecimal(".1"), ""));
        Assert.assertEquals("0.12", BigDecimalValidador.tamanho4Com2CasasDecimais(new BigDecimal(".12"), ""));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoDeInteiros() {
        BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("99999999999999.9"), "");
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoDeCasasDecimais() {
        BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("99999999999.999"), "");
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom2CasasDecimais() {
        BigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("99999999999999.99"), "");
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom3CasasDecimais() {
        BigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("9999999999999.999"), "");
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirExtrapolar21Caracteres() {
        BigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("999999999999.9999999999"), "");
    }
    
    @Test(expected = NumberFormatException.class)
    public void validaTamanhoErro() {
        BigDecimalValidador.validaTamanho(new BigDecimal("10.00000"), "", 11, 4, true);
    }
    
    @Test
    public void validaTamanho() {
        BigDecimalValidador.validaTamanho(new BigDecimal("10.00000"), "", 11, 5, true);
        
        BigDecimalValidador.validaTamanho(new BigDecimal("10.000"), "", 11, 5, false);
        
        BigDecimalValidador.validaTamanho(new BigDecimal("99999.99999"), "", 11, 5, false);
    }
}
