package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoPISAliquotaTest {

    @Test
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISAliquota().setValorTributo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirValorlAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISAliquota().setPercentualAliquota(new BigDecimal("9999")));
    }

    @Test
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISAliquota().setValorBaseCalculo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitrValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
            pisAliquota.setPercentualAliquota(new BigDecimal("99.99"));
            pisAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO);
            pisAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            pisAliquota.toString();
        });
    }

    @Test
    public void naoDevePermitrValorBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
            pisAliquota.setPercentualAliquota(new BigDecimal("99.99"));
            pisAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO);
            pisAliquota.setValorTributo(new BigDecimal("999999999999.99"));
            pisAliquota.toString();
        });
    }

    @Test
    public void naoDevePermitrSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
            pisAliquota.setPercentualAliquota(new BigDecimal("99.99"));
            pisAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            pisAliquota.setValorTributo(new BigDecimal("999999999999.99"));
            pisAliquota.toString();
        });
    }

    @Test
    public void naoDevePermitrPercentualAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
            pisAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO);
            pisAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            pisAliquota.setValorTributo(new BigDecimal("999999999999.99"));
            pisAliquota.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISAliquota><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISAliquota>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota().toString());
    }
}