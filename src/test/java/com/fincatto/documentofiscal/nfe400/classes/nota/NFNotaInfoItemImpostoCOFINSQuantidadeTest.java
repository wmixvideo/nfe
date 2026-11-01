package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import com.fincatto.documentofiscal.nfe400.classes.NFNotaInfoSituacaoTributariaCOFINS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoCOFINSQuantidadeTest {

    @Test
    public void naoDevePermitirQuantidadeVendidoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSQuantidade cofinsQuantidade = new NFNotaInfoItemImpostoCOFINSQuantidade();
            cofinsQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_73);
            cofinsQuantidade.setValorAliquota(new BigDecimal("9999999999.0000"));
            cofinsQuantidade.setValorTributo(new BigDecimal("999999999999.00"));
            cofinsQuantidade.toString();
        });
    }

    @Test
    public void naoDevePermitirValorAliquotaNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSQuantidade cofinsQuantidade = new NFNotaInfoItemImpostoCOFINSQuantidade();
            cofinsQuantidade.setQuantidadeVendida(new BigDecimal("99999999999"));
            cofinsQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_73);
            cofinsQuantidade.setValorTributo(new BigDecimal("999999999999.00"));
            cofinsQuantidade.toString();
        });
    }

    @Test
    public void naoDevePermitirValorTributoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoCOFINSQuantidade cofinsQuantidade = new NFNotaInfoItemImpostoCOFINSQuantidade();
            cofinsQuantidade.setQuantidadeVendida(new BigDecimal("99999999999"));
            cofinsQuantidade.setSituacaoTributaria(NFNotaInfoSituacaoTributariaCOFINS.CST_73);
            cofinsQuantidade.setValorAliquota(new BigDecimal("9999999999.0000"));
            cofinsQuantidade.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoCOFINSQuantidade><CST>03</CST><qBCProd>99999999999.9999</qBCProd><vAliqProd>9999999999.0000</vAliqProd><vCOFINS>999999999999.00</vCOFINS></NFNotaInfoItemImpostoCOFINSQuantidade>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoCOFINSQuantidade().toString());
    }
}