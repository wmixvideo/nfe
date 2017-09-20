package com.fincatto.documentofiscal.nfe310.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import com.fincatto.documentofiscal.nfe310.classes.nota.NFNotaInfoItemImpostoPISQuantidade;

public class NFNotaInfoItemImpostoPISQuantidadeTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISQuantidade().setValorTributo(new BigDecimal("99999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirValorlAliquotaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISQuantidade().setValorAliquota(new BigDecimal("999999999999"));
    }

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        new NFNotaInfoItemImpostoPISQuantidade().setQuantidadeVendida(new BigDecimal("9999999999999"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrSituacaoTributariaNulo() {
        final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
        pisQuantidade.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        pisQuantidade.setValorAliquota(new BigDecimal("9999999999.9999"));
        pisQuantidade.setValorTributo(new BigDecimal("999999999999.99"));
        pisQuantidade.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrQuantidadeVendidaNulo() {
        final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
        pisQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
        pisQuantidade.setValorAliquota(new BigDecimal("9999999999.9999"));
        pisQuantidade.setValorTributo(new BigDecimal("999999999999.99"));
        pisQuantidade.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrValorAliquotaNulo() {
        final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
        pisQuantidade.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        pisQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
        pisQuantidade.setValorTributo(new BigDecimal("999999999999.99"));
        pisQuantidade.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitrValorTributoNulo() {
        final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
        pisQuantidade.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
        pisQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
        pisQuantidade.setValorAliquota(new BigDecimal("9999999999.9999"));
        pisQuantidade.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISQuantidade><CST>03</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISQuantidade>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade().toString());
    }
}