package com.fincatto.documentofiscal.nfe400.classes.nota;

import com.fincatto.documentofiscal.nfe400.FabricaDeObjetosFake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoImportacaoTest {

    @Test
    public void naoDevePermitirValorBaseCalculoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoImportacao().setValorBaseCalculo(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirValorDespesaAduaneiraTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoImportacao().setValorDespesaAduaneira(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirImpostoImportacaoTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoImportacao().setValorImpostoImportacao(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirValorIOFTamanhoInvalido() {
        Assertions.assertThrows(NumberFormatException.class, () -> new NFNotaInfoItemImpostoImportacao().setValorIOF(new BigDecimal("99999999999999")));
    }

    @Test
    public void naoDevePermitirValorBaseCalculoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
            importacao.setValorDespesaAduaneira(new BigDecimal("999999999999.99"));
            importacao.setValorImpostoImportacao(new BigDecimal("999999999999.99"));
            importacao.setValorIOF(new BigDecimal("999999999999.99"));
            importacao.toString();
        });
    }

    @Test
    public void naoDevePermitirValorDespesaAduaneiraNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
            importacao.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            importacao.setValorImpostoImportacao(new BigDecimal("999999999999.99"));
            importacao.setValorIOF(new BigDecimal("999999999999.99"));
            importacao.toString();
        });
    }

    @Test
    public void naoDevePermitirImpostoImportacaoNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
            importacao.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            importacao.setValorDespesaAduaneira(new BigDecimal("999999999999.99"));
            importacao.setValorIOF(new BigDecimal("999999999999.99"));
            importacao.toString();
        });
    }

    @Test
    public void naoDevePermitirValorIOFNulo() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            final NFNotaInfoItemImpostoImportacao importacao = new NFNotaInfoItemImpostoImportacao();
            importacao.setValorBaseCalculo(new BigDecimal("999999999999.99"));
            importacao.setValorDespesaAduaneira(new BigDecimal("999999999999.99"));
            importacao.setValorImpostoImportacao(new BigDecimal("999999999999.99"));
            importacao.toString();
        });
    }

    @Test
    public void deveGerarXMLDeAcordoComOPadraoEstabelecido() {
        final String xmlEsperado = "<NFNotaInfoItemImpostoImportacao><vBC>999999999999.99</vBC><vDespAdu>999999999999.99</vDespAdu><vII>999999999999.99</vII><vIOF>999999999999.99</vIOF></NFNotaInfoItemImpostoImportacao>";
        Assertions.assertEquals(xmlEsperado, FabricaDeObjetosFake.getNFNotaInfoItemImpostoImportacao().toString());
    }
}