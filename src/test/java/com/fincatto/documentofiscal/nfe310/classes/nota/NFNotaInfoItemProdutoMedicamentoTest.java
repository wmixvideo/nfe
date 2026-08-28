package com.fincatto.documentofiscal.nfe310.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFNotaInfoItemProdutoMedicamentoTest {

    @Test
    public void naoDevePermitirLoteComTamanhoInvalido() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            try {
                new NFNotaInfoItemProdutoMedicamento().setLote("");
            } catch (final IllegalStateException e) {
                new NFNotaInfoItemProdutoMedicamento().setLote("yq50jVDZsvQVNuWoS45U1");
            }
        });
    }

    @Test
    public void naoDevePermitirPrecoMaximoConsumidorComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoMedicamento().setPrecoMaximoConsumidor(new BigDecimal("10000000000000")));
    }

    @Test
    public void naoDevePermitirQuantidadeComTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemProdutoMedicamento().setQuantidade(new BigDecimal("100000000")));
    }

    @Test
    public void naoDevePermitirDataFabricacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
            medicamento.setDataValidade(LocalDate.of(2015, 1, 1));
            medicamento.setLote("yq50jVDZsvQVNuWoS45U");
            medicamento.setPrecoMaximoConsumidor(new BigDecimal("999999999999.99"));
            medicamento.setQuantidade(new BigDecimal("9999999.999"));
            medicamento.toString();
        });
    }

    @Test
    public void naoDevePermitirDataValidadeNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
            medicamento.setDataFabricacao(LocalDate.of(2014, 1, 1));
            medicamento.setLote("yq50jVDZsvQVNuWoS45U");
            medicamento.setPrecoMaximoConsumidor(new BigDecimal("999999999999.99"));
            medicamento.setQuantidade(new BigDecimal("9999999.999"));
            medicamento.toString();
        });
    }

    @Test
    public void naoDevePermitirLoteNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
            medicamento.setDataFabricacao(LocalDate.of(2014, 1, 1));
            medicamento.setDataValidade(LocalDate.of(2015, 1, 1));
            medicamento.setPrecoMaximoConsumidor(new BigDecimal("999999999999.99"));
            medicamento.setQuantidade(new BigDecimal("9999999.999"));
            medicamento.toString();
        });
    }

    @Test
    public void naoDevePermitirPrecoMaximoConsumidorNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
            medicamento.setDataFabricacao(LocalDate.of(2014, 1, 1));
            medicamento.setDataValidade(LocalDate.of(2015, 1, 1));
            medicamento.setLote("yq50jVDZsvQVNuWoS45U");
            medicamento.setQuantidade(new BigDecimal("9999999.999"));
            medicamento.toString();
        });
    }

    @Test
    public void naoDevePermitirQuantidadeNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
            medicamento.setDataFabricacao(LocalDate.of(2014, 1, 1));
            medicamento.setDataValidade(LocalDate.of(2015, 1, 1));
            medicamento.setLote("yq50jVDZsvQVNuWoS45U");
            medicamento.setPrecoMaximoConsumidor(new BigDecimal("999999999999.99"));
            medicamento.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final NFNotaInfoItemProdutoMedicamento medicamento = new NFNotaInfoItemProdutoMedicamento();
        medicamento.setDataFabricacao(LocalDate.of(2014, 1, 1));
        medicamento.setDataValidade(LocalDate.of(2015, 1, 1));
        medicamento.setLote("yq50jVDZsvQVNuWoS45U");
        medicamento.setPrecoMaximoConsumidor(new BigDecimal("999999999999.99"));
        medicamento.setQuantidade(new BigDecimal("9999999.999"));

        final String xmlEsperado = "<NFNotaInfoItemProdutoMedicamento><nLote>yq50jVDZsvQVNuWoS45U</nLote><qLote>9999999.999</qLote><dFab>2014-01-01</dFab><dVal>2015-01-01</dVal><vPMC>999999999999.99</vPMC></NFNotaInfoItemProdutoMedicamento>";
        Assertions.assertEquals(xmlEsperado, medicamento.toString());
    }
}