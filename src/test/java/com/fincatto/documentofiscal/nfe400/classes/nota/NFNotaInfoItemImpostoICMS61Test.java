package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS61Test {

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS61().setPercentualAliquota(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS61().setQuantidadeBaseCalculo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS61().setValorTributo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
            icms61.setPercentualAliquota(new BigDecimal("99.99"));
            icms61.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_61);
            icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms61.setValorTributo(new BigDecimal("999999999999.99"));
            icms61.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
            icms61.setOrigem(NFOrigem.NACIONAL);
            icms61.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_61);
            icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms61.setValorTributo(new BigDecimal("999999999999.99"));
            icms61.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
            icms61.setOrigem(NFOrigem.NACIONAL);
            icms61.setPercentualAliquota(new BigDecimal("99.99"));
            icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms61.setValorTributo(new BigDecimal("999999999999.99"));
            icms61.toString();
        });
    }

    @Test
    public void naoDevePermitirValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS61 icms61 = new NFNotaInfoItemImpostoICMS61();
            icms61.setOrigem(NFOrigem.NACIONAL);
            icms61.setPercentualAliquota(new BigDecimal("99.99"));
            icms61.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_61);
            icms61.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms61.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS61><orig>0</orig><CST>61</CST><qBCMonoRet>999999999999.99</qBCMonoRet><adRemICMSRet>99.99</adRemICMSRet><vICMSMonoRet>999999999999.99</vICMSMonoRet></NFNotaInfoItemImpostoICMS61>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS61().toString());
    }
}