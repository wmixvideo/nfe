package com.fincatto.documentofiscal.nfe400.classes.nota;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoDetalhamentoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProdutoDetalhamento produtoDetalhamento = new NFNotaInfoItemProdutoDetalhamento();
        produtoDetalhamento.setCodigoFiscalProduto("1234567890123");
        produtoDetalhamento.setCodigoOperacaoNFF("4");

        final String xmlEsperado = "<NFNotaInfoItemProdutoDetalhamento><cProdFisco>1234567890123</cProdFisco><cOperNFF>4</cOperNFF></NFNotaInfoItemProdutoDetalhamento>";
        Assert.assertEquals(xmlEsperado, produtoDetalhamento.toString());
    }

}