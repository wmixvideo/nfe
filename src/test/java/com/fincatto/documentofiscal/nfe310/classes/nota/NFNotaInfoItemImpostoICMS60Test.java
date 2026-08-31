package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe310.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void naoDeveSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
            icms60.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
            icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
            icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
            icms60.toString();
        });
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
            icms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
            icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
            icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
            icms60.toString();
        });
    }

    @Test
    public void devePermitirValorBCICMSSTRetidoNulo() {
        final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
        icms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
        icms60.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));
        icms60.toString();
    }

    @Test
    public void devePermitirValorICMSSTRetidoNulo() {
        final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
        icms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
        icms60.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms60.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemImpostoICMS60 icms60 = new NFNotaInfoItemImpostoICMS60();
        icms60.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.ISENTA_OU_NAO_TRIBUTADA_COM_COBRANCA_ICMS_POR_SUBSTITUICAO_TRIBUTARIA);
        icms60.setOrigem(NFOrigem.ESTRANGEIRA_ADQUIRIDA_MERCADO_INTERNO);
        icms60.setValorBCICMSSTRetido(new BigDecimal("999999999999.99"));
        icms60.setValorICMSSTRetido(new BigDecimal("999999999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS60><orig>2</orig><CST>30</CST><vBCSTRet>999999999999.99</vBCSTRet><vICMSSTRet>999999999999.99</vICMSSTRet></NFNotaInfoItemImpostoICMS60>";
        Assertions.assertEquals(xmlEsperado, icms60.toString());
    }
}