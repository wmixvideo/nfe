package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemProdutoMedicamentoTest {

    @Test
    public void naoDevePermitirPrecoMaximoConsumidorComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoMedicamento().setPrecoMaximoConsumidor(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirCodigoAnvisaComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new NFNotaInfoItemProdutoMedicamento().setCodigoProdutoAnvisa("1234567890");
            new NFNotaInfoItemProdutoMedicamento().setCodigoProdutoAnvisa("12345678901234");
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
        medicamento.setCodigoProdutoAnvisa("1234567890123");
        medicamento.setPrecoMaximoConsumidor(new BigDecimal("9999999.99"));

        final String xmlEsperado = "<NFNotaInfoItemProdutoMedicamento><cProdANVISA>1234567890123</cProdANVISA><vPMC>9999999.99</vPMC></NFNotaInfoItemProdutoMedicamento>";
        Assertions.assertEquals(xmlEsperado, medicamento.toString());
    }
}