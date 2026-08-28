package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFNotaInfoItemProdutoDetalhamentoTest {

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProdutoDetalhamento produtoDetalhamento = new NFNotaInfoItemProdutoDetalhamento();
        produtoDetalhamento.setCodigoFiscalProduto("1234567890123");
        produtoDetalhamento.setCodigoOperacaoNFF("4");

        final String xmlEsperado = "<NFNotaInfoItemProdutoDetalhamento><cProdFisco>1234567890123</cProdFisco><cOperNFF>4</cOperNFF></NFNotaInfoItemProdutoDetalhamento>";
        Assertions.assertEquals(xmlEsperado, produtoDetalhamento.toString());
    }

}