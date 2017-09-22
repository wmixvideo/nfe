package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImpostoPISAliquota;

public class NFNotaInfoItemImpostoPISAliquotaTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISAliquota().setValorTributo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorlAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISAliquota().setPercentualAliquota(new BigDecimal("9999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISAliquota().setValorBaseCalculo(new BigDecimal("99999999999999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrValorTributoNulo() {
        final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
        pisAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        pisAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO);
        pisAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        pisAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrValorBaseCalculoNulo() {
        final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
        pisAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        pisAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO);
        pisAliquota.setValorTributo(new BigDecimal("999999999999.99"));
        pisAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
        pisAliquota.setPercentualAliquota(new BigDecimal("99.99"));
        pisAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        pisAliquota.setValorTributo(new BigDecimal("999999999999.99"));
        pisAliquota.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrPercentualAliquotaNulo() {
        final NFNotaInfoItemImpostoPISAliquota pisAliquota = new NFNotaInfoItemImpostoPISAliquota();
        pisAliquota.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_RECEITAS_NAO_TRIBUTADAS_MERCADO_INTERNO_EXPORTACAO);
        pisAliquota.setValorBaseCalculo(new BigDecimal("999999999999.99"));
        pisAliquota.setValorTributo(new BigDecimal("999999999999.99"));
        pisAliquota.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISAliquota><CST>01</CST><vBC>999999999999.99</vBC><pPIS>99.99</pPIS><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISAliquota>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISAliquota().toString());
    }
}