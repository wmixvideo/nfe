package com.fincatto.documentofiscal.nfe400.classes.nota;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoDetalhamentoEmbalagemTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProdutoDetalhamentoEmbalagem detalhamentoEmbalagem = new NFNotaInfoItemProdutoDetalhamentoEmbalagem();
        detalhamentoEmbalagem.setEmbalagemProduto("123456");
        detalhamentoEmbalagem.setUnidadeMedidaEmbalagem("CM");
        detalhamentoEmbalagem.setVolumeProdutoEmbalagem(BigDecimal.TEN);

        final String xmlEsperado = "<NFNotaInfoItemProdutoDetalhamentoEmbalagem><xEmb>123456</xEmb><qVolEmb>10.000</qVolEmb><uEmb>CM</uEmb></NFNotaInfoItemProdutoDetalhamentoEmbalagem>";
        Assert.assertEquals(xmlEsperado, detalhamentoEmbalagem.toString());
    }

}