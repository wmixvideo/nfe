package com.fincatto.documentofiscal.nfe400.classes.nota;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class NFNotaInfoItemProdutoMedicamentoTest {

    @Test(expected = NumberFormatException.class)
    public void naoDevePermitirPrecoMaximoConsumidorComTamanhoInvalido() {
        new NFNotaInfoItemProdutoMedicamento().setPrecoMaximoConsumidor(new BigDecimal("10000000000000"));
    }

    @Test(expected = IllegalStateException.class)
    public void naoDevePermitirCodigoAnvisaComTamanhoInvalido() {
        new NFNotaInfoItemProdutoMedicamento().setCodigoProdutoAnvisa("1234567890");
        new NFNotaInfoItemProdutoMedicamento().setCodigoProdutoAnvisa("12345678901234");
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
        medicamento.setCodigoProdutoAnvisa("1234567890123");
        medicamento.setPrecoMaximoConsumidor(new BigDecimal("9999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemProdutoMedicamento><cProdANVISA>1234567890123</cProdANVISA><vPMC>9999999.99</vPMC></NFNotaInfoItemProdutoMedicamento>";
        Assert.assertEquals(xmlEsperado, medicamento.toString());
    }
}