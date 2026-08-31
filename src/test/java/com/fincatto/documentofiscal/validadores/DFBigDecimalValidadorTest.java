package com.fincatto.documentofiscal.validadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DFBigDecimalValidadorTest {
    
    @Test
    public void tamanho11Com3CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho11Com3CasasDecimais(null, ""));
        Assertions.assertEquals("1.000", DFBigDecimalValidador.tamanho11Com3CasasDecimais(new BigDecimal("1"), ""));
        Assertions.assertEquals("0.010", DFBigDecimalValidador.tamanho11Com3CasasDecimais(new BigDecimal(".01"), ""));
        Assertions.assertEquals("0.012", DFBigDecimalValidador.tamanho11Com3CasasDecimais(new BigDecimal(".012"), ""));
    }
    
    @Test
    public void tamanho13Com2CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho13Com2CasasDecimais(null, ""));
        Assertions.assertEquals("1.00", DFBigDecimalValidador.tamanho13Com2CasasDecimais(new BigDecimal("1"), ""));
        Assertions.assertEquals("0.01", DFBigDecimalValidador.tamanho13Com2CasasDecimais(new BigDecimal(".01"), ""));
        Assertions.assertEquals("0.10", DFBigDecimalValidador.tamanho13Com2CasasDecimais(new BigDecimal(".1"), ""));
    }
    
    @Test
    public void tamanho15Com2CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho15Com2CasasDecimais(null, ""));
        Assertions.assertEquals("0.01", DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal(".01"), ""));
        Assertions.assertEquals("5.00", DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("5"), ""));
        Assertions.assertEquals("100.00", DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("100"), ""));
        Assertions.assertEquals("0.90", DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal(".9"), ""));
        Assertions.assertEquals("182.64", DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("182.64"), ""));
    }
    
    @Test
    public void tamanho15Com3CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho15Com3CasasDecimais(null, ""));
        Assertions.assertEquals("0.001", DFBigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal(".001"), ""));
        Assertions.assertEquals("5.000", DFBigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("5"), ""));
        Assertions.assertEquals("100.000", DFBigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("100"), ""));
        Assertions.assertEquals("0.900", DFBigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal(".9"), ""));
        Assertions.assertEquals("182.640", DFBigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("182.64"), ""));
    }
    
    @Test
    public void tamanho15Com4CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho15Com4CasasDecimais(null, ""));
        Assertions.assertEquals("9999999999.9999", DFBigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("9999999999.9999"), ""));
        Assertions.assertEquals("0.1000", DFBigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("0.1"), ""));
        Assertions.assertEquals("0.0001", DFBigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assertions.assertEquals("1.0000", DFBigDecimalValidador.tamanho15Com4CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho21ComAte10CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(null, ""));
        Assertions.assertEquals("9999999999.9999999999", DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("9999999999.9999999999"), ""));
        Assertions.assertEquals("1", DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("1"), ""));
        Assertions.assertEquals("0.1", DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("0.1"), ""));
        Assertions.assertEquals("0.156", DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("0.156"), ""));
    }
    
    @Test
    public void tamanho16ComAte4CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(null, ""));
        Assertions.assertEquals("99999999999.9999", DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("99999999999.9999"), ""));
        Assertions.assertEquals("0.0001", DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assertions.assertEquals("0.1", DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("0.1"), ""));
        Assertions.assertEquals("1", DFBigDecimalValidador.tamanho16ComAte4CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho15ComAte6CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho15comAte6CasasDecimais(null, ""));
        Assertions.assertEquals("999999999.999999", DFBigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("999999999.999999"), ""));
        Assertions.assertEquals("0.0001", DFBigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("0.0001"), ""));
        Assertions.assertEquals("0.1", DFBigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("0.1"), ""));
        Assertions.assertEquals("1", DFBigDecimalValidador.tamanho15comAte6CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho5Com2CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho5Com2CasasDecimais(null, ""));
        Assertions.assertEquals("99.99", DFBigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("99.99"), ""));
        Assertions.assertEquals("0.01", DFBigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("0.01"), ""));
        Assertions.assertEquals("0.10", DFBigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("0.1"), ""));
        Assertions.assertEquals("80.00", DFBigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("80"), ""));
        Assertions.assertEquals("80.40", DFBigDecimalValidador.tamanho5Com2CasasDecimais(new BigDecimal("80.4"), ""));
    }
    
    @Test
    public void tamanho7ComAte4CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(null, ""));
        Assertions.assertEquals("1.00", DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal("1"), ""));
        Assertions.assertEquals("0.01", DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal(".01"), ""));
        Assertions.assertEquals("0.012", DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal(".012"), ""));
        Assertions.assertEquals("0.0123", DFBigDecimalValidador.tamanho7ComAte4CasasDecimais(new BigDecimal(".0123"), ""));
    }
    
    @Test
    public void tamanho15comAte4CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho15comAte4CasasDecimais(null, ""));
        Assertions.assertEquals("9999999999.9999", DFBigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9999"), ""));
        Assertions.assertEquals("9999999999.9", DFBigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999.9"), ""));
        Assertions.assertEquals("9999999999", DFBigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("9999999999"), ""));
        Assertions.assertEquals("0.0001", DFBigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("0.0001"), ""));
        Assertions.assertEquals("1", DFBigDecimalValidador.tamanho15comAte4CasasDecimais(new BigDecimal("1"), ""));
    }
    
    @Test
    public void tamanho16Com4CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho16Com4CasasDecimais(null, ""));
        Assertions.assertEquals("1.0000", DFBigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal("1"), ""));
        Assertions.assertEquals("0.0100", DFBigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal(".01"), ""));
        Assertions.assertEquals("0.0120", DFBigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal(".012"), ""));
        Assertions.assertEquals("0.0123", DFBigDecimalValidador.tamanho16Com4CasasDecimais(new BigDecimal(".0123"), ""));
    }
    
    @Test
    public void tamanho9Com4CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho9Com4CasasDecimais(null, ""));
        Assertions.assertEquals("1.0000", DFBigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal("1"), ""));
        Assertions.assertEquals("0.0100", DFBigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal(".01"), ""));
        Assertions.assertEquals("0.0120", DFBigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal(".012"), ""));
        Assertions.assertEquals("0.0123", DFBigDecimalValidador.tamanho9Com4CasasDecimais(new BigDecimal(".0123"), ""));
    }
    
    @Test
    public void tamanho4Com2CasasDecimais() {
        Assertions.assertNull(DFBigDecimalValidador.tamanho4Com2CasasDecimais(null, ""));
        Assertions.assertEquals("1.00", DFBigDecimalValidador.tamanho4Com2CasasDecimais(new BigDecimal("1"), ""));
        Assertions.assertEquals("0.10", DFBigDecimalValidador.tamanho4Com2CasasDecimais(new BigDecimal(".1"), ""));
        Assertions.assertEquals("0.12", DFBigDecimalValidador.tamanho4Com2CasasDecimais(new BigDecimal(".12"), ""));
    }
    
    @Test
    public void naoDevePermitirExtrapolacaoDeInteiros() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("99999999999999.9"), ""));
    }
    
    @Test
    public void naoDevePermitirExtrapolacaoDeCasasDecimais() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("99999999999.999"), ""));
    }
    
    @Test
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom2CasasDecimais() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigDecimalValidador.tamanho15Com2CasasDecimais(new BigDecimal("99999999999999.99"), ""));
    }
    
    @Test
    public void naoDevePermitirExtrapolacaoPor15CaracteresCom3CasasDecimais() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigDecimalValidador.tamanho15Com3CasasDecimais(new BigDecimal("9999999999999.999"), ""));
    }
    
    @Test
    public void naoDevePermitirExtrapolar21Caracteres() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigDecimalValidador.tamanho21ComAte10CasasDecimais(new BigDecimal("999999999999.9999999999"), ""));
    }
    
    @Test
    public void validaTamanhoErro() {
        Assertions.assertThrows(NumberFormatException.class, () -> DFBigDecimalValidador.validaTamanho(new BigDecimal("10.00000"), "", 11, 4, true));
    }
    
    @Test
    public void validaTamanho() {
        DFBigDecimalValidador.validaTamanho(new BigDecimal("10.00000"), "", 11, 5, true);
        
        DFBigDecimalValidador.validaTamanho(new BigDecimal("10.000"), "", 11, 5, false);
        
        DFBigDecimalValidador.validaTamanho(new BigDecimal("99999.99999"), "", 11, 5, false);
    }
}
