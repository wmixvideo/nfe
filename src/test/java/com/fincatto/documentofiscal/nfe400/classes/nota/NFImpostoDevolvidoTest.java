package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;

public class NFImpostoDevolvidoTest {

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirValorIPIDevolvidoNula() {
        final NFImpostoDevolvido impostoDevolvido = new NFImpostoDevolvido();
        impostoDevolvido.setPercentualDevolucao(new BigDecimal("999.99"));
        impostoDevolvido.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirPercentualDevolucaoNula() {
        final NFImpostoDevolvido impostoDevolvido = new NFImpostoDevolvido();
        impostoDevolvido.toString();
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirImportacaoPIPDevolvidaNula() {
        final NFImpostoDevolvido impostoDevolvido = new NFImpostoDevolvido();
        impostoDevolvido.setPercentualDevolucao(new BigDecimal("100"));
        impostoDevolvido.toString();
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFImpostoDevolvido><pDevol>100.00</pDevol><IPI><vIPIDevol>9999999999999.99</vIPIDevol></IPI></NFImpostoDevolvido>";
        Assert.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFImpostoDevolvido().toString());
    }
}