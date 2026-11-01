package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFImpostoDevolvidoTest {

    @Test
    public void naoDevePermitirValorIPIDevolvidoNula() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFImpostoDevolvido impostoDevolvido = new NFImpostoDevolvido();
            impostoDevolvido.setPercentualDevolucao(new BigDecimal("999.99"));
            impostoDevolvido.toString();
        });
    }

    @Test
    public void naoDevePermitirPercentualDevolucaoNula() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFImpostoDevolvido impostoDevolvido = new NFImpostoDevolvido();
            impostoDevolvido.toString();
        });
    }

    @Test
    public void naoDevePermitirImportacaoPIPDevolvidaNula() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFImpostoDevolvido impostoDevolvido = new NFImpostoDevolvido();
            impostoDevolvido.setPercentualDevolucao(new BigDecimal("100"));
            impostoDevolvido.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFImpostoDevolvido><pDevol>100.00</pDevol><IPI><vIPIDevol>9999999999999.99</vIPIDevol></IPI></NFImpostoDevolvido>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFImpostoDevolvido().toString());
    }
}