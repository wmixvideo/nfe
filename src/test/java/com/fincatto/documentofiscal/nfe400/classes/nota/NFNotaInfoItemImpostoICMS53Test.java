package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoImpostoTributacaoICMS;
import com.fincatto.documentofiscal.nfe400.classes.NFOrigem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoICMS53Test {

    @Test
    public void naoDevePermitirPercentualAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS53().setPercentualAliquota(new BigDecimal("1000")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS53().setQuantidadeBaseCalculo(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirValorTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoICMS53().setValorOperacao(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirOrigemNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
            icms53.setPercentualAliquota(new BigDecimal("99.99"));
            icms53.setSituacaoTributaria(NFNotaInfoImpostoTributacaoICMS.CST_53);
            icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms53.setValorOperacao(new BigDecimal("999999999999.99"));
            icms53.toString();
        });
    }

    @Test
    public void naoDevePermitirSituacaoTributariaCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoICMS53 icms53 = new NFNotaInfoItemImpostoICMS53();
            icms53.setOrigem(NFOrigem.NACIONAL);
            icms53.setPercentualAliquota(new BigDecimal("99.99"));
            icms53.setQuantidadeBaseCalculo(new BigDecimal("999999999999.99"));
            icms53.setValorOperacao(new BigDecimal("999999999999.99"));
            icms53.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoICMS53><orig>0</orig><CST>53</CST></NFNotaInfoItemImpostoICMS53>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoICMS53().toString());
    }
}