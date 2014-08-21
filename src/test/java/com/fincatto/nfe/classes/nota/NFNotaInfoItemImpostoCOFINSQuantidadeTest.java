package com.fincatto.nfe.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.nfe.FabricaDeObjetosFake;
import com.fincatto.nfe.classes.NFNotaInfoSituacaoTributariaCOFINS;

public class NFNotaInfoItemImpostoCOFINSQuantidadeTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirQuantidadeVendidoNulo() {
        final NFNotaInfoItemImpostoCOFINSQuantidade cofinsQuantidade = new NFNotaInfoItemImpostoCOFINSQuantidade();
        cofinsQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_ALIQUOTA_ZERO);
        cofinsQuantidade.setValorAliquota(new BigDecimal("9999999999.0000"));
        cofinsQuantidade.setValorTributo(new BigDecimal("999999999999.00"));
        cofinsQuantidade.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorAliquotaNulo() {
        final NFNotaInfoItemImpostoCOFINSQuantidade cofinsQuantidade = new NFNotaInfoItemImpostoCOFINSQuantidade();
        cofinsQuantidade.setQuantidadeVendida(new BigDecimal("99999999999"));
        cofinsQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_ALIQUOTA_ZERO);
        cofinsQuantidade.setValorTributo(new BigDecimal("999999999999.00"));
        cofinsQuantidade.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorTributoNulo() {
        final NFNotaInfoItemImpostoCOFINSQuantidade cofinsQuantidade = new NFNotaInfoItemImpostoCOFINSQuantidade();
        cofinsQuantidade.setQuantidadeVendida(new BigDecimal("99999999999"));
        cofinsQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.OPERACAO_AQUISICAO_ALIQUOTA_ZERO);
        cofinsQuantidade.setValorAliquota(new BigDecimal("9999999999.0000"));
        cofinsQuantidade.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSQuantidade><CST>OPERACAO_AQUISICAO_ALIQUOTA_ZERO</CST><qBCProd>99999999999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSQuantidade>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade().toString());
    }
}