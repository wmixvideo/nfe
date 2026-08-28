package com.fincatto.documentofiscal.nfe310.classes.nota;

import com.fincatto.documentofiscal.nfe310.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe310.classes.NFNotaInfoSituacaoTributariaPIS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoPISQuantidadeTest {

    @Test
    public void naoDevePermitirValorlTributoComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISQuantidade().setValorTributo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirValorlAliquotaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISQuantidade().setValorAliquota(new BigDecimal("999999999999")));
    }

    @Test
    public void naoDevePermitirQuantidadeVendidaComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoPISQuantidade().setQuantidadeVendida(new BigDecimal("9999999999999")));
    }

    @Test
    public void naoDevePermitrSituacaoTributariaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
            pisQuantidade.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
            pisQuantidade.setValorAliquota(new BigDecimal("9999999999.9999"));
            pisQuantidade.setValorTributo(new BigDecimal("999999999999.99"));
            pisQuantidade.toString();
        });
    }

    @Test
    public void naoDevePermitrQuantidadeVendidaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
            pisQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
            pisQuantidade.setValorAliquota(new BigDecimal("9999999999.9999"));
            pisQuantidade.setValorTributo(new BigDecimal("999999999999.99"));
            pisQuantidade.toString();
        });
    }

    @Test
    public void naoDevePermitrValorAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
            pisQuantidade.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
            pisQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
            pisQuantidade.setValorTributo(new BigDecimal("999999999999.99"));
            pisQuantidade.toString();
        });
    }

    @Test
    public void naoDevePermitrValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoPISQuantidade pisQuantidade = new NFNotaInfoItemImpostoPISQuantidade();
            pisQuantidade.setQuantidadeVendida(new BigDecimal("99999999999.9999"));
            pisQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaPIS.CREDITO_PRESUMIDO_OPERACAO_AQUISICAO_VINCULADA_EXCLUSIVAMENTE_A_RECEITA_NAO_TRIBUTADA_MERCADO_INTERNO);
            pisQuantidade.setValorAliquota(new BigDecimal("9999999999.9999"));
            pisQuantidade.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoPISQuantidade><CST>03</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.9999</vAliqProd><vPIS>999999999999.99</vPIS></NFNotaInfoItemImpostoPISQuantidade>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoPISQuantidade().toString());
    }
}