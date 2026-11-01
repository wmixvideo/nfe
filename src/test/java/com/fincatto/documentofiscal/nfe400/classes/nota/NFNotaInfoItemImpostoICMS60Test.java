package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.Element;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS60Test {
    
    @Test
    public void naoDevePermitirValorBCICMSSTRetidoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS60().setValorBCICMSSTRetido(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirValorICMSSTRetidoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS60().setValorICMSSTRetido(new BigDecimal("10000000000000")));
    }
    
    @Test
    public void naoDevePermitirValorZeradoParaPercentualFundoCombatePobreza() {
        Assertions.assertThrows(IllegalStateException.class, () -> new NFNotaInfoItemImpostoICMS00().setPercentualFundoCombatePobreza(BigDecimal.ZERO));
    }
    
    @Test
    public void naoDeveSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
            icms60.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
            icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
            icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icms60.toString());
        });
    }
    
    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
            icms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_60);
            icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
            icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
            Assertions.assertNotNull(icms60.toString());
        });
    }
    
    @Test
    public void devePermitirValorBCICMSSTRetidoRequiredFalse() throws NoSuchFieldException {
        final Field campo = NFNotaInfoItemImpostoICMS60.class.getDeclaredField("valorBCICMSSTRetido");
        Assertions.assertFalse(campo.getDeclaredAnnotation(Element.class).required());
    }
    
    @Test
    public void devePermitirValorICMSSTRetidoRequiredFalse() throws NoSuchFieldException {
        final Field campo = NFNotaInfoItemImpostoICMS60.class.getDeclaredField("valorICMSSTRetido");
        Assertions.assertFalse(campo.getDeclaredAnnotation(Element.class).required());
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
        Assertions.assertEquals(xmlEsperado, icms60.toString());
    }
}