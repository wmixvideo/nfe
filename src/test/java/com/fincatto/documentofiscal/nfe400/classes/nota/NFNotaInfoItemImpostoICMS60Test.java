package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.Assert;
import org.junit.Test;
import org.simpleframework.xml.Element;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS60Test {
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorBCICMSSTRetidoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS60().setValorBCICMSSTRetido(new BigDecimal("10000000000000"));
    }
    
    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorICMSSTRetidoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoICMS60().setValorICMSSTRetido(new BigDecimal("10000000000000"));
    }
    
    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobreza() {
        new NFNotaInfoItemImpostoICMS00().setPercentualFundoCombatePobreza(BigDecimal.ZERO);
    }
    
    @Test(expected = IllegalStateException.class)
    public void naoDeveSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
        icms60.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icms60.toString());
    }
    
    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirOrigemNulo() {
        final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
        icms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_60);
        icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        Assert.assertNotNull(icms60.toString());
    }
    
    @Test
    public void devePermitirValorBCICMSSTRetidoRequiredFalse() throws NoSuchFieldException {
        final Field campo = NFNotaInfoItemImpostoICMS60.class.getDeclaredField("valorBCICMSSTRetido");
        Assert.assertFalse(campo.getDeclaredAnnotation(Element.class).required());
    }
    
    @Test
    public void devePermitirValorICMSSTRetidoRequiredFalse() throws NoSuchFieldException {
        final Field campo = NFNotaInfoItemImpostoICMS60.class.getDeclaredField("valorICMSSTRetido");
        Assert.assertFalse(campo.getDeclaredAnnotation(Element.class).required());
    }
    
    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
        icms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_60);
        icms60.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms60.setPercentualAliquotaICMSSTConsumidorFinal(new BigDecimal("100.0000"));
        icms60.setValorICMSSubstituto(new BigDecimal("999999999999.99"));
        icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        icms60.setValorBCFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        icms60.setPercentualFundoCombatePobrezaRetidoST(new BigDecimal("100.0000"));
        icms60.setValorFundoCombatePobrezaRetidoST(new BigDecimal("999999999999.99"));
        
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS60><orig>2</orig><CST>60</CST><vBCSTRet>999999999999.99</vBCSTRet><pST>100.00</pST><vICMSSubstituto>999999999999.99</vICMSSubstituto><vICMSSTRet>999999999999.99</vICMSSTRet><vBCFCPSTRet>999999999999.99</vBCFCPSTRet><pFCPSTRet>100.00</pFCPSTRet><vFCPSTRet>999999999999.99</vFCPSTRet></NFNotaInfoItemImpostoICMS60>";
        Assert.assertEquals(xmlEsperado, icms60.toString());
    }
}